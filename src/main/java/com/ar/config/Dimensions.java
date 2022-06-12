package com.ar.config;

import lombok.Getter;

@Getter
public enum Dimensions {

    PANE_TABLE(
            ComponentSize.PANE_TABLE_LEFT, ComponentSize.PANE_TABLE_TOP, 0,
            ComponentSize.PANE_TABLE_WIDTH, ComponentSize.PANE_TABLE_HGT
    ),
    TABLE(
            ComponentSize.TABLE_LEFT, ComponentSize.TABLE_TOP, 0,
            ComponentSize.TABLE_WIDTH, ComponentSize.TABLE_HGT
    ),
    
    PANE_VIEW_BTN(
            ComponentSize.PANE_VIEW_BTN_LEFT, ComponentSize.PANE_VIEW_BTN_TOP, 0,
            ComponentSize.PANE_VIEW_BTN_WIDTH, ComponentSize.PANE_VIEW_BTN_HGT
    ),
    PANE_NAME_FIELD(
            ComponentSize.PANE_NAME_FIELD_LEFT, ComponentSize.PANE_NAME_FIELD_TOP, 0,
            ComponentSize.PANE_NAME_FIELD_WIDTH, ComponentSize.PANE_NAME_FIELD_HGT
    ),
    PANE_DELAY_FIELD(
            ComponentSize.PANE_DELAY_FIELD_LEFT, ComponentSize.PANE_DELAY_FIELD_TOP, 0,
            ComponentSize.PANE_DELAY_FIELD_WIDTH, ComponentSize.PANE_DELAY_FIELD_HGT
    ),
    PANE_DURATION_FIELD(
            ComponentSize.PANE_DURATION_LEFT, ComponentSize.PANE_DURATION_TOP, 0,
            ComponentSize.PANE_DURATION_WIDTH, ComponentSize.PANE_DURATION_HGT
    ),
    PANE_TITLE(
            ComponentSize.PANE_TITLE_LEFT, ComponentSize.PANE_TITLE_TOP, 0,
            ComponentSize.PANE_TITLE_WIDTH, ComponentSize.PANE_TITLE_HGT
    ),
    TITLE(
            ComponentSize.TITLE_LEFT, ComponentSize.TITLE_TOP, 0,
            ComponentSize.TITLE_WIDTH, ComponentSize.TITLE_TEXT_SIZE
    ),
    PANE_NAME_LABEL(
            ComponentSize.PANE_NAME_LABEL_LEFT, ComponentSize.PANE_NAME_LABEL_TOP, 0,
            ComponentSize.PANE_NAME_LABEL_WIDTH, ComponentSize.PANE_NAME_LABEL_HGT
    ),

    NAME_FIELD(
            ComponentSize.NAME_FIELD_LEFT, ComponentSize.NAME_FIELD_TOP, 0,
            ComponentSize.NAME_FIELD_WIDTH, ComponentSize.NAME_FIELD_HGT
    ),
    DELAY_FIELD(
            ComponentSize.DELAY_FIELD_LEFT, ComponentSize.DELAY_FIELD_TOP, 0,
            ComponentSize.DELAY_FIELD_WIDTH, ComponentSize.DELAY_FIELD_HGT
    ),
    DELAY_LABEL(
            ComponentSize.DELAY_LABEL_LEFT, ComponentSize.DELAY_LABEL_TOP, 0,
            ComponentSize.DELAY_LABEL_WIDTH, ComponentSize.DELAY_LABEL_TEXT_SIZE
    ),
    SECONDS_LABEL(
            ComponentSize.SECONDS_LABEL_LEFT, ComponentSize.SECONDS_LABEL_TOP, 0,
            ComponentSize.SECONDS_LABEL_WIDTH, ComponentSize.SECONDS_LABEL_TEXT_SIZE
    ),
    NAME_ERROR(
            ComponentSize.NAME_ERROR_LEFT, ComponentSize.NAME_ERROR_TOP, 0,
            ComponentSize.NAME_ERROR_WIDTH, ComponentSize.NAME_ERROR_TEXT_SIZE
    ),
    
    SAVE_BTN(
            ComponentSize.VIEW_BTN_COL_2_LEFT, ComponentSize.VIEW_BTN_ROW_1_TOP, -4,
            ComponentSize.VIEW_BTN_WIDTH, ComponentSize.VIEW_BTN_HGT
    ),
    EDIT_BTN(
            ComponentSize.VIEW_BTN_COL_2_LEFT, ComponentSize.VIEW_BTN_ROW_1_TOP, -4,
            ComponentSize.VIEW_BTN_WIDTH, ComponentSize.VIEW_BTN_HGT
    ),
    CLONE_BTN(
            ComponentSize.VIEW_BTN_COL_2_LEFT, ComponentSize.VIEW_BTN_ROW_2_TOP, -4,
            ComponentSize.VIEW_BTN_WIDTH, ComponentSize.VIEW_BTN_HGT
    ),
    BACK_BTN(
            ComponentSize.VIEW_BTN_COL_1_LEFT, ComponentSize.VIEW_BTN_ROW_1_TOP, -4,
            ComponentSize.VIEW_BTN_WIDTH, ComponentSize.VIEW_BTN_HGT
    ),
    NAME_LABEL(
            ComponentSize.NAME_LEFT, ComponentSize.NAME_TOP, 0,
            ComponentSize.NAME_WIDTH, ComponentSize.NAME_TEXT_SIZE
    ),
    DURATION_LABEL(
            ComponentSize.DURATION_LEFT, ComponentSize.DURATION_TOP, 0,
            ComponentSize.DURATION_WIDTH, ComponentSize.DURATION_TEXT_SIZE
    ),
    HOURS_FIELD(
            ComponentSize.HOURS_FIELD_LEFT, ComponentSize.HOURS_FIELD_TOP, 0,
            ComponentSize.HOURS_FIELD_WIDTH, ComponentSize.HOURS_FIELD_HGT
    ),
    MINUTES_FIELD(
            ComponentSize.MINUTES_FIELD_LEFT, ComponentSize.MINUTES_FIELD_TOP, 0,
            ComponentSize.MINUTES_FIELD_WIDTH, ComponentSize.MINUTES_FIELD_HGT
    ),
    SECONDS_FIELD(
            ComponentSize.SECONDS_FIELD_LEFT, ComponentSize.SECONDS_FIELD_TOP, 0,
            ComponentSize.SECONDS_FIELD_WIDTH, ComponentSize.SECONDS_FIELD_HGT
    ),
    TIME_ERROR(
            ComponentSize.TIME_ERROR_LEFT, ComponentSize.TIME_ERROR_TOP, 0,
            ComponentSize.TIME_ERROR_WIDTH, ComponentSize.TIME_ERROR_TEXT_SIZE
    )
    
    ;

    private final double x;
    private final double y;
    private final int z;
    private final double width;
    private final double height;

    Dimensions(final double x, final double y, final int z, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
    }
}
