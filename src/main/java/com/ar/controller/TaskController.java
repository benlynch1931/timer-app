package com.ar.controller;

import com.ar.config.ComponentSize;
import com.ar.dto.TaskDto;
import com.ar.mapper.TaskMapper;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.TaskService;
import com.ar.utils.ObjectUtils;
import com.ar.utils.TaskUtils;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class TaskController {

    @FXML
    private HBox buttonBox;
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

    private TaskDto task;

    private final HostServices hostServices;

    private final TaskService taskService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;

    public void setComponentBoxes() {
        buttonBox.setMinHeight(ComponentSize.TASK_BOX_HGT);
        nameBox.setMinHeight(ComponentSize.TASK_BOX_HGT);
        durationPane.setMinHeight(ComponentSize.TASK_BOX_HGT);
        buttonBox.setMaxHeight(ComponentSize.TASK_BOX_HGT);
        nameBox.setMaxHeight(ComponentSize.TASK_BOX_HGT);
        durationPane.setMaxHeight(ComponentSize.TASK_BOX_HGT);
        buttonBox.setTranslateY(ComponentSize.TASK_BUTTON_BOX_TOP);
        nameBox.setTranslateY(ComponentSize.TASK_NAME_BOX_TRANS_Y);
        durationPane.setTranslateY(ComponentSize.TASK_DURATION_PANE_TRANS_Y);

        buttonBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        nameBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        durationPane.setBorder(new Border(new BorderStroke(Paint.valueOf("#000000"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }


    public void setTaskInfo() {
        taskName.setPromptText("Task Name");
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
        if (ObjectUtils.isNotNull(task.getName())) {
            taskName.setText(task.getName());
        }
    }

    private void setComponentDimensions() {
//        setNameComponentDimensions(taskName);
        setDurationComponentDimensions(hours, 0);
        setDurationComponentDimensions(minutes, 1);
        setDurationComponentDimensions(seconds, 2);
    }

    public void setNameComponentDimensions(final TextField component) {
//        component.setMaxWidth(ComponentSize.TASK_NAME_FIELD_WIDTH);
//        component.setMinWidth(ComponentSize.TASK_NAME_FIELD_WIDTH);
        System.out.println(component.getLayoutY());
        System.out.println(component.getTranslateY());
//        component.setTranslateX(ComponentSize.TASK_NAME_FIELD_MARGIN);
    }

    public void setDurationComponentDimensions(final TextField component, final int fieldNo) {
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);

        int xCoordinate = (ComponentSize.TASK_DURATION_MARGIN) + (ComponentSize.TASK_DURATION_FIELDS * fieldNo) + (ComponentSize.TASK_DURATION_SPACER * fieldNo);
        component.relocate(xCoordinate, 0);
    }

    private void setButtonInfo() {
        save.setText("SAVE");
        back.setText("BACK");
        save.setOnAction(event -> {
            taskService.saveOrUpdateTask(task);
            screenController.switchToTaskListView(event);
        });

        back.setOnAction(screenController::switchToTaskListView);
    }

    @FXML
    public void initialize() {
        task = TaskMapper.mapToDto(currentRecordViewService.getTaskRecord());
        setButtonInfo();
        setComponentDimensions();
        setTaskInfo();
        setComponentBoxes();
    }
}

