package com.bl.config;

import com.bl.utils.ComponentUtils;

/**
 * @author Ben Lynch
 */
public class ComponentSize {

    /**
     * Static Constants
     */
    public static final double SCREEN_WIDTH = 414;
    public static final double COL_DELETE_WIDTH = 30;
    public static final double COL_PRESET_WIDTH = 210;
    public static final int DURATION_FIELD_WIDTH = 69;
    public static final double DELAY_FIELD_WIDTH = 50;
    public static final double PANE_DELAY_FIELD_WIDTH = SCREEN_WIDTH;
    public static final double DELAY_LABEL_WIDTH = 0.5 * (SCREEN_WIDTH - DELAY_FIELD_WIDTH);
    public static final double SECONDS_LABEL_WIDTH = 0.5 * (SCREEN_WIDTH - DELAY_FIELD_WIDTH);

    public static final double SCREEN_HEIGHT = 896;
    public static final double VIEW_BTN_HGT = 32;
    public static final double NAME_FIELD_HGT = 24;
    public static final double DELAY_FIELD_HGT = 24;
    public static final double DURATION_FIELD_HGT = 24;

    public static final double PANE_VIEW_BTN_TOP = 68;
    public static final double PANE_TABLE_TOP = 200;
    public static final double PANE_TITLE_TOP = 68;
    public static final double PANE_NAME_LABEL_TOP = 68;
    public static final double PANE_DELAY_FIELD_TOP = PANE_TABLE_TOP - DELAY_FIELD_HGT - 10;
    public static final double VIEW_BTN_ROW_1_TOP = 0;
    public static final double TABLE_TOP = 0;
    public static final double NAME_FIELD_TOP = 0;
    public static final double DELAY_FIELD_TOP = 0;
    public static final double DELAY_LABEL_TOP = 2;
    public static final double SECONDS_LABEL_TOP = 2;
    public static final double DURATION_FIELD_TOP = 0;
    public static final double TITLE_TOP = 0;
    public static final double NAME_TOP = 0;

    public static final double PANE_VIEW_BTN_LEFT = 0;
    public static final double VIEW_BTN_COL_1_LEFT = 0;
    public static final double HOURS_FIELD_LEFT = 69;
    public static final double NAME_LEFT = 0;
    public static final double DURATION_LEFT = 0;
    public static final double TABLE_LEFT = 0;
    public static final double DELAY_FIELD_LEFT = 0.5 * (SCREEN_WIDTH - DELAY_FIELD_WIDTH);
    public static final double DELAY_LABEL_LEFT = 0;
    public static final double SECONDS_LABEL_LEFT = SCREEN_WIDTH - SECONDS_LABEL_WIDTH;

    public static final double NAME_ERROR_TEXT_SIZE = 14;
    public static final double TIME_ERROR_TEXT_SIZE = 14;
    public static final double TITLE_TEXT_SIZE = 32;
    public static final double NAME_TEXT_SIZE = 20;
    public static final double DELAY_LABEL_TEXT_SIZE = 20;
    public static final double SECONDS_LABEL_TEXT_SIZE = 20;
    public static final double DURATION_TEXT_SIZE = 14;

    public static final double NAME_FIELD_SPACER = 5;
    public static final double DURATION_FIELD_ERROR_SPACER = 5;
    public static final double DURATION_FIELD_SPACER = 43;


    /**
     * Direct-Mapping Constants
     */
    public static final double PANE_TABLE_WIDTH = SCREEN_WIDTH;
    public static final double TABLE_WIDTH = PANE_TABLE_WIDTH;
    public static final double PANE_VIEW_BTN_WIDTH = SCREEN_WIDTH;

    public static final double PANE_TABLE_HGT = SCREEN_HEIGHT - PANE_TABLE_TOP;
    public static final double TABLE_HGT = PANE_TABLE_HGT;

    public static final double VIEW_BTN_WIDTH = ComponentUtils.twentyPct(SCREEN_WIDTH);
    public static final double PANE_DURATION_WIDTH = SCREEN_WIDTH;
    public static final double TIME_ERROR_WIDTH = PANE_DURATION_WIDTH;
    public static final double HOURS_FIELD_HGT = DURATION_FIELD_HGT;
    public static final double HOURS_FIELD_WIDTH = DURATION_FIELD_WIDTH;
    public static final double HOURS_FIELD_TOP = DURATION_FIELD_TOP;
    public static final double MINUTES_FIELD_HGT = DURATION_FIELD_HGT;
    public static final double MINUTES_FIELD_WIDTH = DURATION_FIELD_WIDTH;
    public static final double MINUTES_FIELD_TOP = DURATION_FIELD_TOP;
    public static final double SECONDS_FIELD_HGT = DURATION_FIELD_HGT;
    public static final double SECONDS_FIELD_WIDTH = DURATION_FIELD_WIDTH;
    public static final double SECONDS_FIELD_TOP = DURATION_FIELD_TOP;
    public static final double PANE_TITLE_HGT = TITLE_TEXT_SIZE;
    public static final double PANE_TITLE_WIDTH = SCREEN_WIDTH;
    public static final double TITLE_WIDTH = PANE_TITLE_WIDTH;

