package com.bl.controller;

import com.bl.config.CellFactory;
import com.bl.config.ComponentSize;
import com.bl.config.Dimensions;
import com.bl.config.DisplayType;
import com.bl.dto.PresetDto;
import com.bl.dto.TaskDto;
import com.bl.service.CurrentRecordViewService;
import com.bl.service.PresetService;
import com.bl.utils.ComponentUtils;
import com.bl.utils.TaskUtils;
import com.bl.utils.TimeUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane paneViewBtn;
    @FXML
    private AnchorPane paneNameLabel;
    @FXML
    private AnchorPane paneTable;

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
    @FXML
    private Button clone;
    @FXML
    private Button delete;

    private PresetDto preset;

    private final PresetService presetService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;
    
    private final CellFactory cellFactory;

    private void setButtonInfo() {
        back.setText("BACK");
        edit.setText("EDIT");
        clone.setText("CLONE");
        delete.setText("DEL");

        back.setOnAction(screenController::switchToPresetListView);
        edit.setOnAction(screenController::switchToPresetView);
        clone.setOnAction(event -> {
            currentRecordViewService.updateRecord("TASKLIST", presetService.clonePreset(preset).getId());
            screenController.switchToTaskListView(event);
        });
        delete.setOnAction(event -> {
            presetService.deletePreset(preset);
            screenController.switchToPresetListView(event);
        });
    }

    private void setLabelInfo() {
        duration.setText(TimeUtils.convertSecondsToTime(preset.getDuration()));
        presetName.setText(preset.getName());
    }

    private void generateTaskList() {
        ComponentUtils.setTableDimensions(table, Dimensions.TABLE);
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

    private void setComponentDimensions() {
        ComponentUtils.setPaneDimensions(paneTable, Dimensions.PANE_TABLE);
        ComponentUtils.setPaneDimensions(paneNameLabel, Dimensions.PANE_NAME_LABEL);
        ComponentUtils.setPaneDimensions(paneViewBtn, Dimensions.PANE_VIEW_BTN);

        ComponentUtils.setTableDimensions(table, Dimensions.TABLE);

        ComponentUtils.setLabelDimensions(duration, Dimensions.DURATION_LABEL);
        ComponentUtils.setLabelDimensions(presetName, Dimensions.NAME_LABEL);

        ComponentUtils.setButtonDimensions(back, Dimensions.BACK_BTN);
        ComponentUtils.setButtonDimensions(edit, Dimensions.EDIT_BTN);
        ComponentUtils.setButtonDimensions(clone, Dimensions.CLONE_BTN);
        ComponentUtils.setButtonDimensions(delete, Dimensions.DELETE_BTN);
    }

    @FXML
    public void initialize() {
        presetName.setText("Task List View");
        final BigInteger presetId = currentRecordViewService.getTaskListRecordId();
        preset = presetService.getPreset(presetId);
        setComponentDimensions();
        setLabelInfo();
        setButtonInfo();
        generateTaskList();
    }
}

