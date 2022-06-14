package com.bl.controller;

import com.bl.config.CellFactory;
import com.bl.config.ComponentSize;
import com.bl.config.Dimensions;
import com.bl.dto.PresetDto;
import com.bl.service.PresetService;
import com.bl.utils.ComponentUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class PresetListController {

    @FXML
    private AnchorPane paneTable;
    @FXML
    private AnchorPane paneTitleLabel;

    @FXML
    private TableView<PresetDto> table = new TableView<>();
    @FXML
    private Label title;

    private final PresetService presetService;

    private final CellFactory cellFactory;

    private void generatePresetList() {
        TableColumn c1 = new TableColumn("Name");
        TableColumn c2 = new TableColumn("Ready At");
        TableColumn c3 = new TableColumn(""); // Start
        c2.setMaxWidth(ComponentSize.COL_OTHER_WIDTH);
        c2.setMinWidth(ComponentSize.COL_OTHER_WIDTH);
        c3.setMaxWidth(ComponentSize.COL_OTHER_WIDTH);
        c3.setMinWidth(ComponentSize.COL_OTHER_WIDTH);

        c1.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<>("readyAt"));
        c3.setCellValueFactory(new PropertyValueFactory<>(""));


        c1.setCellFactory(cellFactory.presetButton());
        c3.setCellFactory(cellFactory.startButton());

        table.getColumns().addAll(c1, c2, c3);
        table.setItems(presetService.getPresetListForDisplay());
    }

    private void setComponentDimensions() {
        ComponentUtils.setPaneDimensions(paneTable, Dimensions.PANE_TABLE);
        ComponentUtils.setPaneDimensions(paneTitleLabel, Dimensions.PANE_TITLE);

        ComponentUtils.setTableDimensions(table, Dimensions.TABLE);
        ComponentUtils.setLabelDimensions(title, Dimensions.TITLE);
    }

    @FXML
    public void initialize() {
        setComponentDimensions();
        title.setText("Timer Application BETA");
        generatePresetList();
    }
}