    public static final double PANE_NAME_FIELD_WIDTH = SCREEN_WIDTH - (2 * VIEW_BTN_WIDTH);
    public static final double PANE_NAME_LABEL_WIDTH = SCREEN_WIDTH - (2 * VIEW_BTN_WIDTH);
    public static final double NAME_WIDTH = PANE_NAME_LABEL_WIDTH;
    public static final double DURATION_WIDTH = PANE_NAME_LABEL_WIDTH;



    /**
     * Dynamic Constants
     */
    public static final double COL_OTHER_WIDTH = (TABLE_WIDTH - COL_PRESET_WIDTH) / 2;
    public static final double NAME_FIELD_WIDTH = PANE_NAME_FIELD_WIDTH;
    public static final double NAME_ERROR_WIDTH = PANE_NAME_FIELD_WIDTH;

    public static final double PANE_VIEW_BTN_HGT = VIEW_BTN_HGT * 2;
    public static final double PANE_NAME_FIELD_HGT = NAME_FIELD_HGT + NAME_ERROR_TEXT_SIZE + NAME_FIELD_SPACER;
    public static final double PANE_DELAY_FIELD_HGT = DELAY_FIELD_HGT;
    public static final double PANE_DURATION_HGT = DURATION_FIELD_HGT + TIME_ERROR_TEXT_SIZE + DURATION_FIELD_ERROR_SPACER;

    public static final double VIEW_BTN_ROW_2_TOP = VIEW_BTN_ROW_1_TOP + VIEW_BTN_HGT;
    public static final double PANE_NAME_FIELD_TOP = VIEW_BTN_ROW_2_TOP + VIEW_BTN_HGT;
    public static final double PANE_DURATION_TOP = PANE_NAME_FIELD_TOP + PANE_NAME_FIELD_HGT + 30;
    public static final double DURATION_TOP = NAME_TOP + (2*NAME_TEXT_SIZE) + 10;
    public static final double PANE_NAME_LABEL_HGT = DURATION_TEXT_SIZE + DURATION_TOP;
    public static final double NAME_ERROR_TOP = PANE_NAME_FIELD_HGT - NAME_ERROR_TEXT_SIZE;
    public static final double TIME_ERROR_TOP = PANE_DURATION_HGT - TIME_ERROR_TEXT_SIZE;


    public static final double PANE_TABLE_LEFT = 0.5 * (SCREEN_WIDTH - PANE_TABLE_WIDTH);
    public static final double PANE_NAME_FIELD_LEFT = 0.5 * (SCREEN_WIDTH - PANE_NAME_FIELD_WIDTH);
    public static final double PANE_DELAY_FIELD_LEFT = 0.5 * (SCREEN_WIDTH - PANE_DELAY_FIELD_WIDTH);
    public static final double PANE_DURATION_LEFT = 0.5 * (SCREEN_WIDTH - PANE_DURATION_WIDTH);
    public static final double PANE_TITLE_LEFT = 0.5 * (SCREEN_WIDTH - PANE_TITLE_WIDTH);
    public static final double PANE_NAME_LABEL_LEFT = 0.5 * (SCREEN_WIDTH - PANE_NAME_LABEL_WIDTH);

    public static final double VIEW_BTN_COL_2_LEFT = SCREEN_WIDTH - VIEW_BTN_WIDTH;
    public static final double NAME_FIELD_LEFT = 0.5 * (PANE_NAME_FIELD_WIDTH - NAME_FIELD_WIDTH);
    public static final double NAME_ERROR_LEFT = 0.5 * (PANE_NAME_FIELD_WIDTH - NAME_ERROR_WIDTH);
    public static final double MINUTES_FIELD_LEFT = HOURS_FIELD_LEFT + DURATION_FIELD_WIDTH + DURATION_FIELD_SPACER;
    public static final double SECONDS_FIELD_LEFT = MINUTES_FIELD_LEFT + DURATION_FIELD_WIDTH + DURATION_FIELD_SPACER;

    public static final double TITLE_LEFT = 0.5 * (SCREEN_WIDTH - TITLE_WIDTH);

    public static final double TIME_ERROR_LEFT = SCREEN_WIDTH - TIME_ERROR_WIDTH;

}
