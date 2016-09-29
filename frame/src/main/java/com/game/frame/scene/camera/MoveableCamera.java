package com.game.frame.scene.camera;


import android.util.Pair;

import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.camera.BaseLogicCamera;
import com.game.frame.scene.hud.HUDScene;
import com.game.frame.scene.value.SceneValueMap;

import static com.game.frame.scene.value.SceneValueMap.getSceneValuesMap;

/**
 * Created by devuser1 on 2016/9/27.
 */

public class MoveableCamera extends BaseLogicCamera {



    public MoveableCamera(float deviceWidth, float deviceHeight, float zoom, BaseLogicScene pParentScene) {
        super();
        cameraWidth  = deviceWidth * zoom;
        cameraHeight = deviceHeight * zoom;
        centeX  = cameraWidth / 2 ;
        centeY = cameraHeight / 2;
        parentScene = pParentScene;
    }



    @Override
    public void setCente(Pair<Float, Float> cente) {
        float centerX = cente.first;
        float centerY = cente.second;
        CameraRange cr = getCameraRenge();
        float w = cr.xMax - cr.xMin;
        float h = cr.yMax - cr.yMin;

        if (centerX < w / 2.0f) {
            centerX = w / 2.0f;
        } else if (centerX > parentScene.getWidth() - w / 2.0f) {
            centerX = parentScene.getWidth() - w / 2.0f;
        }

        if (centerY < h / 2.0f) {
            centerY = h / 2.0f;
        } else if (centerY > parentScene.getHeight() - h / 2.0f) {
            centerY = parentScene.getHeight() - h / 2.0f;
        }

        SceneValueMap sceneValues = getSceneValuesMap();
        sceneValues.setFloat("CameraCenterX", centerX);
        sceneValues.setFloat("CameraCenterY", centerY);

//        HUDScene hudScene = (HUDScene) parentScene.getHUDScene();
//        if (hudScene != null) {
//            if(hudScene instanceof  BattlefieldHUDScene) {
//                ((BattlefieldHUDScene)hudScene).setSmallMapBoxPoint(centerX - parentScene.getLogicCamera().getCameraWidth() / 2.0f, centerY - parentScene.getLogicCamera().getCameraHeight() / 2.0f);
//            }
//        }
    }


}
