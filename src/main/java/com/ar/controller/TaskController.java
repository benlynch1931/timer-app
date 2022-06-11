package com.ar.controller;

import com.ar.config.Dimensions;
import com.ar.config.FormatType;
import com.ar.dto.TaskDto;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.PresetService;
import com.ar.service.TaskService;
import com.ar.utils.ComponentUtils;
import com.ar.utils.ObjectUtils;
import com.ar.utils.TimeUtils;
import com.ar.validator.NameValidator;
import com.ar.validator.TimeValidator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class TaskController {

    @FXML
    private AnchorPane paneViewBtn;
    @FXML
    private AnchorPane paneDuration;
    @FXML
    private AnchorPane paneNameField;

    @FXML
    private TextField taskName;

    @FXML
    private Button save;
    @FXML
    private Button back;

    @FXML
    private TextField hours;
    @FXML
    private TextField minutes;
    @FXML
    private TextField seconds;

    @FXML
    private Label timeError;
    @FXML
    private Label nameError;


    private TaskDto task;
    private final TaskService taskService;
    private final PresetService presetService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;


    private void setTaskInfo() {
        taskName.setPromptText("Task Name");
        hours.setPromptText("HH");
        minutes.setPromptText("MM");
        seconds.setPromptText("SS");
        if (ObjectUtils.isNotNull(task.getDuration())) {
            String[] duration = TimeUtils.convertSecondsToTime(task.getDuration()).split(":");
            TimeUtils.formatDurationText(duration, FormatType.DISPLAY);
            hours.setText(duration[0]);
            minutes.setText(duration[1]);
            seconds.setText(duration[2]);
        }
        if (ObjectUtils.isNotNull(task.getName())) {
            taskName.setText(task.getName());
        } else {
            taskName.setPromptText("New Task");
        }
    }

    private void setComponentDimensions() {
        ComponentUtils.setPaneDimensions(paneViewBtn, Dimensions.PANE_VIEW_BTN);
        ComponentUtils.setPaneDimensions(paneNameField, Dimensions.PANE_NAME_FIELD);
        ComponentUtils.setPaneDimensions(paneDuration, Dimensions.PANE_DURATION_FIELD);

        ComponentUtils.setTextFieldDimensions(hours, Dimensions.HOURS_FIELD);
        ComponentUtils.setTextFieldDimensions(minutes, Dimensions.MINUTES_FIELD);
        ComponentUtils.setTextFieldDimensions(seconds, Dimensions.SECONDS_FIELD);
        ComponentUtils.setLabelDimensions(nameError, Dimensions.NAME_ERROR);
        ComponentUtils.setLabelDimensions(timeError, Dimensions.TIME_ERROR);

        ComponentUtils.setTextFieldDimensions(taskName, Dimensions.NAME_FIELD);

        ComponentUtils.setButtonDimensions(back, Dimensions.BACK_BTN);
        ComponentUtils.setButtonDimensions(save, Dimensions.SAVE_BTN);
    }

    private void setErrorLabelColour() {
        nameError.setTextFill(Paint.valueOf("#FF0000"));
        timeError.setTextFill(Paint.valueOf("#FF0000"));
    }

    private void updateTaskInfo() {
        task.setName(taskName.getText());
        task.setDuration(TimeUtils.convertTimeToSeconds(getTimeValues()));
    }

    private void setButtonInfo() {
        save.setText("SAVE");
        back.setText("BACK");
        save.setOnAction(event -> {
            boolean timeValid = TimeValidator.validateTimeValues(getTimeValues());
            boolean nameValid = NameValidator.validateName(taskName.getText());
            if (!timeValid) {
                timeError.setText("Error with time values...");
            }
            if (!nameValid) {
                nameError.setText("Task name cannot be empty...");
            }
            if (timeValid & nameValid) {
                timeError.setText("");
                nameError.setText("");
                updateTaskInfo();
                taskService.saveOrUpdateTask(task);
                presetService.updateDuration(task.getPresetId());
                screenController.switchToTaskListView(event);
            }
        });
        back.setOnAction(screenController::switchToTaskListView);
    }

    private String[] getTimeValues() {
        return TimeUtils.formatDurationText(new String[]{ hours.getText(), minutes.getText(), seconds.getText() }, FormatType.SAVE);
    }

    @FXML
    public void initialize() {
        task = taskService.getTaskForDisplay(currentRecordViewService);
        setButtonInfo();
        setComponentDimensions();
        setTaskInfo();
        setErrorLabelColour();
    }
}

