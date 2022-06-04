package com.ar.config;

import com.ar.utils.ComponentUtils;

/**
 * @author Ben Lynch
 */
public class ComponentSize {

    public static final int SCREEN_WIDTH = 414;
    public static final int SCREEN_HEIGHT = 896;

    public static final int TABLE_MARGIN = 5;
    public static final int TABLE_WIDTH = SCREEN_WIDTH - (2*TABLE_MARGIN);
    public static final int COL_PRESET_WIDTH = 210;
    public static final int COL_OTHER_WIDTH = (TABLE_WIDTH - COL_PRESET_WIDTH) / 2;
    
    public static final int TASK_DURATION_MARGIN = 69;
    public static final int TASK_DURATION_FIELDS = 69;
    public static final int TASK_DURATION_SPACER = 43;

    public static final int TASK_ERROR_SIZE = 14;

    public static final double TASK_BUTTON_BOX_TOP = 89.6;
    public static final double TASK_BOX_HGT = 64;
    public static final double TASK_DURATION_PANE_HGT = TASK_BOX_HGT + TASK_ERROR_SIZE;
    public static final double TASK_NAME_BOX_HGT = TASK_BOX_HGT + TASK_ERROR_SIZE;
    public static final double TASK_NAME_BOX_TOP = 224;
    public static final double TASK_DURATION_PANE_TOP = 384;

    public static final int TASK_NAME_FIELD_WIDTH = SCREEN_WIDTH / 3 * 2;
    public static final int TASK_NAME_FIELD_MARGIN = TASK_NAME_FIELD_WIDTH / 4;
    public static final int TASK_TEXT_FIELD_HGT = 24;
    public static final int TASK_TEXT_FIELD_TOP = 20;

    public static final double TASK_TIME_ERROR_TOP = TASK_DURATION_PANE_HGT - (0.5 * TASK_TEXT_FIELD_HGT) - TASK_ERROR_SIZE;
    public static final double TASK_NAME_ERROR_TOP = TASK_NAME_BOX_HGT - (0.5 * TASK_TEXT_FIELD_HGT) - TASK_ERROR_SIZE;

    public static final double TASK_BTN_HEIGHT = 32;
    public static final double TASK_BTN_WIDTH = ComponentUtils.thirtyPct(SCREEN_WIDTH);
    public static final double TASK_BTN_TOP = 0.25 * TASK_BOX_HGT;


    public static final double TASKLIST_TITLE_TOP = 74;
    public static final double TASKLIST_BTN_TOP = 68;
    public static final double TASKLIST_TITLE_SIZE = 20;
    public static final double LIST_TABLE_TOP = 124;


}
