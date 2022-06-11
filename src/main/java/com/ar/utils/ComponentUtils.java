package com.ar.utils;

import com.ar.config.ComponentSize;
import com.ar.config.Dimensions;
import com.ar.config.TimeType;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * @author Ben Lynch
 */
public class ComponentUtils {

    /**
     * Hides implicit constructor
     */
    private ComponentUtils() {}

    /**
     * Returns twenty percent of a value
     * @param value whole value
     * @return 20% of whole value
     */
    public static double twentyPct(final double value) {
        return value * 0.2;
    }

    /**
     * Returns thirty percent of a value
     * @param value whole value
     * @return 30% of whole value
     */
    public static double thirtyPct(final double value) {
        return value * 0.3;
    }
    /**
     * Returns fifty percent of a value
     * @param value whole value
     * @return 50% of whole value
     */
    public static double fiftyPct(final long value) {
        return value * 0.5;
    }

    /**
     * Sets Pane/container width and height
     * @param container Pane to set dimensions
     */
    public static void setTaskContainerSize(final Pane container) {
        setTaskContainerSize(container, ComponentSize.TASK_BOX_HGT);
    }

    /**
     * Sets Pane/container width and height
     * @param container Pane to set dimensions
     * @param height height of Pane
     */
    public static void setTaskContainerSize(final Pane container, final double height) {
        container.setMaxWidth(ComponentSize.SCREEN_WIDTH);
        container.setMinWidth(ComponentSize.SCREEN_WIDTH);
        container.setMaxHeight(height);
        container.setMinHeight(height);
    }

    /**
     * Sets Duration-specific TextField width, height and coordinates
     * @param component Component to set dimensions
     * @param timeType enum representing order of HH->MM->SS
     */
    public static void setDurationComponentDimensions(final TextField component, final TimeType timeType) {
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMinHeight(ComponentSize.TASK_TEXT_FIELD_HGT);

        int xCoordinate = (ComponentSize.TASK_DURATION_MARGIN) + (ComponentSize.TASK_DURATION_FIELDS * timeType.times()) + (ComponentSize.TASK_DURATION_SPACER * timeType.times());
        component.relocate(xCoordinate, ComponentSize.TASK_TEXT_FIELD_TOP);
    }

    /**
     * Sets TaskName-specific TextField width, height and coordinates
     * @param component Component to set dimensions
     */
    public static void setTaskNameComponentDimensions(final TextField component) {
        component.setMinHeight(ComponentSize.TASK_TEXT_FIELD_HGT);
        component.setMaxWidth(ComponentSize.TASK_NAME_FIELD_WIDTH);
        component.setMinWidth(ComponentSize.TASK_NAME_FIELD_WIDTH);
        component.setTranslateX(ComponentSize.TASK_NAME_FIELD_MARGIN);

        component.relocate(0, ComponentSize.TASK_TEXT_FIELD_TOP);
    }

    /**
     * Sets taskView-specific buttons width, height and coordinates
     * @param button Button to set dimensions
     */
    public static void setTaskButtonDimensions(final Button button) {
        button.setMinWidth(ComponentSize.TASK_BTN_WIDTH);
        button.setMaxWidth(ComponentSize.TASK_BTN_WIDTH);
        button.setMaxHeight(ComponentSize.TASK_BTN_HEIGHT);
        button.setMinHeight(ComponentSize.TASK_BTN_HEIGHT);
        // Brings button to front of z-index
        button.setViewOrder(-4);

        if (button.getText().equals("SAVE")) {
            button.relocate(ComponentSize.SCREEN_WIDTH - ComponentSize.TASK_BTN_WIDTH, ComponentSize.TASK_BTN_TOP);
        } else {
            button.relocate(0, ComponentSize.TASK_BTN_TOP);
        }
    }

    /**
     * Sets tasklistview-specific buttons width, height and coordinates
     * @param button Button to set dimensions
     */
    public static void setTaskListButtonDimensions(final Button button) {
        button.setMinWidth(ComponentSize.TASK_BTN_WIDTH);
        button.setMaxWidth(ComponentSize.TASK_BTN_WIDTH);
        button.setMaxHeight(ComponentSize.TASK_BTN_HEIGHT);
        button.setMinHeight(ComponentSize.TASK_BTN_HEIGHT);
        // Brings button to front of z-index
        button.setViewOrder(-4);

        if (button.getText().equals("EDIT")) {
            button.relocate(ComponentSize.SCREEN_WIDTH - ComponentSize.TASK_BTN_WIDTH, ComponentSize.TASKLIST_BTN_TOP);
        } else if (button.getText().equals("CLONE")) {
            button.relocate(ComponentSize.SCREEN_WIDTH - ComponentSize.TASK_BTN_WIDTH, ComponentSize.TASKLIST_BTN_TOP + ComponentSize.TASK_BTN_HEIGHT + 5);
        } else {
            button.relocate(0, ComponentSize.TASKLIST_BTN_TOP);
        }

    }

    public static <D> void setTableDimensions(final TableView<D> table) {
        table.relocate(0, ComponentSize.LIST_TABLE_TOP);
        table.setTranslateX(ComponentSize.TABLE_MARGIN);
        table.setMaxWidth(ComponentSize.TABLE_WIDTH);
        table.setMinWidth(ComponentSize.TABLE_WIDTH);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public static void setButtonDimensions(final Button button, final Dimensions dimensions) {
        button.setMinWidth(dimensions.getWidth());
        button.setMaxWidth(dimensions.getWidth());
        button.setMaxHeight(dimensions.getHeight());
        button.setMinHeight(dimensions.getHeight());
        button.relocate(dimensions.getX(), dimensions.getY());
        button.setViewOrder(dimensions.getZ());
    }

    public static void setPaneDimensions(final AnchorPane pane, final Dimensions dimensions) {
        pane.setMinWidth(dimensions.getWidth());
        pane.setMaxWidth(dimensions.getWidth());
        pane.setMaxHeight(dimensions.getHeight());
        pane.setMinHeight(dimensions.getHeight());
        pane.relocate(dimensions.getX(), dimensions.getY());
        pane.setViewOrder(dimensions.getZ());
    }

    public static void setLabelDimensions(final Label label, final Dimensions dimensions) {
        label.relocate(dimensions.getX(), dimensions.getY());
        label.setMaxWidth(dimensions.getWidth());
        label.setMinWidth(dimensions.getWidth());
        label.setFont(new Font(dimensions.getHeight()));
        label.setAlignment(Pos.CENTER);
    }

    public static <D> void setTableDimensions(final TableView<D> table, final Dimensions dimensions) {
        table.relocate(dimensions.getX(), dimensions.getY());
        table.setMaxWidth(dimensions.getWidth());
        table.setMinWidth(dimensions.getWidth());
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
