package com.ar.utils;

import com.ar.config.Dimensions;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
     * Sets Button-specific dimensions
     * @param button button to set dimensions for
     * @param dimensions dimensions values
     */
    public static void setButtonDimensions(final Button button, final Dimensions dimensions) {
        button.setMinWidth(dimensions.getWidth());
        button.setMaxWidth(dimensions.getWidth());
        button.setMaxHeight(dimensions.getHeight());
        button.setMinHeight(dimensions.getHeight());
        button.relocate(dimensions.getX(), dimensions.getY());
        button.setViewOrder(dimensions.getZ());
    }

    /**
     * Sets TextField-specific dimensions
     * @param field field to set dimensions for
     * @param dimensions dimensions values
     */
    public static void setTextFieldDimensions(final TextField field, final Dimensions dimensions) {
        field.setMinWidth(dimensions.getWidth());
        field.setMaxWidth(dimensions.getWidth());
        field.setMaxHeight(dimensions.getHeight());
        field.setMinHeight(dimensions.getHeight());
        field.relocate(dimensions.getX(), dimensions.getY());
        field.setViewOrder(dimensions.getZ());
    }

    /**
     * Sets AnchorPane-specific dimensions
     * @param pane pane to set dimensions for
     * @param dimensions dimensions values
     */
    public static void setPaneDimensions(final AnchorPane pane, final Dimensions dimensions) {
        pane.setMinWidth(dimensions.getWidth());
        pane.setMaxWidth(dimensions.getWidth());
        pane.setMaxHeight(dimensions.getHeight());
        pane.setMinHeight(dimensions.getHeight());
        pane.relocate(dimensions.getX(), dimensions.getY());
        pane.setViewOrder(dimensions.getZ());
    }

    /**
     * Sets Label-specific dimensions
     * @param label label to set dimensions for
     * @param dimensions dimensions values
     */
    public static void setLabelDimensions(final Label label, final Dimensions dimensions) {
        label.relocate(dimensions.getX(), dimensions.getY());
        label.setMaxWidth(dimensions.getWidth());
        label.setMinWidth(dimensions.getWidth());
        label.setFont(new Font(dimensions.getHeight()));
        label.setAlignment(Pos.CENTER);
    }


    /**
     * Sets Table-specific dimensions
     * @param table table to set dimensions for
     * @param dimensions dimensions values
     * @param <D> Generic Type of TableView
     */
    public static <D> void setTableDimensions(final TableView<D> table, final Dimensions dimensions) {
        table.relocate(dimensions.getX(), dimensions.getY());
        table.setMaxWidth(dimensions.getWidth());
        table.setMinWidth(dimensions.getWidth());
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
