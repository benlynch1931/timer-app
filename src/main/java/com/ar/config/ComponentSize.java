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
}
