package com.ar.controller;

import com.ar.dto.PresetDto;
import com.ar.service.PresetService;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class TaskListController {

    @FXML
    private TableView<PresetDto> table = new TableView<>();

    @FXML
    private Label label;
    @FXML
    private Button button;

    @FXML
    private VBox vbox;

    private final HostServices hostServices;

    private final PresetService presetService;


    private static final int SCREEN_WIDTH = 414;
    private static final int TABLE_MARGIN = 5;
    private static final int TABLE_WIDTH = SCREEN_WIDTH - (2*TABLE_MARGIN);
    private static final int COL_PRESET_WIDTH = 210;
    private static final int COL_OTHER_WIDTH = (TABLE_WIDTH - COL_PRESET_WIDTH) / 2;

    public void generatePresetList() {
        table.setTranslateX(TABLE_MARGIN);
        table.setMaxWidth(TABLE_WIDTH);
        table.setMinWidth(TABLE_WIDTH);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn c1 = new TableColumn("Name");
        TableColumn c2 = new TableColumn("Ready At");
        TableColumn c3 = new TableColumn(""); // Start
        c2.setMaxWidth(COL_OTHER_WIDTH);
        c2.setMinWidth(COL_OTHER_WIDTH);
        c3.setMaxWidth(COL_OTHER_WIDTH);
        c3.setMinWidth(COL_OTHER_WIDTH);

        c1.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<>("readyAt"));
        c3.setCellValueFactory(new PropertyValueFactory<>(""));


        table.getColumns().addAll(c1, c2, c3);

        table.setItems(presetService.getPresetList());
    }

    @FXML
    public void initialize() {
        label.setText("Task List View");
        this.button.setOnAction(actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
        generatePresetList();
    }
}

