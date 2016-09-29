package com.game.frame.scene.camera;

import android.util.Pair;

import com.game.frame.scene.camera.BaseLogicCamera;

/**
 * Created by devuser1 on 2016/9/27.
 */

public class FillDisplayCamera extends BaseLogicCamera {


    //private CameraRange cameraRange;

    public FillDisplayCamera(float sceneWidth, float sceneHeight,
                             float deviceWidth, float deviceHeight) {
        super();
        if (deviceWidth / deviceHeight > sceneWidth / sceneHeight) {
            float r = deviceWidth / deviceHeight;
            cameraHeight = sceneHeight;
            cameraWidth = r * sceneHeight;

            centeX = sceneWidth / 2;
            centeY = sceneHeight / 2;


        } else {
            float r = deviceHeight / deviceWidth;
            cameraWidth = sceneWidth;
            cameraHeight = r * sceneWidth;

            centeX = sceneWidth / 2;
            centeY = sceneHeight / 2;

        }
    }

    @Override
    public void setCente(Pair<Float, Float> cente) {

    }
}
