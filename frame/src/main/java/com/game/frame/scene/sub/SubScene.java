package com.game.frame.scene.sub;


import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;

/**
 * Created by devuser1 on 2016/9/27.
 */

public abstract class SubScene extends BaseLogicScene {
    public SubScene(SCENE_ID pSceneId) {
        super(pSceneId, 0.0f, 0.0f, 0.0f, 0.0f);
    }
    public SubScene(SCENE_ID pSceneId, float pOffsetX, float pOffsetY, float pWidth, float pHeight) {
        super(pSceneId, pOffsetX, pOffsetY, pWidth, pHeight);
    }
}
