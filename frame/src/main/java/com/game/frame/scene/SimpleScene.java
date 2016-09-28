package com.game.frame.scene;


import com.game.frame.scene.camera.FillDisplayCamera;

/**
 * Created by devuser1 on 2016/9/27.
 */

public abstract class SimpleScene extends BaseLogicScene {
    public SimpleScene(SCENE_ID pSceneId, float pWidth, float pHeight, float deviceWidth,
                       float deviceHeight) {
        super(pSceneId, 0.0f, 0.0f, pWidth, pHeight);
        setCamera(new FillDisplayCamera(pWidth, pHeight, deviceWidth, deviceHeight));
    }
}
