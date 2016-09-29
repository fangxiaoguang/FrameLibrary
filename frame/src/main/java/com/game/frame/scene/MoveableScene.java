package com.game.frame.scene;


import com.game.frame.scene.camera.MoveableCamera;

/**
 * Created by devuser1 on 2016/9/27.
 */

public abstract class MoveableScene extends BaseLogicScene{
    public MoveableScene(SCENE_ID pSceneId, float pWidth, float pHeight,float deviceWidth, float deviceHeight,float zoom) {
        super(pSceneId, 0.0f, 0.0f, pWidth, pHeight);
        setCamera(new MoveableCamera( deviceWidth, deviceHeight, zoom, this));
    }
}
