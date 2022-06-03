package com.ar.controller;

import com.ar.config.ComponentSize;
import com.ar.config.FormatType;
import com.ar.dto.TaskDto;
import com.ar.mapper.TaskMapper;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.TaskService;
import com.ar.utils.ComponentUtils;
import com.ar.utils.ObjectUtils;
import com.ar.utils.TaskUtils;
import com.ar.validator.NameValidator;
import com.ar.validator.TimeValidator;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class TaskController {

    @FXML
    private AnchorPane buttonBox;
    @FXML
    private AnchorPane durationPane;
    @FXML
    private AnchorPane nameBox;

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

    private final HostServices hostServices;

    private final TaskService taskService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;

    private void setContainerMeasures() {
        ComponentUtils.setTaskContainerSize(buttonBox);
        ComponentUtils.setTaskContainerSize(nameBox, ComponentSize.TASK_NAME_BOX_HGT);
        ComponentUtils.setTaskContainerSize(durationPane, ComponentSize.TASK_DURATION_PANE_HGT);

        buttonBox.relocate(0, ComponentSize.TASK_BUTTON_BOX_TOP);
        nameBox.relocate(0, ComponentSize.TASK_NAME_BOX_TOP);
        durationPane.relocate(0, ComponentSize.TASK_DURATION_PANE_TOP);


    }

    private void setTaskInfo() {
        taskName.setPromptText("Task Name");
        hours.setPromptText("HH");
        minutes.setPromptText("MM");
        seconds.setPromptText("SS");
        if (ObjectUtils.isNotNull(task.getDuration())) {
            String[] duration = TaskUtils.convertSecondsToTime(task.getDuration()).split(":");
            TaskUtils.formatDurationText(duration, FormatType.DISPLAY);
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
        ComponentUtils.setTaskNameComponentDimensions(taskName);
        ComponentUtils.setDurationComponentDimensions(hours, 0);
        ComponentUtils.setDurationComponentDimensions(minutes, 1);
        ComponentUtils.setDurationComponentDimensions(seconds, 2);
    }

    private void setTimeErrorLabel() {
        setErrorLabel(timeError, ComponentSize.TASK_TIME_ERROR_TOP);
    }

    private void setNameErrorLabel() {
        setErrorLabel(nameError, ComponentSize.TASK_NAME_ERROR_TOP);
    }

    private void setErrorLabel(final Label label, final double topMargin) {
        label.setTextFill(Paint.valueOf("#FF0000"));
        label.setFont(new Font(ComponentSize.TASK_ERROR_SIZE));
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(ComponentSize.SCREEN_WIDTH);
        label.relocate(0, topMargin);
    }

    private void updateTaskInfo() {
        task.setName(taskName.getText());
        task.setDuration(TaskUtils.convertTimeToSeconds(getTimeValues()));
    }

    private void setButtonInfo() {
        save.setText("SAVE");
        back.setText("BACK");
        ComponentUtils.setTaskButtonDimensions(save);
        ComponentUtils.setTaskButtonDimensions(back);
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
                updateTaskInfo();
                taskService.saveOrUpdateTask(task);
                screenController.switchToTaskListView(event);
            }
        });
        back.setOnAction(screenController::switchToTaskListView);
    }

    private String[] getTimeValues() {
        return TaskUtils.formatDurationText(new String[]{ hours.getText(), minutes.getText(), seconds.getText() }, FormatType.SAVE);
    }

    @FXML
    public void initialize() {
        task = TaskMapper.mapToDto(currentRecordViewService.getTaskRecord());
        setButtonInfo();
        setComponentDimensions();
        setTaskInfo();
        setContainerMeasures();
        setTimeErrorLabel();
        setNameErrorLabel();
        nameBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
}

