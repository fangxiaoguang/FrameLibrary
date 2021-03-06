package com.game.gaika.action;

import com.game.frame.scene.SceneManager;
import com.game.gaika.scene.BattlefieldScene;

/**
 * Created by fangxg on 2015/7/27.
 */
public class CheckWinTimeOutAction implements BaseAction {
    private int weaponID;

    public CheckWinTimeOutAction(int weaponID) {
        this.weaponID = weaponID;
    }

    @Override
    public void doAction() {
        BattlefieldScene battlefieldScene =new BattlefieldScene(false);
        SceneManager.render(battlefieldScene);
    }
}
