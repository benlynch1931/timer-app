package com.bl.utils;

import com.bl.config.ComponentSize;
import com.bl.controller.ScreenController;
import com.bl.dto.PresetDto;
import com.bl.dto.TaskDto;
import com.bl.service.CurrentRecordViewService;
import com.bl.service.PresetService;
import com.bl.service.TaskService;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
public class ButtonUtils {
    
    private ButtonUtils() {}


    /**
     * Creates button to switch view to task list of specific Preset
     * @param currentPreset Info of specific preset
     * @param screenController controls screen switching
     * @param currentRecordViewService service to set task info for the view
     * @return button
     */
    public static Button generateTaskListViewButton(final PresetDto currentPreset, final ScreenController screenController, final CurrentRecordViewService currentRecordViewService) {
        final Button presetButton = new Button();
        presetButton.setMinWidth(ComponentSize.COL_PRESET_WIDTH - 10);
        presetButton.setOnAction(event -> {
            if (currentPreset.getName().equals("New Preset")) {
                final boolean updatedRecord = currentRecordViewService.updateRecord("TASKLIST", BigInteger.ZERO);
                screenController.switchToPresetView(event);
            } else {
                final boolean updatedRecord = currentRecordViewService.updateRecord("TASKLIST", currentPreset.getId());
                screenController.switchToTaskListView(event);
            }
        });
        presetButton.setText(currentPreset.getName());
        return presetButton;
    }

    /**
     * Creates button to switch view to specific Task
     * @param currentTask Info of specific task
     * @param screenController controls screen switching
     * @param currentRecordViewService service to set task info for the view
     * @return button
     */
    public static Button generateTaskViewButton(final TaskDto currentTask, final ScreenController screenController, final CurrentRecordViewService currentRecordViewService) {
        final Button taskButton = new Button();
        taskButton.setMinWidth(ComponentSize.COL_PRESET_WIDTH - 10);
        taskButton.setOnAction(event -> {
            final boolean updatedRecord;
            if (currentTask.getName().equals("New Task")) {
                updatedRecord = currentRecordViewService.updateRecord("TASK", BigInteger.ZERO);
            } else {
                updatedRecord = currentRecordViewService.updateRecord("TASK", currentTask.getId());
                // TODO: View Task
            }
            screenController.switchToTaskView(event);
        });
        taskButton.setText(currentTask.getName());
        return taskButton;
    }

    public static Button generateDeleteTaskButton(final TaskDto currentTask, final TaskService taskService, final ScreenController screenController) {
        final Button deleteButton = new Button();
        deleteButton.setMinWidth(ComponentSize.COL_DELETE_WIDTH - 10);
        deleteButton.setOnAction(event -> {
            taskService.deleteTask(currentTask);
            screenController.switchToPresetView(event);
        });
//        deleteButton.setText("TEST");
        return deleteButton;
    }

    /**
     * Creates start button and functionality for a preset
     * @param currentPreset information about current preset
     * @param presetService PresetService to perform operations
     * @param tableCell TableCell to update graphic of cell
     * @return Start button
     */
    public static Button generateStartPresetButton(final PresetDto currentPreset, final PresetService presetService, final TableCell<PresetDto, String> tableCell){
        final Button startButton = new Button("Start");
        startButton.setMinWidth(ComponentSize.COL_OTHER_WIDTH - 5);
        startButton.setOnAction(event -> {
            presetService.generateTaskTimers(currentPreset);
            tableCell.setGraphic(generateCancelPresetButton(currentPreset, presetService, tableCell));
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
    public static Button generateCancelPresetButton(PresetDto currentPreset, PresetService presetService, TableCell<PresetDto, String> tableCell) {
        final Button cancelButton = new Button("Cancel");
        cancelButton.setMinWidth(ComponentSize.COL_OTHER_WIDTH - 5);
        cancelButton.setOnAction(event -> {
            presetService.cancelActiveTaskTimers(currentPreset);
            tableCell.setGraphic(generateStartPresetButton(currentPreset, presetService, tableCell));
        });
        return cancelButton;
    }
}
