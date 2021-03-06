package com.game.frame.fsm;

/**
 * Created by fangxg on 2016/9/27.
 */

public enum MSG_ID {

    MSG_SCENE_TEST1__BUTTON_1,
    MSG_SCENE_TEST1__BUTTON_2,

    MSG_SCENE_TEST2__BUTTON_1,


    MSG_SCENE_LOGO_1__DELAY_TIME_OUT,

    MSG_SCENE_LOGO_2__DELAY_TIME_OUT,

    MSG_SCENE_LOGO_3__DELAY_TIME_OUT,
    MSG_SCENE_LOGO_3__BACKUP_SCENE_TOUCH,

    MSG_SCENE_BEGIN_MENU__BUTTON_NEW_GAME,
    MSG_SCENE_BEGIN_MENU__BUTTON_LOAD_GAME,
    MSG_SCENE_BEGIN_MENU__BUTTON_SETTING,
    MSG_SCENE_BEGIN_MENU__BUTTON_BACK_GAME,

    MSG_SCENE_DIFF_MENU__BUTTON_EASE,
    MSG_SCENE_DIFF_MENU__BUTTON_HARD,
    MSG_SCENE_DIFF_MENU__BUTTON_VERY_HARD,
    MSG_SCENE_DIFF_MENU__BUTTON_BACK,

    MSG_SCENE_LOAD_GAME__PAGE_UP,
    MSG_SCENE_LOAD_GAME__PAGE_DOWN,
    MSG_SCENE_LOAD_GAME__RETURN,
    MSG_SCENE_LOAD_GAME__SELECT_SAVE_DATA,
    MSG_SCENE_LOAD_GAME__OVER_SAVE_YES,
    MSG_SCENE_LOAD_GAME__OVER_SAVE_NO,

    MSG_SCENE_SETTING_ZOOM_DOWN,
    MSG_SCENE_SETTING_ZOOM_UP,
    MSG_SCENE_SETTING_SOUND_OFF,
    MSG_SCENE_SETTING_SOUND_ON,
    MSG_SCENE_SETTING_VOLUME_DOWN,
    MSG_SCENE_SETTING_VOLUME_UP,
    MSG_SCENE_SETTING_RETURN,

    MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1,
    MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2,
    MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3,
    MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4,
    MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5,
    MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6,
    MSG_SCENE_BEGIN_LOCAL__BUTTON_BACK,

    MSG_SCENE_COUNTRY_MENU__BUTTON_SELECT_COUNTY_1,
    MSG_SCENE_COUNTRY_MENU__BUTTON_SELECT_COUNTY_2,
    MSG_SCENE_COUNTRY_MENU__BUTTON_SELECT_COUNTY_3,
    MSG_SCENE_COUNTRY_MENU__BUTTON_SELECT_COUNTY_4,
    MSG_SCENE_COUNTRY_MENU__BUTTON_SELECT_COUNTY_5,
    MSG_SCENE_COUNTRY_MENU__BUTTON_SELECT_COUNTY_6,
    MSG_SCENE_COUNTRY_MENU__BUTTON_BACK,

    MSG_SCENE_TUTORIAL__DELAY_TIME_OUT,
    MSG_SCENE_TUTORIAL__BACKUP_TOUCHE,

    //        MSG_SCENE_HUD__BUTTON_1,
    MSG_SCENE_HUD__BUTTON_BACKUP,
    MSG_SCENE_HUD__TURN_FINISH,
    MSG_SCENE_HUD__TURN_FINISH_DILOG_YES,
    MSG_SCENE_HUD__TURN_FINISH_DILOG_NO,
    MSG_SCENE_HUD__GAME_OVER_DILOG_YES,
    MSG_SCENE_HUD__GAME_OVER_DILOG_NO,
    MSG_SCENE_HUD__BUTTON_SYSTEM,

    MSG_SCENE_BATTLEFIELD_ENTER_INFO_HUD__BUTTON1,
    MSG_SCENE_BATTLEFIELD_ENTER_INFO_HUD__BUTTON2,

    MSG_SCENE_BATTLEFIELD_INFO__RETURN,

