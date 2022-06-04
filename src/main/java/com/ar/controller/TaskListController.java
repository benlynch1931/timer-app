package com.ar.controller;

import com.ar.config.CellFactory;
import com.ar.config.ComponentSize;
import com.ar.config.DisplayType;
import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.PresetService;
import com.ar.service.TaskService;
import com.ar.utils.ComponentUtils;
import com.ar.utils.TaskUtils;
import com.ar.utils.TimeUtils;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class TaskListController {

    @FXML
    private TableView<TaskDto> table = new TableView<>();

    @FXML
    private Label presetName;
    @FXML
    private Label duration;
    @FXML
    private Button back;
    @FXML
    private Button edit;

    private PresetDto preset;

    private final HostServices hostServices;

    private final PresetService presetService;
    private final TaskService taskService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;
    
    private final CellFactory cellFactory;

    private void setButtonInfo() {
        back.setText("BACK");
        edit.setText("EDIT");
        ComponentUtils.setTaskListButtonDimensions(back);
        ComponentUtils.setTaskListButtonDimensions(edit);
        back.setOnAction(screenController::switchToPresetListView);
        edit.setOnAction(screenController::switchToPresetView);
    }

    private void setTitleInfo() {
        presetName.relocate(0, ComponentSize.TASKLIST_TITLE_TOP);
        presetName.setMinWidth(ComponentSize.SCREEN_WIDTH);
        presetName.setFont(new Font(ComponentSize.TASKLIST_TITLE_SIZE));
        presetName.setAlignment(Pos.CENTER);
        presetName.setText(preset.getName());
    }

    private void setDurationInfo() {
        duration.relocate(0, ComponentSize.TASKLIST_DURATION_TOP);
        duration.setMinWidth(ComponentSize.SCREEN_WIDTH);
        duration.setFont(new Font(ComponentSize.TASKLIST_DURATION_SIZE));
        duration.setAlignment(Pos.CENTER);
        duration.setText(TimeUtils.convertSecondsToTime(preset.getDuration()));
    }

    public void generateTaskList() {
        table.relocate(0, ComponentSize.TASKLIST_TABLE_TOP);
        table.setTranslateX(ComponentSize.TABLE_MARGIN);
        table.setMaxWidth(ComponentSize.TABLE_WIDTH);
        table.setMinWidth(ComponentSize.TABLE_WIDTH);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final TableColumn c1 = new TableColumn("Name");
        final TableColumn c2 = new TableColumn("Duration");
        c2.setMaxWidth(ComponentSize.COL_OTHER_WIDTH);
        c2.setMinWidth(ComponentSize.COL_OTHER_WIDTH);

        c1.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<>(""));


        c1.setCellFactory(cellFactory.taskButton());
        c2.setCellFactory(cellFactory.durationText());

        table.getColumns().addAll(c1, c2);
        table.setItems(TaskUtils.formatList(preset.getTaskList(), DisplayType.ADD));
    }

    @FXML
    public void initialize() {
        presetName.setText("Task List View");
        final var presetId = currentRecordViewService.getTaskListRecordId();
        preset = presetService.getPreset(presetId);
        setTitleInfo();
        setDurationInfo();
        setButtonInfo();
        generateTaskList();
    }
}

