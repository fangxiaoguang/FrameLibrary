package com.game.gaika.action;

import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.gaika.scene.SettingScene;

/**
 * Created by fangxg on 2015/7/25.
 */
public class SettingAction implements BaseAction {
    @Override
    public void doAction() {
        SCENE_ID secenID = SceneManager.getTopBaseLogicScene().getSceneId();
        SettingScene settingScene = new SettingScene( true, secenID);
        SceneManager.render(settingScene );
    }
}
