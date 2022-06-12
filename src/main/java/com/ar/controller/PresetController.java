package com.ar.controller;

import com.ar.config.CellFactory;
import com.ar.config.ComponentSize;
import com.ar.config.Dimensions;
import com.ar.config.DisplayType;
import com.ar.dto.PresetDto;
import com.ar.dto.TaskDto;
import com.ar.service.CurrentRecordViewService;
import com.ar.service.PresetService;
import com.ar.utils.ComponentUtils;
import com.ar.utils.ObjectUtils;
import com.ar.utils.TaskUtils;
import com.ar.validator.NameValidator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class PresetController {

    @FXML
    private AnchorPane paneViewBtn;
    @FXML
    private AnchorPane paneTable;
    @FXML
    private AnchorPane paneNameField;
    @FXML
    private AnchorPane paneDelayField;

    @FXML
    private TableView<TaskDto> table = new TableView<>();
    @FXML
    private Button save;
    @FXML
    private Button back;
    @FXML
    private TextField presetName;
    @FXML
    private Label nameError;
    @FXML
    private TextField delay;
    @FXML
    private Label delayLabel;
    @FXML
    private Label secondsLabel;

    private PresetDto preset;
    private final PresetService presetService;
    private final CurrentRecordViewService currentRecordViewService;
    private final ScreenController screenController;
    private final CellFactory cellFactory;

    public void generateTaskList() {

        final var c1 = new TableColumn("Name");
        final var c2 = new TableColumn("Duration");
        final var c3 = new TableColumn("");
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

    private void setComponentDimensions() {
        ComponentUtils.setPaneDimensions(paneTable, Dimensions.PANE_TABLE);
        ComponentUtils.setPaneDimensions(paneNameField, Dimensions.PANE_NAME_FIELD);
        ComponentUtils.setPaneDimensions(paneDelayField, Dimensions.PANE_DELAY_FIELD);
        ComponentUtils.setPaneDimensions(paneViewBtn, Dimensions.PANE_VIEW_BTN);

        ComponentUtils.setTableDimensions(table, Dimensions.TABLE);

        ComponentUtils.setTextFieldDimensions(presetName, Dimensions.NAME_FIELD);
        ComponentUtils.setLabelDimensions(nameError, Dimensions.NAME_ERROR);

        ComponentUtils.setTextFieldDimensions(delay, Dimensions.DELAY_FIELD);
        ComponentUtils.setLabelDimensions(delayLabel, Dimensions.DELAY_LABEL);
        ComponentUtils.setLabelDimensions(secondsLabel, Dimensions.SECONDS_LABEL);

        ComponentUtils.setButtonDimensions(back, Dimensions.BACK_BTN);
        ComponentUtils.setButtonDimensions(save, Dimensions.SAVE_BTN);
    }

    private void setErrorLabelColour(final Label label) {
        label.setTextFill(Paint.valueOf("#FF0000"));
    }

    private void setPresetInfo() {
        presetName.setPromptText("Preset Name");
        delay.setText(preset.getDelay().toString());
        delayLabel.setText("Delay: ");
        secondsLabel.setText("Seconds");
        if (ObjectUtils.isNotNull(preset.getName())) {
            presetName.setText(preset.getName());
        } else {
            presetName.setPromptText("New Preset");
        }
        generateTaskList();
    }

    private void updatePresetInfo() {
        preset.setName(presetName.getText());
        try {
            long delayLong = Long.parseLong(delay.getText());
            preset.setDelay(BigInteger.valueOf(delayLong));
        } catch(Exception e) {
            preset.setDelay(BigInteger.ZERO);
        }
        preset.setDuration(presetService.getPresetNewDuration(preset));
    }

    private void setButtonInfo() {
        save.setText("SAVE");
        back.setText("BACK");
        save.setOnAction(event -> {
            boolean nameValid = NameValidator.validateName(presetName.getText());
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


    @FXML
    public void initialize() {
        BigInteger presetId = currentRecordViewService.getTaskListRecordId();
        preset = presetService.getPreset(presetId);
        setComponentDimensions();
        setPresetInfo();
        setButtonInfo();
        setErrorLabelColour(nameError);
    }
}

