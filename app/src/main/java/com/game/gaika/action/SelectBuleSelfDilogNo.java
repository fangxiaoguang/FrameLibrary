package com.game.gaika.action;

import com.game.frame.scene.SceneManager;
import com.game.gaika.scene.BattlefieldScene;

/**
 * Created by fangxg on 2015/7/24.
 */
public class SelectBuleSelfDilogNo  implements BaseAction {
    @Override
    public void doAction() {
        BattlefieldScene battlefieldScene = new BattlefieldScene(false);
        SceneManager.render(battlefieldScene);
    }
}
