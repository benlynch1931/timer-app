package com.ar.config;

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

    public static final int TASK_DURATION_TOP = (SCREEN_HEIGHT / 2) - 50;
    public static final int TASK_DURATION_MARGIN = 69;
    public static final int TASK_DURATION_FIELDS = 69;
    public static final int TASK_DURATION_SPACER = 43;

//    public static final int TASK_BUTTON_BOX_HGT = 0;
//    public static final double TASK_BUTTON_BOX_TOP = 44.8;
//    public static final int TASK_DURATION_BOX_TOP = 192;
//    public static final int TASK_NAME_BOX_TOP = 112;
//    public static final int TASK_DURATION_BOX_HGT = 0;

    public static final double TASK_BUTTON_BOX_TOP = 89.6;
    public static final double TASK_BOX_HGT = 64;
    public static final double TASK_NAME_BOX_TOP = 224;
    public static final double TASK_DURATION_PANE_TOP = 384;

    public static final double TASK_NAME_BOX_TRANS_Y = TASK_NAME_BOX_TOP - TASK_BUTTON_BOX_TOP - TASK_BOX_HGT;
    public static final double TASK_DURATION_PANE_TRANS_Y = TASK_DURATION_PANE_TOP - TASK_NAME_BOX_TOP - TASK_BOX_HGT;

    public static final int TASK_NAME_FIELD_WIDTH = SCREEN_WIDTH / 3 * 2;
    public static final int TASK_NAME_FIELD_MARGIN = TASK_NAME_FIELD_WIDTH / 4;

}
