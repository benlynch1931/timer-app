package com.ar.utils;

import com.ar.config.ComponentSize;
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

    public static double twentyPct(final long value) {
        return value * 0.2;
    }
    public static double fiftyPct(final long value) {
        return value * 0.5;
    }

    public static void setTaskContainerSize(final Pane container) {
        setTaskContainerSize(container, ComponentSize.TASK_BOX_HGT);
    }

    public static void setTaskContainerSize(final Pane container, final double height) {
        container.setMaxWidth(ComponentSize.SCREEN_WIDTH);
        container.setMinWidth(ComponentSize.SCREEN_WIDTH);
        container.setMaxHeight(height);
        container.setMinHeight(height);
    }

    public static void setDurationComponentDimensions(final TextField component, final int fieldNo) {
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMaxWidth(ComponentSize.TASK_DURATION_FIELDS);
        component.setMinHeight(ComponentSize.TASK_TEXT_FIELD_HGT);

        int xCoordinate = (ComponentSize.TASK_DURATION_MARGIN) + (ComponentSize.TASK_DURATION_FIELDS * fieldNo) + (ComponentSize.TASK_DURATION_SPACER * fieldNo);
        component.relocate(xCoordinate, ComponentSize.TASK_TEXT_FIELD_TOP);
    }

    public static void setTaskNameComponentDimensions(final TextField component) {
        component.setMinHeight(ComponentSize.TASK_TEXT_FIELD_HGT);
        component.setMaxWidth(ComponentSize.TASK_NAME_FIELD_WIDTH);
        component.setMinWidth(ComponentSize.TASK_NAME_FIELD_WIDTH);
        component.setTranslateX(ComponentSize.TASK_NAME_FIELD_MARGIN);
    }
}