    MSG_SCENE_DIPLOMACY__LEFT,
    MSG_SCENE_DIPLOMACY__RIGHT,
    MSG_SCENE_DIPLOMACY__CONFIRM,
    MSG_SCENE_DIPLOMACY__SELECT_COUNTRY_1,
    MSG_SCENE_DIPLOMACY__SELECT_COUNTRY_2,
    MSG_SCENE_DIPLOMACY__SELECT_COUNTRY_3,
    MSG_SCENE_DIPLOMACY__SELECT_COUNTRY_4,
    MSG_SCENE_DIPLOMACY__SELECT_COUNTRY_5,
    MSG_SCENE_DIPLOMACY__SELECT_COUNTRY_6,
    MSG_SCENE_DIPLOMACY__CAN_BUY_WEAPON_NEXT,


    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_1,
    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_2,
    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_3,
    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_4,
    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_5,
    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_6,
    MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_7,

    MSG_SCENE_SAVE_GAME__PAGE_UP,
    MSG_SCENE_SAVE_GAME__PAGE_DOWN,
    MSG_SCENE_SAVE_GAME__RETURN,
    MSG_SCENE_SAVE_GAME__SELECT_SAVE_DATA,
    MSG_SCENE_SAVE_GAME__OVER_SAVE_YES,
    MSG_SCENE_SAVE_GAME__OVER_SAVE_NO,

    MSG_SCENE_SELECT_TARGET__SELECT_CHAPTER,

    MSG_SCENE_SORTS_SUB__BUTTON_SORT,

    MSG_SCENE_SORTS_SUB__BUTTON_TYPE,
    MSG_SCENE_SORTS_SUB__BUTTON_NAME,
    MSG_SCENE_SORTS_SUB__BUTTON_COUNTRY,
    MSG_SCENE_SORTS_SUB__BUTTON_BUY_COST,
    MSG_SCENE_SORTS_SUB__BUTTON_LEVEL,
    MSG_SCENE_SORTS_SUB__BUTTON_REPAIR_COST,
    MSG_SCENE_SORTS_SUB__BUTTON_SELL_COST,
    MSG_SCENE_SORTS_SUB__BUTTON_SUPPLY,

    MSG_SCENE_SORTS_SUB__BUTTON_ASCEND,


    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_1,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_2,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_3,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_4,
    MSG_SCENE_SYSTEM_POPUP_MENU__CAPTURED,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_5,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_6,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_7,
    MSG_SCENE_SYSTEM_POPUP_MENU__BUTTON_8,

    MSG_SCENE_TEAM_BUILD__SELECT_WEAPON_UP,
    MSG_SCENE_TEAM_BUILD__SELECT_WEAPON_DOWN,
    MSG_SCENE_TEAM_BUILD__DOWN_LEFT,
    MSG_SCENE_TEAM_BUILD__DOWN_RIGHT,
    MSG_SCENE_TEAM_BUILD__BACKUP_TOUCH,

    MSG_SCENE_TEAM_LIST__RETURN,
    MSG_SCENE_TEAM_LIST__SCROOL_UP,
    MSG_SCENE_TEAM_LIST__SCROOL_DOWN,

    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_SELECT_TARGET,
    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_TEAM_BUILD,
    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_BUY,
    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_REPAIR,
    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_DIPLOMACY,
    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_SELL,
    MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_SYSTEM_MENU,

    MSG_SCENE_WEAPON_BUY__SELECT_WEAPON_UP,
    MSG_SCENE_WEAPON_BUY__SELECT_WEAPON_DOWN,
    MSG_SCENE_WEAPON_BUY__UP_LEFT,
    MSG_SCENE_WEAPON_BUY__UP_RIGHT,
    MSG_SCENE_WEAPON_BUY__DOWN_LEFT,
    MSG_SCENE_WEAPON_BUY__DOWN_RIGHT,
    MSG_SCENE_WEAPON_BUY__BACKUP_TOUCH,

    MSG_SCENE_WEAPON_REPAIR__SELECT_WEAPON_UP,
    MSG_SCENE_WEAPON_REPAIR__UP_LEFT,
    MSG_SCENE_WEAPON_REPAIR__UP_RIGHT,
    MSG_SCENE_WEAPON_REPAIR__REPAIR_ALL,
    MSG_SCENE_WEAPON_REPAIR__REPAIR_ALL_DLG_YES,
    MSG_SCENE_WEAPON_REPAIR__REPAIR_ALL_DLG_NO,
    MSG_SCENE_WEAPON_REPAIR__BACKUP_TOUCH,

