package com.ar.utils;

import com.ar.config.ComponentSize;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    public static double twentyPct(final long value) {
        return value * 0.2;
    }

    /**
     * Returns thirty percent of a value
     * @param value whole value
     * @return 30% of whole value
     */
    public static double thirtyPct(final long value) {
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
     * @param fieldNo index representing order of HH->MM->SS
     */
    public static void setDurationComponentDimensions(final TextField component, final int fieldNo) {
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMinHeight(ComponentSize.TASK_TEXT_FIELD_HGT);

        int xCoordinate = (ComponentSize.TASK_DURATION_MARGIN) + (ComponentSize.TASK_DURATION_FIELDS * fieldNo) + (ComponentSize.TASK_DURATION_SPACER * fieldNo);
        component.relocate(xCoordinate, ComponentSize.TASK_TEXT_FIELD_TOP);
    }

    /**
     * Sets Taskname-specific TextField width, height and coordinates
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
     * Sets taskview-specific buttons width, height and coordinates
     * @param button Button to set dimensions
     */
    public static void setTaskButtonDimensions(final Button button) {
        button.setMinWidth(ComponentSize.TASK_BTN_WIDTH);
        button.setMaxWidth(ComponentSize.TASK_BTN_WIDTH);
        button.setMaxHeight(ComponentSize.TASK_BTN_HEIGHT);
        button.setMinHeight(ComponentSize.TASK_BTN_HEIGHT);

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
        if (button.getText().equals("EDIT")) {
            button.relocate(ComponentSize.SCREEN_WIDTH - ComponentSize.TASK_BTN_WIDTH, ComponentSize.TASKLIST_BTN_TOP);
        } else {
            button.relocate(0, ComponentSize.TASKLIST_BTN_TOP);
        }

    }
}
