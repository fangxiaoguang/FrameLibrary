package com.game.gaika.scene;

import android.util.Pair;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.scene.value.SceneValueMap;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.action.BaseAction;
import com.game.gaika.action.GameOverDilogNoAction;
import com.game.gaika.action.GameOverDilogYesAction;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.GameSetup;
import com.game.gaika.data.ID;
import com.game.gaika.data.SortManager;
import com.game.gaika.data.WeaponSelectFilter;
import com.game.gaika.data.weapon.BaseWeapon;
import com.game.gaika.scene.sub.BorderSubScene;
import com.game.gaika.scene.sub.FlagsSubScene;
import com.game.gaika.scene.sub.SortsSubScene;
import com.game.gaika.scene.sub.TopButtosSubScene;
import com.game.gaika.sprite.TeamBuildWeaponSprite;
import com.game.gaika.sprite.WeaponInfoSprite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.game.frame.scene.value.SceneValueMap.getSceneValuesMap;
import static com.game.frame.sound.SoundManager.playSound;
import static com.game.gaika.data.ID.COUNTRY.*;
import static com.game.gaika.data.ID.SORT_ASCEND.*;
import static com.game.gaika.data.ID.STOR_TYPE.*;
import static com.game.gaika.data.ID.TEAM_COLOR.*;

/**
 * Created by fangxg on 2015/6/28.
 */
public class TeamBuildScene extends SimpleScene {
//    enum MSG_ID {MSG_SELECT_WEAPON_UP, MSG_SELECT_WEAPON_DOWN, MSG_DOWN_LEFT, MSG_DOWN_RIGHT}

    public TeamBuildScene(boolean isInit) {
        super(SCENE_ID.TEAM_BUILD, 800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);

        GameDataManager gdm = GameDataManager.getInstance();

        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "oper_bg1");// 0, new TouchMessage(MSG_SCENE_TEAM_BUILD__BACKUP_TOUCH, null, this));
        addSprite(backSprite);

        TopButtosSubScene topButtosSubScene = new TopButtosSubScene(this);
        topButtosSubScene.setOffset(new Pair<Float, Float>(0.0f,0.0f));
        addChildScene(topButtosSubScene);

        SceneValueMap sceneValues = getSceneValuesMap();
        if (isInit == true) {
            sceneValues.cleanAllValues();
            sceneValues.setEnum("sortTypeUp", TYPE);
            sceneValues.setEnum("sortAscendUp", UP);

            Set<Enum> countryFilterSetUp = new HashSet<>();
            countryFilterSetUp.add(USA);
            countryFilterSetUp.add(USN);
            countryFilterSetUp.add(RUSSIA);
            countryFilterSetUp.add(GERMANY);
            countryFilterSetUp.add(ENGLAND);
            countryFilterSetUp.add(JAPAN);
            countryFilterSetUp.add(ALL);
            sceneValues.setObject("countryFilterUp", countryFilterSetUp);

            sceneValues.setEnum("sortTypeDown", TYPE);
            sceneValues.setEnum("sortAscendDown", UP);

            Set<Enum> countryFilterSetDown = new HashSet<>();
            countryFilterSetDown.add(USA);
            countryFilterSetDown.add(USN);
            countryFilterSetDown.add(RUSSIA);
            countryFilterSetDown.add(GERMANY);
            countryFilterSetDown.add(ENGLAND);
            countryFilterSetDown.add(JAPAN);
            countryFilterSetDown.add(ALL);
            sceneValues.setObject("countryFilterDown", countryFilterSetDown);

            sceneValues.setInt("pageDown", 1);
        }

        List<ID.STOR_TYPE> items = new ArrayList<>();
        items.add(TYPE);
        items.add(NAME);
        items.add(COUNTRY);
        items.add(BUY_COST);

        SortsSubScene sortsSubSceneUp = new SortsSubScene("Up", items, this);
        sortsSubSceneUp.setOffset(new Pair<Float, Float>(213.0f, 46.0f));
        addChildScene(sortsSubSceneUp);

        FlagsSubScene flagsSubSceneUp = new FlagsSubScene("Up", this);
        flagsSubSceneUp.setOffset(new Pair<Float, Float>(469.0f, 46.0f));
        addChildScene(flagsSubSceneUp);

        WeaponSelectFilter filterUp = new WeaponSelectFilter();
        filterUp.setTeamOut(true);
        //filterUp.setSetOut(true);
        filterUp.addTeamColor(BLUE);
        filterUp.setCountrys((Set<Enum>) (sceneValues.getObject("countryFilterUp")));
        List<BaseWeapon> weapNodesUp = gdm.getWeapons(filterUp);


        SortManager.sortWeapons(weapNodesUp, (ID.STOR_TYPE) sceneValues.getEnum("sortTypeUp"), (ID.SORT_ASCEND) sceneValues.getEnum("sortAscendUp"));

