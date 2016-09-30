package com.game.gaika.data;

/**
 * Created by fangxg on 2015/6/20.
 */
public class ID {


    public enum SCENE_INIT_TYPE {
        INIT,
        NOT_INIT
    }


    public enum TEAM_COLOR {
        BLUE,
        RED,
        YELLOW,
        GREEN,
        GRAY,
        WHITE
    }

    public enum COUNTRY {
        USA,
        USN,
        RUSSIA,
        GERMANY,
        ENGLAND,
        JAPAN,
        ALL,
        NON;

        public String toDescribeString() {
            switch (this) {
                case USA:
                    return "美国陆军";
                case USN:
                    return "美国海军";
                case RUSSIA:
                    return "俄罗斯";
                case GERMANY:
                    return "德国";
                case ENGLAND:
                    return "英国";
                case JAPAN:
                    return "日本";
            }
            return "";
        }
    }

    public enum CITY_TYPE {
        CITY,
        AIRPORT,
        HARBOUR;
    }

    public enum STOR_TYPE {
        TYPE,
        NAME,
        COUNTRY,
        BUY_COST,
        LEVEL,
        REPAIR_COST,
        SELL_COST,
        SUPPLY;

        public String toDescribeString() {

            switch (this) {
                case TYPE:
                    return "类型";
                case NAME:
                    return "名称";
                case COUNTRY:
                    return "国别";
                case SUPPLY:
                    return "补给";
                case BUY_COST:
                    return "购买价";
                case REPAIR_COST:
                    return "修理费";
                case SELL_COST:
                    return "出售价";
                case LEVEL:
                    return "级别";
            }
            return "";
        }
    }

    public enum SORT_ASCEND {
        UP,
        DOWN
    }

    public enum WEAPON_TYPE_EX {
        AIR,
        GROUND,
        SHIP,
        SUBMARINE
    }

    public enum WEAPON_TYPE {
        BATTLE_PLANE,
        ATTACK_PLANE,
        ATTACK_HELICOPTER,
        UTILITY_HELICOPTER,
        TRANSPORT_PLANE,
        TANK,
        ARMORED_CAR,
        SCOUT_CAR,
        SELF_MECHANIZED_GUN,
        ANTIAIRCRAFT_GUN,
        ANTIAIRCRAFT_MISSILE,
        INFANTRY_FIGHTING_VEHICLE,
        INFANTRY,
        BATTLE_SHIP,
        TRANSPORT_SHIP,
        AIRCRAFT_CARRIER,
        SUBMARINE,
        LANDING_SHIP;

        public String toDescribeString() {
            switch (this) {

                case BATTLE_PLANE:
                    return "战斗机";
                case ATTACK_PLANE:
                    return "攻击机";
                case ATTACK_HELICOPTER:
                    return "武装直升机";
                case UTILITY_HELICOPTER:
                    return "通用直升机";
                case TRANSPORT_PLANE:
                    return "运输机";
                case TANK:
                    return "坦克";
                case ARMORED_CAR:
                    return "装甲车";
                case SCOUT_CAR:
                    return "侦察车";
                case SELF_MECHANIZED_GUN:
                    return "自行火炮";
                case ANTIAIRCRAFT_GUN:
                    return "自行高射炮";
                case ANTIAIRCRAFT_MISSILE:
                    return "对空导弹";
                case INFANTRY_FIGHTING_VEHICLE:
                    return "步兵战车";
                case INFANTRY:
                    return "步兵";
                case BATTLE_SHIP:
                    return "战舰";
                case TRANSPORT_SHIP:
                    return "运输舰";
                case AIRCRAFT_CARRIER:
                    return "航母";
                case SUBMARINE:
                    return "潜水艇";
                case LANDING_SHIP:
                    return "登陆舰";
            }
            return "";
        }
    }

    public enum MAP_NODE_TYPE {

        PING_DI,
        TIAN_YUAN,
        SHEN_LIN,
        SHA_DI,
        QIU_LING,
        SHAN_DI,
        QIAN_TAN,
        HAI_HU,
        JIE_DAO,
        SHI_QU,
        CITY_CITY,
        CITY_AIR,
        CITY_HARBOUR,
        QIAO_LIANG;

        public String toDescribeString() {
            switch (this) {

                case PING_DI:
                    return "平地";
                case TIAN_YUAN:
                    return "田园";
                case SHEN_LIN:
                    return "森林";
                case SHA_DI:
                    return "沙地";
                case QIU_LING:
                    return "丘陵";
                case SHAN_DI:
                    return "山地";
                case QIAN_TAN:
                    return "浅滩";
                case HAI_HU:
                    return "海湖";
                case JIE_DAO:
                    return "街道";
                case SHI_QU:
                    return "市区";
                case CITY_CITY:
                    return "城市";
                case CITY_AIR:
                    return "机场";
                case CITY_HARBOUR:
                    return "海港";
                case QIAO_LIANG:
                    return "桥梁";
            }
            return "";
        }
    }

    public enum ARMS_TYPE {
        AIR,
        GROUND
    }

    public enum GAME_DIFF {
        NON,
        EASE,
        HARD,
        VERY_HARD
    }

    public enum BOX_COLOR {
        GREEN,
        RED
    }

    public enum ADVANTAGE {
        EASY,
        NORMAL,
        HARD,
        EASY_GREY,
        NORMAL_GREY,
        HARD_GREY,
        NON,
    }


    public enum DEF_ADD_TYPE {
        NONE,
        MIDDLE,
        HIGH,
    }

    public enum WIN_TYPE {
        WIN,
        LOSE,
        NON,
    }
    public enum RUN_MODELE {
        RELESE,
        DEBUG
    }
}
