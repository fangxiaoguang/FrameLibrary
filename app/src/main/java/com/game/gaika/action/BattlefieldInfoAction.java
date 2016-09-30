package com.game.gaika.action;

import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.gaika.scene.BattlefieldInfoScene;

/**
 * Created by fangxg on 2015/7/24.
 */
public class BattlefieldInfoAction implements BaseAction {
    @Override
    public void doAction() {

        SCENE_ID secenID = SceneManager.getTopBaseLogicScene().getSceneId();
        BattlefieldInfoScene battlefieldInfoScene = new BattlefieldInfoScene(secenID);
        SceneManager.render(battlefieldInfoScene);
    }
}
