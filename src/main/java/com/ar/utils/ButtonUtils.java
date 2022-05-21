package com.ar.utils;

import com.ar.config.ItemSize;
import com.ar.dto.PresetDto;
import com.ar.service.PresetService;
import javafx.scene.control.Button;

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

    public static Button createStartButton(PresetDto currentPreset, PresetService presetService) {
        final Button startButton = new Button("Start");
        startButton.setMinWidth(ItemSize.COL_OTHER_WIDTH - 5);
        startButton.setOnAction(event -> {
            presetService.generateTaskTimers(currentPreset);
        });
        return startButton;
    }
}
