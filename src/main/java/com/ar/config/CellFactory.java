package com.ar.config;

import com.ar.controller.ScreenController;
import com.ar.dto.PresetDto;
import com.ar.service.PresetService;
import com.ar.utils.ButtonUtils;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 * @author Ben Lynch
 */
public class CellFactory {

    public static Callback<TableColumn<PresetDto, String>, TableCell<PresetDto, String>> presetButton(ScreenController screenController, PresetService presetService) {
        return (TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                setGraphic(null);
                setText(null);
                if (!empty) {
                    PresetDto currentPreset = getTableView().getItems().get(getIndex());
                    setGraphic(ButtonUtils.createPresetBtn(currentPreset, screenController, presetService));
                }
            }
        };
    }

    /**
     * Updated current cell with a button for starting or cancelling a preset
     * @param presetService PresetService to perform operations
     * @return returns function that updates the cell value
     */
    public static Callback<TableColumn<PresetDto, String>, TableCell<PresetDto, String>> startButton(PresetService presetService) {
        return (TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(null);
                setText(null);
                if (!empty && !getTableView().getItems().get(getIndex()).getName().equals("New Preset")) {
                    PresetDto currentPreset = getTableView().getItems().get(getIndex());
                    setGraphic(ButtonUtils.createStartButton(currentPreset, presetService,  this));
                }
            }
        };
    }

    /**
     * Commented for possible future requirements
     */
//    public static final Callback<TableColumn<PresetDto, String>, TableCell<PresetDto, String>> testNewPresetButton = new Callback<>() {
//
//        @Override
//        public TableCell call(final TableColumn<PresetDto, String> param) {
//            final TableCell<PresetDto, String> cell = new TableCell<>() {
//
//                final Button startBtn = new Button("Start");
//                final Button presetBtn = new Button();
//                final Button newPresetBtn = new Button("New Preset");
//
//                {
//                    startBtn.setMinWidth(ItemSize.COL_OTHER_WIDTH - 5);
//                    presetBtn.setMinWidth(ItemSize.COL_PRESET_WIDTH - 10);
//                    newPresetBtn.setMinWidth(ItemSize.COL_PRESET_WIDTH - 10);
//                }
//
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        setGraphic(null);
//                    } else {
//                        PresetDto currentPreset = getTableView().getItems().get(getIndex());
//                        System.out.println(getIndex() + " | " + currentPreset.getName());
//                        startBtn.setOnAction(event -> {
//                            System.out.println("Start: " + currentPreset.getId());
//                        });
//                        presetBtn.setOnAction(event -> {
//                            System.out.println(currentPreset.getName());
//                        });
//                        setText(null);
//                        if (item == null && currentPreset.getName().equals("New Preset")) {
//                            setGraphic(null);
//                        } else if (item == null && !currentPreset.getName().equals("New Preset")) {
//                            setGraphic(startBtn);
//                        } else if (item != null && item.equalsIgnoreCase("New Preset")) {
//                            setGraphic(newPresetBtn);
//                        } else {
//                            presetBtn.setText(item);
//                            setGraphic(presetBtn);
//                        }
//                    }
//                }
//            };
//            return cell;
//        }
//    };
}