        int offsetUpX = 52;
        int offsetUpY = 110;
        int countUp = 0;
        for (BaseWeapon weapNodeUp : weapNodesUp) {

            TeamBuildWeaponSprite weaponSprite;
            weaponSprite = new TeamBuildWeaponSprite(offsetUpX + (countUp % 10) * 67, offsetUpY + (countUp / 10) * 56,
                    weapNodeUp, new TouchMessage(MSG_ID.MSG_SCENE_TEAM_BUILD__SELECT_WEAPON_UP, null, this, weapNodeUp.id));
            addSprite(weaponSprite);

            if (sceneValues.containsKey("selectedWeaponIDUp") == true && sceneValues.getInt("selectedWeaponIDUp") == weapNodeUp.id) {

                NormalSprite unSprite = new NormalSprite(offsetUpX + (countUp % 10) * 67, offsetUpY + (countUp / 10) * 56, "unitcur2");
                addSprite(unSprite);

                WeaponInfoSprite infoSprite = new WeaponInfoSprite(weapNodeUp, WeaponInfoSprite.INFO_CARD_ALPHA);
                if (countUp % 10 >= 5) {
                    infoSprite.setX(0);
                } else {
                    infoSprite.setX(800 - 211);
                }
                infoSprite.setY(100);
                infoSprite.setZ(100);
                addSprite(infoSprite);
            }

            countUp++;
        }


        SortsSubScene sortsSubSceneDown = new SortsSubScene("Down", items, this);
        sortsSubSceneDown.setOffset(new Pair<Float, Float>(247.0f, 368.0f));
        addChildScene(sortsSubSceneDown);

        FlagsSubScene flagsSubSceneDown = new FlagsSubScene("Down", this);
        flagsSubSceneDown.setOffset(new Pair<Float, Float>(502.0f, 368.0f));
        addChildScene(flagsSubSceneDown);

        WeaponSelectFilter filterDown = new WeaponSelectFilter();
        // filterDown.setTeamOut(true);
        filterDown.addTeamColor(BLUE);
        filterDown.setCountrys((Set<Enum>) (sceneValues.getObject("countryFilterDown")));
        List<BaseWeapon> weapNodesDown = gdm.getWeapons(filterDown);


        SortManager.sortWeapons(weapNodesDown, (ID.STOR_TYPE) sceneValues.getEnum("sortTypeDown"), (ID.SORT_ASCEND) sceneValues.getEnum("sortAscendDown"));

