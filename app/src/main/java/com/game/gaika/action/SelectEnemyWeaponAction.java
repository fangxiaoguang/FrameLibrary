package com.game.gaika.action;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SceneManager;
import com.game.frame.sprite.DelaySprite;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.GameSetup;
import com.game.gaika.data.ID;
import com.game.gaika.data.weapon.BaseWeapon;
import com.game.gaika.scene.BattlefieldScene;

/**
 * Created by fangxg on 2015/7/24.
 */
public class SelectEnemyWeaponAction implements BaseAction {
    private int enemyID;

    public SelectEnemyWeaponAction(int pEnemyID) {
        this.enemyID = pEnemyID;
    }

    @Override
    public void doAction() {
        GameDataManager gdm = GameDataManager.getInstance();
        BaseWeapon blueNode = gdm.getSelectedWeapon();
        BaseWeapon redNode = gdm.weapons.get(enemyID);


        blueNode.doFight(redNode);

        BattlefieldScene battlefieldScene = new BattlefieldScene(false);

        DelaySprite delaySprite = new DelaySprite(GameSetup.DELAY_FIGHT_S, new TouchMessage(MSG_ID.MSG_SCENE_BATTLEFIELD__FIGHT_TIME_OUT, null, battlefieldScene, blueNode.id));
        battlefieldScene.addSprite(delaySprite);

        SceneManager.render(battlefieldScene);
    }
}
