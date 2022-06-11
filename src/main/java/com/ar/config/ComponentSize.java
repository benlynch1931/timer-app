package com.ar.config;

import com.ar.utils.ComponentUtils;

/**
 * @author Ben Lynch
 */
public class ComponentSize {

    public static final double SCREEN_WIDTH = 414;
    public static final int SCREEN_HEIGHT = 896;

    public static final int TABLE_MARGIN = 5;
    public static final double TABLE_WIDTH = SCREEN_WIDTH - (2*TABLE_MARGIN);
    public static final int COL_PRESET_WIDTH = 210;
    public static final double COL_OTHER_WIDTH = (TABLE_WIDTH - COL_PRESET_WIDTH) / 2;
    public static final int COL_DELETE_WIDTH = 30;
    
    public static final int TASK_DURATION_MARGIN = 69;
    public static final int TASK_DURATION_FIELDS = 69;
    public static final int TASK_DURATION_SPACER = 43;

    public static final int TASK_ERROR_SIZE = 14;

    public static final double TASK_BUTTON_BOX_TOP = 89.6;
    public static final double PRESET_BUTTON_BOX_TOP = 89.6;
    public static final double TASK_BOX_HGT = 64;
    public static final double TASK_DURATION_PANE_HGT = TASK_BOX_HGT + TASK_ERROR_SIZE;
    public static final double TASK_NAME_BOX_HGT = TASK_BOX_HGT + TASK_ERROR_SIZE;
    public static final double TASK_NAME_BOX_TOP = 224;
    public static final double PRESET_NAME_BOX_TOP = 180;
    public static final double TASK_DURATION_PANE_TOP = 384;
    public static final double PRESET_TASKLIST_BOX_TOP = 280;

    public static final double TASK_NAME_FIELD_WIDTH = SCREEN_WIDTH / 3 * 2;
    public static final double TASK_NAME_FIELD_MARGIN = TASK_NAME_FIELD_WIDTH / 4;
    public static final int TASK_TEXT_FIELD_HGT = 24;
    public static final int TASK_TEXT_FIELD_TOP = 20;

    public static final double TASK_TIME_ERROR_TOP = TASK_DURATION_PANE_HGT - (0.5 * TASK_TEXT_FIELD_HGT) - TASK_ERROR_SIZE;
    public static final double TASK_NAME_ERROR_TOP = TASK_NAME_BOX_HGT - (0.5 * TASK_TEXT_FIELD_HGT) - TASK_ERROR_SIZE;

    public static final double TASK_BTN_HEIGHT = 32;
    public static final double TASK_BTN_WIDTH = ComponentUtils.thirtyPct(SCREEN_WIDTH);
    public static final double TASK_BTN_TOP = 0.25 * TASK_BOX_HGT;


    public static final double TASKLIST_TITLE_TOP = 43;
    public static final double TASKLIST_BTN_TOP = 68;
    public static final double TASKLIST_TITLE_SIZE = 20;
    public static final double TASKLIST_DURATION_SIZE = 14;

    public static final double LIST_TABLE_TOP = 280;
    public static final double TASKLIST_TABLE_TOP = 200;
    public static final double TASKLIST_DURATION_TOP = 110;





    public static final double NAME_BOX_FIELD_SPACER = 10;
//    public static final double NAME_TEXT_SIZE = 20;
    public static final double NAME_FIELD_TEXT_SIZE = 14;



    public static final double NAME_FIELD_BOX_HGT = NAME_BOX_FIELD_SPACER + TASK_ERROR_SIZE + TASKLIST_TITLE_SIZE;






    public static double VIEW_BTN_HGT = 32;
    public static double VIEW_BTN_WIDTH = ComponentUtils.twentyPct(SCREEN_WIDTH);
    public static double VIEW_BTN_ROW_1_TOP = 68;
    public static double VIEW_BTN_ROW_2_TOP = VIEW_BTN_ROW_1_TOP + VIEW_BTN_HGT;
    public static double VIEW_BTN_COL_1_LEFT = 0;
    public static double VIEW_BTN_COL_2_LEFT = SCREEN_WIDTH - VIEW_BTN_WIDTH;


    public static double PANE_VIEW_BTN_HGT = VIEW_BTN_HGT * 2;
    public static double PANE_VIEW_BTN_WIDTH = SCREEN_WIDTH;
    public static double PANE_VIEW_BTN_TOP;
    public static double PANE_VIEW_BTN_LEFT = 0;


