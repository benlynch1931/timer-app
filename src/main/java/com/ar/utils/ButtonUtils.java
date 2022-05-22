package com.ar.utils;

import com.ar.config.ComponentSize;
import com.ar.controller.ScreenController;
import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.PresetService;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 * @author Ben Lynch
 */
public class ButtonUtils {
    
    private ButtonUtils() {}


    public static Button createPresetBtn(final PresetDto currentPreset, final ScreenController screenController, final CurrentRecordViewService currentRecordViewService) {
        final Button presetButton = new Button();
        presetButton.setMinWidth(ComponentSize.COL_PRESET_WIDTH - 10);
        presetButton.setOnAction(event -> {
            if (currentPreset.getName().equals("New Preset")) {
                // TODO: View Create Preset
            } else {
                final boolean updatedRecord = currentRecordViewService.updateRecord("TASKLIST", currentPreset.getId());
                screenController.switchToTaskListView(event);
                // TODO: View tasks of Preset
            }
        });
        presetButton.setText(currentPreset.getName());
        return presetButton;
    }

    public static Button createTaskBtn(final TaskDto currentTask, final ScreenController screenController, final CurrentRecordViewService currentRecordViewService) {
        final Button taskButton = new Button();
        taskButton.setMinWidth(ComponentSize.COL_PRESET_WIDTH - 10);
        taskButton.setOnAction(event -> {
            if (currentTask.getName().equals("New Task")) {
                // TODO: View Create Task
            } else {
                screenController.switchToTaskView(event);
                // TODO: View Task
            }
        });
        taskButton.setText(currentTask.getName());
        return taskButton;
    }

    /**
     * Creates start button and functionality for a preset
     * @param currentPreset information about current preset
     * @param presetService PresetService to perform operations
     * @param tableCell TableCell to update graphic of cell
     * @return Start button
     */
    public static Button createStartButton(final PresetDto currentPreset, final PresetService presetService, final TableCell<PresetDto, String> tableCell){
        final Button startButton = new Button("Start");
        startButton.setMinWidth(ComponentSize.COL_OTHER_WIDTH - 5);
        startButton.setOnAction(event -> {
            presetService.generateTaskTimers(currentPreset);
            tableCell.setGraphic(createCancelButton(currentPreset, presetService, tableCell));
        });
        return startButton;
    }

    /**
     * Creates cancel button and functionality for a preset
     * @param currentPreset information about current preset
     * @param presetService PresetService to perform operations
     * @param tableCell TableCell to update graphic of cell
     * @return Cancel button
     */
    public static Button createCancelButton(PresetDto currentPreset, PresetService presetService, TableCell<PresetDto, String> tableCell) {
        final Button cancelButton = new Button("Cancel");
        cancelButton.setMinWidth(ComponentSize.COL_OTHER_WIDTH - 5);
        cancelButton.setOnAction(event -> {
            presetService.cancelActiveTaskTimers(currentPreset);
            tableCell.setGraphic(createStartButton(currentPreset, presetService, tableCell));
        });
        return cancelButton;
    }
}
