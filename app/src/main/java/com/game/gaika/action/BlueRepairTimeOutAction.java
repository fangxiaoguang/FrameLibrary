package com.game.gaika.action;

import com.game.frame.scene.SceneManager;
import com.game.gaika.scene.BattlefieldScene;

/**
 * Created by fangxg on 2015/9/1.
 */
public class BlueRepairTimeOutAction implements BaseAction {
    @Override
    public void doAction() {
        BattlefieldScene battlefieldScene = new BattlefieldScene(false);
        SceneManager.render(battlefieldScene);
    }
}
