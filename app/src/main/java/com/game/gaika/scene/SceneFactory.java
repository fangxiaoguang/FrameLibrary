package com.game.gaika.scene;

import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.gaika.data.ID;

import static com.game.gaika.data.ID.SCENE_INIT_TYPE.*;

/**
 * Created by fangxg on 2015/7/20.
 */
public class SceneFactory {
    public static BaseLogicScene createScene(SCENE_ID pSceneID) {
        return createScene(pSceneID, INIT);
    }

    public static BaseLogicScene createScene(SCENE_ID pSceneID, ID.SCENE_INIT_TYPE pESceneInitType) {
        boolean isInit = true;

        if (pESceneInitType == INIT) {
            isInit = true;
        } else if (pESceneInitType == NOT_INIT) {
            isInit = false;
        }

        if (pSceneID == SCENE_ID.LOGO_1) {
            return new Logo1Scene();
        }
        if (pSceneID == SCENE_ID.LOGO_2) {
            return new Logo2Scene();
        }
        if (pSceneID == SCENE_ID.LOGO_3) {
            return new Logo3Scene();
        }
        if (pSceneID == SCENE_ID.BEGIN_MENU) {
            return new BeginMenuSceen();
        }
   /*     if (pSceneID == SCENE_ID.BEGIN_LOCAL) {
            return new BeginLocalScene();
        }
        if (pSceneID == SCENE_ID.BEGIN_COUNTY) {
            return new BeginCountyScene();
        }
        if (pSceneID == SCENE_ID.DIFF_MENU) {
            return new DiffMenuScene();
        }
        if (pSceneID == SCENE_ID.DIPLOMACY) {
            return new DiplomacyScene(isInit);
        }
//        if (pSceneID == SAVE_GAME) {
//            return new SaveGameScene(isInit);
//        }
        if (pSceneID == SCENE_ID.SELECT_TARGET) {
            return new SelectTargetScene(isInit);
        }
        if (pSceneID == SCENE_ID.TEAM_BUILD) {
            return new TeamBuildScene(isInit);
        }
//        if (pSceneID == TEAM_LIST) {
//            return new TeamListScene(isInit);
//        }
        if (pSceneID == SCENE_ID.WEAPON_BUY) {
            return new WeaponBuyScene(isInit);
        }
        if (pSceneID == SCENE_ID.WEAPON_REPAIR) {
            return new WeaponRepairScene(isInit);
        }
        if (pSceneID ==SCENE_ID.WEAPON_SELL) {
            return new WeaponSellScene(isInit);
        }
        if (pSceneID == SCENE_ID.BATTLEFIELD) {
            return new BattlefieldScene(isInit);
        }

        if (pSceneID == SCENE_ID.WEAPON_SETOUT) {
            return new WeaponSetoutScene();
        }*/
        throw new IllegalArgumentException("SCENE_ID: " + pSceneID);
    }
}
