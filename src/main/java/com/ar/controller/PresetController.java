package com.ar.controller;

import com.ar.config.CellFactory;
import com.ar.config.ComponentSize;
import com.ar.config.DisplayType;
import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.PresetService;
import com.ar.utils.ComponentUtils;
import com.ar.utils.ObjectUtils;
import com.ar.utils.TaskUtils;
import com.ar.validator.NameValidator;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class PresetController {

    @FXML
    private TableView<TaskDto> table = new TableView<>();

    @FXML
    private AnchorPane buttonBox;
    @FXML
    private AnchorPane taskListBox;
    @FXML
    private AnchorPane nameBox;
    @FXML
    private TextField presetName;
    @FXML
    private Button save;
    @FXML
    private Button back;
    @FXML
    private Label nameError;

    @Getter
    private PresetDto preset;

    private final HostServices hostServices;

    private final PresetService presetService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;
    private final CellFactory cellFactory;

    public void generateTaskList() {
        table.relocate(0, ComponentSize.LIST_TABLE_TOP);
        table.setTranslateX(ComponentSize.TABLE_MARGIN);
        table.setMaxWidth(ComponentSize.TABLE_WIDTH);
        table.setMinWidth(ComponentSize.TABLE_WIDTH);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final TableColumn c1 = new TableColumn("Name");
        final TableColumn c2 = new TableColumn("Duration");
        final TableColumn c3 = new TableColumn("");
        c2.setMaxWidth(ComponentSize.COL_OTHER_WIDTH);
        c2.setMinWidth(ComponentSize.COL_OTHER_WIDTH);
        c3.setMaxWidth(ComponentSize.COL_DELETE_WIDTH);
        c3.setMinWidth(ComponentSize.COL_DELETE_WIDTH);

        c1.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<>(""));
        c3.setCellValueFactory(new PropertyValueFactory<>(""));


        c1.setCellFactory(cellFactory.taskButton());
        c2.setCellFactory(cellFactory.durationText());
        c3.setCellFactory(cellFactory.deleteTaskButton());
        // TODO: delete button [only from list -> not db until save()]

        table.getColumns().addAll(c1, c2, c3);
        table.setItems(TaskUtils.formatList(preset.getTaskList(), DisplayType.DELETE));
    }

    private void setErrorLabel(final Label label, final double topMargin) {
        label.setTextFill(Paint.valueOf("#FF0000"));
        label.setFont(new Font(ComponentSize.TASK_ERROR_SIZE));
        label.setAlignment(Pos.CENTER);
        label.setMinWidth(ComponentSize.SCREEN_WIDTH);
        label.relocate(0, topMargin);
    }

    private void setPresetInfo() {
        presetName.setPromptText("Preset Name");
        if (ObjectUtils.isNotNull(preset.getName())) {
            presetName.setText(preset.getName());
        } else {
            presetName.setPromptText("New Preset");
        }
        generateTaskList();
    }

    private void updatePresetInfo() {
        preset.setName(presetName.getText());
        preset.setDuration(presetService.getPresetNewDuration(preset.getTaskList()));
    }

    private void setButtonInfo() {
        save.setText("SAVE");
        back.setText("BACK");
        ComponentUtils.setTaskButtonDimensions(save);
        ComponentUtils.setTaskButtonDimensions(back);
        save.setOnAction(event -> {
            var nameValid = NameValidator.validateName(presetName.getText());
            if (nameValid) {
                updatePresetInfo();
                presetService.saveOrUpdateTask(preset);
                screenController.switchToPresetListView(event);
            } else {
                nameError.setText("Preset name cannot be empty...");
            }

        });
        back.setOnAction(screenController::switchToTaskListView);
    }

    private void setContainerMeasures() {
        ComponentUtils.setTaskContainerSize(buttonBox);
        ComponentUtils.setTaskContainerSize(nameBox, ComponentSize.TASK_NAME_BOX_HGT);
        ComponentUtils.setTaskContainerSize(taskListBox, ComponentSize.TASK_DURATION_PANE_HGT);

        buttonBox.relocate(0, ComponentSize.PRESET_BUTTON_BOX_TOP);
        nameBox.relocate(0, ComponentSize.PRESET_NAME_BOX_TOP);
        taskListBox.relocate(0, ComponentSize.PRESET_TASKLIST_BOX_TOP);
    }

    @FXML
    public void initialize() {
        var presetId = currentRecordViewService.getTaskListRecordId();
        preset = presetService.getPreset(presetId);
        setContainerMeasures();
        setPresetInfo();
        setButtonInfo();
        setErrorLabel(nameError, ComponentSize.TASK_NAME_ERROR_TOP);
        ComponentUtils.setTaskNameComponentDimensions(presetName);
    }
}

