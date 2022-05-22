package com.ar.controller;

import com.ar.config.CellFactory;
import com.ar.config.ItemSize;
import com.ar.dto.PresetDto;
import com.ar.service.PresetService;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class PresetController {

    @FXML
    private TableView<PresetDto> table = new TableView<>();

    @FXML
    private Label label;
    @FXML
    private Button button;

    @FXML
    private VBox vBox;

    private final HostServices hostServices;

    private final PresetService presetService;

    private final CellFactory cellFactory;

    public void generatePresetList() {
        table.setTranslateX(ItemSize.TABLE_MARGIN);
        table.setMaxWidth(ItemSize.TABLE_WIDTH);
        table.setMinWidth(ItemSize.TABLE_WIDTH);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn c1 = new TableColumn("Name");
        TableColumn c2 = new TableColumn("Ready At");
        TableColumn c3 = new TableColumn(""); // Start
        c2.setMaxWidth(ItemSize.COL_OTHER_WIDTH);
        c2.setMinWidth(ItemSize.COL_OTHER_WIDTH);
        c3.setMaxWidth(ItemSize.COL_OTHER_WIDTH);
        c3.setMinWidth(ItemSize.COL_OTHER_WIDTH);

        c1.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<>("readyAt"));
        c3.setCellValueFactory(new PropertyValueFactory<>(""));


        c1.setCellFactory(cellFactory.presetButton());
        c3.setCellFactory(cellFactory.startButton());

        table.getColumns().addAll(c1, c2, c3);
        table.setItems(presetService.getPresetList());
    }

    @FXML
    public void initialize() {
        this.button.setOnAction(actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
        generatePresetList();
    }
}

