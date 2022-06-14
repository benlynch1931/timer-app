package com.bl.config;

import com.bl.controller.ScreenController;
import com.bl.dto.PresetDto;
import com.bl.dto.TaskDto;
import com.bl.service.CurrentRecordViewService;
import com.bl.service.PresetService;
import com.bl.service.TaskService;
import com.bl.utils.ButtonUtils;
import com.bl.utils.TimeUtils;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Ben Lynch
 */
@Component
@AllArgsConstructor
public class CellFactory {

    private final ScreenController screenController;
    private final CurrentRecordViewService currentRecordViewService;
    private final PresetService presetService;
    private final TaskService taskService;

    public Callback<TableColumn<PresetDto, String>, TableCell<PresetDto, String>> presetButton(){
        return (final TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                setGraphic(null);
                setText(null);
                if (!empty) {
                    PresetDto currentPreset = getTableView().getItems().get(getIndex());
                    setGraphic(ButtonUtils.generateTaskListViewButton(currentPreset, screenController, currentRecordViewService));
                }
            }
        };
    }

    /**
     * Updated current cell with a button for starting or cancelling a preset
     * @return returns lambda function that updates the cell value
     */
    public Callback<TableColumn<PresetDto, String>, TableCell<PresetDto, String>> startButton(){
        return (final TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(null);
                setText(null);
                if (!empty && !getTableView().getItems().get(getIndex()).getName().equals("New Preset")) {
                    PresetDto currentPreset = getTableView().getItems().get(getIndex());
                    setGraphic(ButtonUtils.generateStartPresetButton(currentPreset, presetService,  this));
                }
            }
        };
    }

    public Callback<TableColumn<PresetDto, String>, TableCell<TaskDto, String>> taskButton(){
        return (final TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(null);
                setText(null);
                if (!empty) {
                    TaskDto currentTask = getTableView().getItems().get(getIndex());
                    setGraphic(ButtonUtils.generateTaskViewButton(currentTask,  screenController, currentRecordViewService));
                }
            }
        };
    }

    public Callback<TableColumn<PresetDto, String>, TableCell<TaskDto, String>> durationText(){
        return (final TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty && !getTableView().getItems().get(getIndex()).getName().equals("New Task")) {
                    String newText = TimeUtils.convertSecondsToTime(getTableView().getItems().get(getIndex()).getDuration());
                    setText(newText);
                }
            }
        };
    }

    public Callback<TableColumn<PresetDto, String>, TableCell<TaskDto, String>> deleteTaskButton() {
        return (final TableColumn<PresetDto, String> param) -> new TableCell<>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(null);
                setText(null);
                if (!empty) {
                    TaskDto currentTask = getTableView().getItems().get(getIndex());
                    setGraphic(ButtonUtils.generateDeleteTaskButton(currentTask, taskService, screenController));
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
