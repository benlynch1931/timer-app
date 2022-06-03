package com.ar.service;

import com.ar.config.UpdateType;
import com.ar.dto.PresetDto;
import com.ar.entity.Preset;
import com.ar.mapper.PresetMapper;
import com.ar.repository.ActiveTaskRepo;
import com.ar.repository.PresetRepo;
import com.ar.utils.PresetUtils;
import com.ar.utils.TaskUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Ben Lynch
 */
@Component
public class PresetService {
    // TODO: Stop preset -> clear active timers

    private final PresetRepo presetRepo;

    private final ActiveTaskRepo activeTaskRepo;

    @Getter
    private ObservableList<PresetDto> presetList;

    private final ApplicationContext applicationContext;

    public PresetService(PresetRepo presetRepo, ActiveTaskRepo activeTaskRepo, ApplicationContext applicationContext) {
        this.presetRepo = presetRepo;
        this.activeTaskRepo = activeTaskRepo;
        this.applicationContext = applicationContext;
        this.presetList = formatList(this.presetRepo.findAll());
    }

    public PresetDto getPreset(BigInteger presetId) {
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
        presetRepo.deleteByPresetId(preset.getId());
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
                boolean allTasksFinished = PresetUtils.checkTaskStatus(activeTaskRepo, activePresetId);
                if(allTasksFinished) {
                    cancel();
                };
            }
        }, 1_000, 1_000);
    }

//    public void setTaskScene(Scene currentScene) {
//        FXMLLoader taskFXML = new FXMLLoader(getClass().getResource("classpath:/task.fxml"));
//        taskFXML.setControllerFactory(applicationContext::getBean);
//        Scene scene = new Scene(currentScene.getRoot(),  414, 896);
//        scene.setFill(Color.web("#E3E3E3"));
//    }

//    public void addTask(int presetIdx, Task newTask) {
//        presetList.get(presetIdx).getTaskList().add(newTask);
//        updateDuration(presetList.get(presetIdx), newTask.getDuration(), UpdateType.ADD);
//        savePreset(presetList.get(presetIdx));
//    }
//
//    public void removeTask(int presetIdx , Task taskToRemove) {
//        presetList.get(presetIdx).getTaskList().remove(taskToRemove);
//        updateDuration(presetList.get(presetIdx), taskToRemove.getDuration(), UpdateType.SUBTRACT);
//        savePreset(presetList.get(presetIdx));
//    }
//
//    public void editPresetName(int presetIdx, String name) {
//        presetList.get(presetIdx).setName(name);
//        savePreset(presetList.get(presetIdx));
//    }

    public void updateDuration(Preset preset, BigInteger duration, UpdateType updateType) {
        if (updateType == UpdateType.ADD) {
            preset.setDuration(preset.getDuration().add(duration));
        } else {
            preset.setDuration(preset.getDuration().subtract(duration));
        }
    }

    public void savePreset(Preset presetToUpdate) {
        presetRepo.save(presetToUpdate);
    }
}
