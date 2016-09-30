package com.game.test;


import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;

/**
 * Created by devuser1 on 2016/9/22.
 */

public interface Testable {
    SCENE_ID getCurrentSceneId();
    BaseLogicScene getCurrentScene();
    GameElement getElement(String id);
}
