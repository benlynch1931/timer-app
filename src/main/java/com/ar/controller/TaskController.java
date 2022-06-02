package com.ar.controller;

import com.ar.config.CellFactory;
import com.ar.config.ComponentSize;
import com.ar.dto.TaskDto;
import com.ar.entity.Task;
import com.ar.mapper.TaskMapper;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.PresetService;
import com.ar.service.TaskService;
import com.ar.utils.ComponentUtils;
import com.ar.utils.ObjectUtils;
import com.ar.utils.TaskUtils;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class TaskController {

    @FXML
    private Label label;

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
    private TextField taskName;

    private TaskDto task;

    private final HostServices hostServices;

    private final TaskService taskService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;


    public void setTaskInfo() {
        taskName.setText(task.getName());
        hours.setPromptText("HH");
        minutes.setPromptText("MM");
        seconds.setPromptText("SS");
        if (ObjectUtils.isNotNull(task.getDuration())) {
            final String[] duration = TaskUtils.convertSecondsToTime(task.getDuration()).split(":");
            TaskUtils.formatDurationText(duration);
            hours.setText(duration[0]);
            minutes.setText(duration[1]);
            seconds.setText(duration[2]);
        }
    }

    private void setComponentDimensions() {
        setDurationComponentDimensions(hours, 0);
        setDurationComponentDimensions(minutes, 1);
        setDurationComponentDimensions(seconds, 2);
    }

    public void setDurationComponentDimensions(final TextField component, final int fieldNo) {
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setLayoutY(ComponentSize.TASK_DURATION_TOP);
        component.setLayoutX(
                (ComponentSize.TASK_DURATION_MARGIN)
                + (ComponentSize.TASK_DURATION_FIELDS * fieldNo)
                + (ComponentSize.TASK_DURATION_SPACER * fieldNo)
        );
    }

    private void setButtonActions() {
        save.setOnAction(event -> {
            taskService.saveOrUpdateTask(task);
            screenController.switchToTaskListView(event);
        });

        back.setOnAction(screenController::switchToTaskListView);
    }

    @FXML
    public void initialize() {
        task = TaskMapper.mapToDto(currentRecordViewService.getTaskRecord());
        setButtonActions();
        setComponentDimensions();
        setTaskInfo();
    }
}