        int offsetDownX = 138;
        int offsetDownY = 400;
        int countDown = 0;
        for (BaseWeapon weapNodeDown : weapNodesDown) {


            if ((sceneValues.getInt("pageDown") - 1) * 36 <= countDown && countDown < sceneValues.getInt("pageDown") * 36) {


                TeamBuildWeaponSprite weaponSprite;
                weaponSprite = new TeamBuildWeaponSprite(offsetDownX
                        + ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) % 9) * 67, offsetDownY
                        + ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) / 9) * 46,
                        weapNodeDown, new TouchMessage(MSG_ID.MSG_SCENE_TEAM_BUILD__SELECT_WEAPON_DOWN, null, this, weapNodeDown.id));
                addSprite(weaponSprite);


                if (sceneValues.containsKey("selectedWeaponIDDown") == true && sceneValues.getInt("selectedWeaponIDDown") == weapNodeDown.id) {

                    NormalSprite unSprite = new NormalSprite(offsetDownX
                            + ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) % 9) * 67, offsetDownY
                            + ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) / 9) * 46, "unitcur2");
                    addSprite(unSprite);

                    WeaponInfoSprite infoSprite = new WeaponInfoSprite(weapNodeDown, WeaponInfoSprite.INFO_CARD_ALPHA);
                    if ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) % 9 >= 4) {
                        infoSprite.setX(0);
                    } else {
                        infoSprite.setX(800 - 211);
                    }
                    infoSprite.setY(100);
                    infoSprite.setZ(100);
                    addSprite(infoSprite);
                }
                if (weapNodeDown.teamOut == true) {

                    NormalSprite unSprite = new NormalSprite(offsetDownX
                            + ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) % 9) * 67, offsetDownY
                            + ((countDown - (sceneValues.getInt("pageDown") - 1) * 36) / 9) * 46, "weap_wn5m");
                    addSprite(unSprite);
                }

            }
            countDown++;
        }

        if (sceneValues.getInt("pageDown") > 1) {

            NormalSprite liftSprite = new NormalSprite(100, 410, "scroolbt", 0, new TouchMessage(MSG_ID.MSG_SCENE_TEAM_BUILD__DOWN_LEFT, null, this));
            addSprite(liftSprite);
        }
        if (sceneValues.getInt("pageDown") < (countDown - 1) / 36 + 1) {
            NormalSprite rightSprite = new NormalSprite(750, 410, "scroolbt", 1, new TouchMessage(MSG_ID.MSG_SCENE_TEAM_BUILD__DOWN_RIGHT, null, this));
            addSprite(rightSprite);
        }

        NormalSprite back2Sprite = new NormalSprite(0.0f, 0.0f, "oper_bg1", 0, new TouchMessage(MSG_ID.MSG_SCENE_TEAM_BUILD__BACKUP_TOUCH, null, this), 1, 1, 0.0f);
        addSprite(back2Sprite);

        //top button
        addChildScene(new TopButtosSubScene(this));

        addChildScene(new BorderSubScene(this));
    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {

    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        SceneValueMap sceneValues = getSceneValuesMap();
        MSG_ID msgID = pTouchMessage.getMessageID();
        if (msgID == MSG_ID.MSG_SCENE_TEAM_BUILD__DOWN_LEFT) {
             playSound("scrl01");
            sceneValues.setInt("pageDown", sceneValues.getInt("pageDown") - 1);
            TeamBuildScene teamBuildScene = new TeamBuildScene(false);
            SceneManager.render(teamBuildScene);
        }
        if (msgID == MSG_ID.MSG_SCENE_TEAM_BUILD__DOWN_RIGHT) {
             playSound("scrl01");
            sceneValues.setInt("pageDown", sceneValues.getInt("pageDown") + 1);
            TeamBuildScene teamBuildScene = new TeamBuildScene(false);
            SceneManager.render(teamBuildScene);
        }
        if (msgID == MSG_ID.MSG_SCENE_TEAM_BUILD__SELECT_WEAPON_UP) {
            int newSelectedWeaponID = pTouchMessage.getParam();
            GameDataManager gdm = GameDataManager.getInstance();
            sceneValues.remove("selectedWeaponIDDown");
            if (sceneValues.containsKey("selectedWeaponIDUp") == true && sceneValues.getInt("selectedWeaponIDUp") == newSelectedWeaponID) {
                 playSound("haichi01");
                sceneValues.remove("selectedWeaponIDUp");
                BaseWeapon weapon = gdm.weapons.get(newSelectedWeaponID);
                weapon.teamOut = false;
                TeamBuildScene teamBuildScene = new TeamBuildScene(false);
                SceneManager.render(teamBuildScene);
            } else {
                 playSound("select01");
                sceneValues.setInt("selectedWeaponIDUp", newSelectedWeaponID);

                TeamBuildScene teamBuildScene = new TeamBuildScene(false);
                SceneManager.render(teamBuildScene);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_TEAM_BUILD__SELECT_WEAPON_DOWN) {
            int newSelectedWeaponID = pTouchMessage.getParam();
            sceneValues.remove("selectedWeaponIDUp");
            GameDataManager gdm = GameDataManager.getInstance();
            if (sceneValues.containsKey("selectedWeaponIDDown") == true && sceneValues.getInt("selectedWeaponIDDown") == newSelectedWeaponID) {
                BaseWeapon weapon = gdm.weapons.get(newSelectedWeaponID);

                if (weapon.teamOut == false) {
                    WeaponSelectFilter filter = new WeaponSelectFilter();
                    filter.setTeamOut(true);
                    filter.addTeamColor(BLUE);
                    Set<Enum> countryFilter = new HashSet<Enum>();
                    countryFilter.add(USA);
                    countryFilter.add(USN);
                    countryFilter.add(RUSSIA);
                    countryFilter.add(GERMANY);
                    countryFilter.add(ENGLAND);
                    countryFilter.add(JAPAN);
                    countryFilter.add(ALL);
                    filter.setCountrys(countryFilter);
                    List<BaseWeapon> teamOutWeapons = gdm.getWeapons(filter);
                    if (teamOutWeapons.size() < 40) {
                         playSound("haichi01");
                        sceneValues.remove("selectedWeaponIDDown");
                        weapon.teamOut = true;
                        TeamBuildScene teamBuildScene = new TeamBuildScene(false);
                        SceneManager.render(teamBuildScene);
                    }
                } else {

                }
            } else {
                 playSound("select01");
                sceneValues.setInt("selectedWeaponIDDown", newSelectedWeaponID);
                TeamBuildScene teamBuildScene = new TeamBuildScene(false);
                SceneManager.render(teamBuildScene);
            }
        }

        if (msgID == MSG_ID.MSG_SCENE_TEAM_BUILD__BACKUP_TOUCH) {
            sceneValues.remove("selectedWeaponIDUp");
            sceneValues.remove("selectedWeaponIDDown");
            TeamBuildScene teamBuildScene = new TeamBuildScene(false);
            SceneManager.render(teamBuildScene);
        }
        if (msgID == MSG_ID.MSG_SCENE_HUD__GAME_OVER_DILOG_YES) {
             playSound("select01");
            BaseAction act = new GameOverDilogYesAction();
            act.doAction();
        }
        if (msgID == MSG_ID.MSG_SCENE_HUD__GAME_OVER_DILOG_NO) {
             playSound("back01");
            BaseAction act = new GameOverDilogNoAction();
            act.doAction();
        }
    }
}
