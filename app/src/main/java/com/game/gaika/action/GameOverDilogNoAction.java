package com.game.gaika.action;

import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.gaika.data.ID;
import com.game.gaika.scene.SceneFactory;

import static com.game.gaika.data.ID.SCENE_INIT_TYPE.NOT_INIT;

/**
 * Created by fangxg on 2015/7/25.
 */
public class GameOverDilogNoAction implements BaseAction {
    @Override
    public void doAction() {
        SCENE_ID currentSceneID = SceneManager.getTopBaseLogicScene().getSceneId();
        BaseLogicScene scene = SceneFactory.createScene(currentSceneID, NOT_INIT);
        SceneManager.render(scene);
    }
}
