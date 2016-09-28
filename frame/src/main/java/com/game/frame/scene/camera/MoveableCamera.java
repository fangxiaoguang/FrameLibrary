package com.game.frame.scene.camera;


import com.game.frame.scene.camera.BaseLogicCamera;

/**
 * Created by devuser1 on 2016/9/27.
 */

public class MoveableCamera extends BaseLogicCamera {



    public MoveableCamera(float deviceWidth, float deviceHeight,float zoom) {
        cameraWidth  = deviceWidth * zoom;
        cameraHeight = deviceHeight * zoom;
        centeX  = cameraWidth / 2 ;
        centeY = cameraHeight / 2;
    }






}