    MSG_SCENE_WEAPON_SELL__SELECT_WEAPON_UP,
    MSG_SCENE_WEAPON_SELL__UP_LEFT,
    MSG_SCENE_WEAPON_SELL__UP_RIGHT,
    MSG_SCENE_WEAPON_SELL__BACKUP_TOUCH,

    MSG_SCENE_WEAPON_SETOUT__SELECT_WEAPON,
    MSG_SCENE_WEAPON_SETOUT__BUTTON_BACK,
    MSG_SCENE_WEAPON_SETOUT__BACKUP_TOUCH,

    MSG_SCENE_BATTLEFIELD__SELECT_CITY,
    MSG_SCENE_BATTLEFIELD__SELECT_WEAPON,
    MSG_SCENE_BATTLEFIELD__SELECT_JUST_INFO_WEAPON,
    MSG_SCENE_BATTLEFIELD__SELECT_CHOOSE_ARMS_WEAPON,
    MSG_SCENE_BATTLEFIELD__SELECT_CHOOSE_ARMS_DLG_AIR,
    MSG_SCENE_BATTLEFIELD__SELECT_CHOOSE_ARMS_DLG_GROUND,
    MSG_SCENE_BATTLEFIELD__SELECT_DESC,
    MSG_SCENE_BATTLEFIELD__SELECT_ENEMY,
    MSG_SCENE_BATTLEFIELD__SELECT_SELF,
    MSG_SCENE_BATTLEFIELD__SELECT_TRANSPORTER,
    MSG_SCENE_BATTLEFIELD__SELECT_PASSENGER,
    MSG_SCENE_BATTLEFIELD__SELECT_SELF_DLG_YES,
    MSG_SCENE_BATTLEFIELD__SELECT_SELF_DLG_NO,
    MSG_SCENE_BATTLEFIELD__FIGHT_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__LV_UP_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__CAPTURING_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__GET_SOME_THING_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__CHECK_WIN_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__CRASH_NEXT,
    MSG_SCENE_BATTLEFIELD__CRASH_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__BLUE_TURN_BEGIN_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_TURN_BEGIN_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_REPAIR_NEXT,
    MSG_SCENE_BATTLEFIELD__AI_REPAIR_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_BUY_NEXT,
    MSG_SCENE_BATTLEFIELD__AI_BUY_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_SELECT_NON_NEXT,
    MSG_SCENE_BATTLEFIELD__AI_SELECT_NON_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_NEXT_TEAM,
    MSG_SCENE_BATTLEFIELD__AI_SELECT_WEAPON_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_MOVE_TO_DESC_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__AI_FIGHT_TIME_OUT,
    MSG_SCENE_BATTLEFIELD__BLUE_REPAIR_NEXT,
    MSG_SCENE_BATTLEFIELD__BLUE_REPAIR_YES,
    MSG_SCENE_BATTLEFIELD__BLUE_REPAIR_NO,
    MSG_SCENE_BATTLEFIELD__BLUE_REPAIR_TIME_OUT,
//        MSG_SCENE_BATTLEFIELD__AI_LV_UP_TIME_OUT,
//        MSG_SCENE_BATTLEFIELD__AI_CAPLTURING_TIME_OUT,


    MSG_SCENE_CHAPTER_COMPLETE__BACK,
    MSG_SCENE_CHAPTER_LOSE__BACK,


    MSG_SCENE_DEBUG_SETUP_DIALOG_MAIN__BUTTON_1,
    MSG_SCENE_DEBUG_SETUP_DIALOG_MAIN__BUTTON_2,
    MSG_SCENE_DEBUG_SETUP_DIALOG_MAIN__BUTTON_3,


    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_1,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_2,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_3,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_4,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_5,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_6,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_7,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_8,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_9,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_10,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_11,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_12,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_13,
    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_14,


    MSG_SCENE_DEBUG_SETUP_DIALOG_1__BUTTON_RETURN,

    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_1,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_2,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_3,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_4,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_5,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_6,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_7,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2__BUTTON_8,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2___LEFT,
    MSG_SCENE_DEBUG_SETUP_DIALOG_2___RIGHT,

    MSG_SCENE_DEBUG_SETUP_DIALOG_3__BUTTON_1,
    MSG_SCENE_DEBUG_SETUP_DIALOG_3__BUTTON_8,
    MSG_SCENE_DEBUG_SETUP_DIALOG_3__LEFT,
    MSG_SCENE_DEBUG_SETUP_DIALOG_3__RIGHT,
}