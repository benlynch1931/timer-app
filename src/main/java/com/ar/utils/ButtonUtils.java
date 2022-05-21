package com.ar.utils;

import com.ar.config.CellFactory;
import com.ar.config.ItemSize;
import com.ar.dto.PresetDto;
import com.ar.service.PresetService;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import java.util.function.Consumer;

/**
 * @author Ben Lynch
 */
public class ButtonUtils {
    
    private ButtonUtils() {}


    public static Button createPresetBtn(PresetDto currentPreset, PresetService presetService) {
        final Button presetButton = new Button();
        presetButton.setMinWidth(ItemSize.COL_PRESET_WIDTH - 10);
        presetButton.setOnAction(event -> {
            if (currentPreset.getName().equals("New Preset")) {
                System.out.println("NEW PRESET");
            } else {
//                presetService.generateTaskTimers(currentPreset);
            }
        });
        presetButton.setText(currentPreset.getName());
        return presetButton;
    }

    /**
     * Creates start button and functionality for a preset
     * @param currentPreset information about current preset
     * @param presetService PresetService to perform operations
     * @param tableCell TableCell to update graphic of cell
     * @return Start button
     */
    public static Button createStartButton(PresetDto currentPreset, PresetService presetService, TableCell<PresetDto, String> tableCell){
        final Button startButton = new Button("Start");
        startButton.setMinWidth(ItemSize.COL_OTHER_WIDTH - 5);
        startButton.setOnAction(event -> {
            presetService.generateTaskTimers(currentPreset);
            tableCell.setGraphic(createCancelButton(currentPreset, presetService, tableCell));
        });
        return startButton;
    }

    /**
     * Creates cancel button and functionality for a preset
     * @param currentPreset information about current preset
     * @param presetService PresetService to perform operations
     * @param tableCell TableCell to update graphic of cell
     * @return Cancel button
     */
    public static Button createCancelButton(PresetDto currentPreset, PresetService presetService, TableCell<PresetDto, String> tableCell) {
        final Button cancelButton = new Button("Cancel");
        cancelButton.setMinWidth(ItemSize.COL_OTHER_WIDTH - 5);
        cancelButton.setOnAction(event -> {
            presetService.cancelActiveTaskTimers(currentPreset);
            tableCell.setGraphic(createStartButton(currentPreset, presetService, tableCell));
        });
        return cancelButton;
    }
}