    public static double PANE_TABLE_PADDING = 5;
    public static double PANE_TABLE_WIDTH = SCREEN_WIDTH;
    public static double PANE_TABLE_TOP = 200;
    public static double PANE_TABLE_HGT = SCREEN_HEIGHT - PANE_TABLE_TOP;
    public static double PANE_TABLE_LEFT = 0.5 * (SCREEN_WIDTH - PANE_TABLE_WIDTH);
//    public static double TABLE_WIDTH = PANE_TABLE_WIDTH - (2 * PANE_TABLE_PADDING);
    public static double TABLE_HGT = PANE_TABLE_HGT;
    public static double TABLE_TOP = 0;
    public static double TABLE_LEFT = PANE_TABLE_PADDING;

    public static double NAME_FIELD_WIDTH;
    public static double NAME_FIELD_HGT;
    public static double NAME_FIELD_TOP;
    public static double PANE_NAME_FIELD_WIDTH = SCREEN_WIDTH;
    public static double NAME_FIELD_LEFT = 0.5 * (PANE_NAME_FIELD_WIDTH - NAME_FIELD_WIDTH);
    public static double NAME_FIELD_SPACER = 5;
    public static double NAME_ERROR_WIDTH = SCREEN_WIDTH;

    public static double NAME_ERROR_TEXT_SIZE = 14;
    public static double PANE_NAME_FIELD_HGT = NAME_FIELD_HGT + NAME_ERROR_TEXT_SIZE + NAME_FIELD_SPACER;
    public static double NAME_ERROR_TOP = PANE_NAME_FIELD_HGT - NAME_ERROR_TEXT_SIZE;

    public static double NAME_ERROR_LEFT = 0.5 * (SCREEN_WIDTH - NAME_ERROR_WIDTH);
    public static double PANE_NAME_FIELD_TOP;
    public static double PANE_NAME_FIELD_LEFT = 0.5 * (SCREEN_WIDTH - PANE_NAME_FIELD_WIDTH);



    public static double PANE_DURATION_HGT;
    public static double PANE_DURATION_WIDTH;
    public static double PANE_DURATION_TOP;
    public static double PANE_DURATION_LEFT = 0.5 * (SCREEN_WIDTH - PANE_DURATION_WIDTH);

//    public static double HOURS_FIELD_TEXT_SIZE;
    public static double HOURS_FIELD_WIDTH;
    public static double HOURS_FIELD_TOP;
    public static double HOURS_FIELD_LEFT;
//    public static double MINUTES_FIELD_TEXT_SIZE;
    public static double MINUTES_FIELD_WIDTH;
    public static double MINUTES_FIELD_TOP;
    public static double MINUTES_FIELD_LEFT;
//    public static double SECONDS_FIELD_TEXT_SIZE;
    public static double SECONDS_FIELD_WIDTH;
    public static double SECONDS_FIELD_TOP;
    public static double SECONDS_FIELD_LEFT;
    public static double TIME_ERROR_TEXT_SIZE = 14;
    public static double TIME_ERROR_WIDTH;
    public static double TIME_ERROR_TOP = PANE_DURATION_HGT - TIME_ERROR_TEXT_SIZE;
    public static double TIME_ERROR_LEFT;


    public static double PANE_TITLE_HGT;
    public static double PANE_TITLE_WIDTH;
    public static double PANE_TITLE_TOP;
    public static double PANE_TITLE_LEFT = 0.5 * (SCREEN_WIDTH - PANE_TITLE_WIDTH);

    public static double PANE_NAME_LABEL_HGT;
    public static double PANE_NAME_LABEL_WIDTH = SCREEN_WIDTH - (2 * VIEW_BTN_WIDTH);
//    public static double PANE_NAME_LABEL_TOP = 43;
    public static double PANE_NAME_LABEL_TOP = 68;
    public static double PANE_NAME_LABEL_LEFT = 0.5 * (SCREEN_WIDTH - PANE_NAME_LABEL_WIDTH);
    public static double NAME_TOP = 0;
    public static double NAME_LEFT = 0;
    public static double NAME_TEXT_SIZE = 20;
    public static double NAME_WIDTH = PANE_NAME_LABEL_WIDTH;
    public static double DURATION_TOP = NAME_TOP + (2*NAME_TEXT_SIZE) + 10;
    public static double DURATION_LEFT = 0;
    public static double DURATION_TEXT_SIZE = 14;
    public static double DURATION_WIDTH = PANE_NAME_LABEL_WIDTH;

    




}
