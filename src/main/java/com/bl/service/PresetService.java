package com.bl.service;

import com.bl.dto.PresetDto;
import com.bl.entity.Preset;
import com.bl.entity.Task;
import com.bl.mapper.PresetMapper;
import com.bl.repository.ActiveTaskRepo;
import com.bl.repository.PresetRepo;
import com.bl.utils.TaskUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class PresetService {
    // TODO: Stop preset -> clear active timers

    private final PresetRepo presetRepo;

    private final ActiveTaskRepo activeTaskRepo;

    private final ActiveTaskService alarmService;


    public PresetDto getPreset(BigInteger presetId) {
        if (Objects.equals(presetId, BigInteger.ZERO)) {
            PresetDto preset = new PresetDto();
            preset.setTaskList(new ArrayList<>());
            return preset;
        }
        return PresetMapper.mapToDto(presetRepo.getById(presetId));
    }

    /**
     * Formats list to be compatible with JavaFX
     * @param presetList list to format
     * @return JavaFx compatible list
     */
    private ObservableList<PresetDto> formatList(List<Preset> presetList) {
        ObservableList<PresetDto> observableList = FXCollections.observableArrayList();
        presetList.forEach(preset -> observableList.add(PresetMapper.mapToDto(preset)));
        observableList.add(PresetDto.builder().name("New Preset").build());
        return observableList;
    }

    public ObservableList<PresetDto> getPresetListForDisplay() {
        return formatList(presetRepo.getAllPresetInOrder());
    }

    /**
     * Activates tasks and sets thread to check status of tasks
     * @param preset preset to activate tasks of
     */
    public void generateTaskTimers(PresetDto preset) {
        boolean completed = TaskUtils.createActiveTasks(activeTaskRepo, preset.getTaskList(), preset);
        if (completed) {
            startPreset(preset.getId());
        } else {
            System.out.println("ERROR");
        }
    }

    public void cancelActiveTaskTimers(PresetDto preset) {
        activeTaskRepo.deleteByPresetId(preset.getId());
    }


    /**
     * Scheduled task to check preset task's status
     * @param activePresetId preset id to be checking
     */
    private void startPreset(BigInteger activePresetId) {
        Timer presetTimer = new Timer();
        presetTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean allTasksFinished = alarmService.checkTaskStatus(activePresetId);
                if(allTasksFinished) {
                    cancel();
                };
            }
        }, 1_000, 1_000);
    }

    /**
     * Method to update preset with its new duration time, being the max duration of a task in the preset
     * @param presetId id of preset to update
     */
    public void updateDuration(final BigInteger presetId) {
        final Preset preset = presetRepo.getById(presetId);
        final List<Task> taskList = preset.getTaskList();
        taskList.sort((o1, o2) -> o2.getDuration().subtract(o1.getDuration()).intValue());
        preset.setDuration(taskList.get(0).getDuration().add(preset.getDelay()));
        presetRepo.save(preset);
    }

    /**
     * Method to update preset with its new duration time, being the max duration of a task in the preset
     * @param presetDto preset containing list of tasks to get max duration AND delay from
     * @return duration of preset
     */
    public BigInteger getPresetNewDuration(final PresetDto presetDto) {
        if (presetDto.getTaskList().isEmpty()) {
            return BigInteger.ZERO;
        }
        if (presetDto.getTaskList().size() > 1) {
            presetDto.getTaskList().sort((o1, o2) -> o2.getDuration().subtract(o1.getDuration()).intValue());
        }
        return presetDto.getTaskList().get(0).getDuration().add(presetDto.getDelay());
    }


    public void saveOrUpdateTask(final PresetDto preset) {
        presetRepo.save(PresetMapper.mapToEntity(preset));
    }

    public Preset clonePreset(PresetDto presetDto) {
        Preset preset = PresetMapper.mapToEntity(presetDto);
        preset.setName("CLONE - " + preset.getName());
        preset.setId(null);
        preset.getTaskList().forEach(task -> task.setId(null));
        return presetRepo.save(preset);
    }

    public void deletePreset(PresetDto currentPreset) {
        presetRepo.delete(PresetMapper.mapToEntity(currentPreset));
    }
}
