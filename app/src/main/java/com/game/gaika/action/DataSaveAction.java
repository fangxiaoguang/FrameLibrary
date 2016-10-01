package com.game.gaika.action;

import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.gaika.data.ID;

/**
 * Created by fangxg on 2015/7/24.
 */
public class DataSaveAction implements BaseAction {
    @Override
    public void doAction() {
        SCENE_ID secenID = SceneManager.getTopBaseLogicScene().getSceneId();
        SaveGameScene saveGameScene = new SaveGameScene(true, secenID);
        SceneManager.render(saveGameScene);
    }
}
