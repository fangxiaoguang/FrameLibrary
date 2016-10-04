package com.game.gaika.scene.sub;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.sub.SubScene;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.ID;
import com.game.gaika.scene.DiplomacyScene;
import com.game.gaika.scene.SelectTargetScene;
import com.game.gaika.scene.TeamBuildScene;
import com.game.gaika.scene.WeaponBuyScene;
import com.game.gaika.scene.WeaponRepairScene;
import com.game.gaika.scene.WeaponSellScene;
import com.game.gaika.scene.dialg.SystemPopupMenuScene;

import static com.game.frame.scene.SCENE_ID.SELECT_TARGET;
import static com.game.frame.sound.SoundManager.playSound;

/**
 * Created by fangxg on 2015/6/28.
 */
public class TopButtosSubScene extends SubScene {

    // enum MSG_ID {MSG_BUTTON_SELECT_TARGET, MSG_BUTTON_TEAM_BUILD, MSG_BUTTON_WEAPON_BUY, MSG_BUTTON_WEAPON_REPAIR, MSG_BUTTON_DIPLOMACY, MSG_BUTTON_WEAPON_SELL, MSG_BUTTON_SYSTEM_MENU;}

    public TopButtosSubScene(BaseLogicScene pParentScene) {
        super(SCENE_ID.TOP_BUTTOS_SUB);

        SCENE_ID parentSceneID = pParentScene.getSceneId();


        int bx = 7;
        int by = 3;

        if (parentSceneID != SELECT_TARGET) {
            NormalSprite buttonSprite = new NormalSprite(bx, by, "oper_tg1", 0, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_SELECT_TARGET, null, this));
            addSprite(buttonSprite);
        }
        bx += 99;

        if (parentSceneID != SCENE_ID.TEAM_BUILD) {
            NormalSprite buttonSprite = new NormalSprite(bx, by, "oper_tg1", 1, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_TEAM_BUILD, null, this));
            addSprite(buttonSprite);
        }
        bx += 99;

        if (parentSceneID != SCENE_ID.WEAPON_BUY) {
            NormalSprite buttonSprite = new NormalSprite(bx, by, "oper_tg1", 2, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_BUY, null, this));
            addSprite(buttonSprite);
        }
        bx += 99;

        if (parentSceneID != SCENE_ID.WEAPON_REPAIR) {
            NormalSprite buttonSprite = new NormalSprite(bx, by, "oper_tg1", 3, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_REPAIR, null, this));
            addSprite(buttonSprite);
        }
        bx += 99;

        if (parentSceneID != SCENE_ID.DIPLOMACY) {
            NormalSprite buttonSprite = new NormalSprite(bx, by, "oper_tg1", 4, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_DIPLOMACY, null, this));
            addSprite(buttonSprite);
        }
        bx += 99;

        if (parentSceneID !=SCENE_ID. WEAPON_SELL) {
            NormalSprite buttonSprite = new NormalSprite(bx, by, "oper_tg1", 5, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_SELL, null, this));
            addSprite(buttonSprite);
        }


        NormalSprite buttonSysSprite = new NormalSprite(800 - 86, 0, "sys_bt", 1, new TouchMessage(MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_SYSTEM_MENU, null, this));
        addSprite(buttonSysSprite);


    }

    @Override
    public boolean isBacegroundEnabled() {
        return false;
    }

    @Override
    public void buildScene() {

    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {



        MSG_ID EMsgID = pTouchMessage.getMessageID();
        if (EMsgID == MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_SELECT_TARGET) {
             playSound("select01");
            SelectTargetScene scene = new SelectTargetScene(true);
            SceneManager.render(scene);
        }
        if (EMsgID == MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_TEAM_BUILD) {
             playSound("select01");
            TeamBuildScene scene = new TeamBuildScene(true);
            SceneManager.render(scene);
        }
        if (EMsgID == MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_BUY) {
             playSound("select01");
            WeaponBuyScene scene = new WeaponBuyScene(true);
            SceneManager.render(scene);
        }
        if (EMsgID ==MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_REPAIR) {
             playSound("select01");
            WeaponRepairScene scene = new WeaponRepairScene(true);
            SceneManager.render(scene);
        }
        if (EMsgID == MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_DIPLOMACY) {
             playSound("select01");
            DiplomacyScene scene = new DiplomacyScene(true);
            SceneManager.render(scene);
        }
        if (EMsgID == MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_WEAPON_SELL) {
             playSound("select01");
            WeaponSellScene scene = new WeaponSellScene(true);
            SceneManager.render(scene);
        }
        if (EMsgID == MSG_ID.MSG_SCENE_TOP_BUTTONS_SUB__BUTTON_SYSTEM_MENU) {
             playSound("select01");
            BaseLogicScene parentScene = getParentScene();
            parentScene.setDialogSecne(new SystemPopupMenuScene( parentScene, 1.6f));
            SceneManager.render(parentScene);
        }



    }
}
