package com.ar.config;

/**
 * @author Ben Lynch
 */
public class DatabaseConstants {

    private DatabaseConstants() {}

    public static final String TABLE_TASK = "TASK";
    public static final String TABLE_PRESET = "PRESET";
    public static final String TABLE_ACTIVE_TASK = "ACTIVE_TASK";
    public static final String TABLE_CURRENT_VIEW = "CURRENT_RECORD_VIEW";

    public static final String COLUMN_PRESET_ID = "PRESET_ID";
    public static final String COLUMN_TASK_ID = "TASK_ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_DURATION = "DURATION";
    public static final String COLUMN_DELAY = "DELAY";


    public static final String COLUMN_ACTIVE_TASK_ID = "ACTIVE_TASK_ID";
    public static final String COLUMN_ALARM_TIME = "ALARM_TIME";

    public static final String COLUMN_VIEW_ID = "VIEW_ID";
    public static final String COLUMN_SCENE = "SCENE";
    public static final String COLUMN_RECORD_ID = "RECORD_ID";
}
