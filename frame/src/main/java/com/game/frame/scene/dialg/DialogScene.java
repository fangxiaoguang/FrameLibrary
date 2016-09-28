package com.game.frame.scene.dialg;


import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;

/**
 * Created by fangxg on 2015/6/22.
 */
public abstract class DialogScene extends BaseLogicScene {
    public enum EPointModel{POINT_MODEL_CENTER, POINT_MODEL_OFFSET}

    private EPointModel pointModel;

    public DialogScene(SCENE_ID pSceneId, float pOffsetX, float pOffsetY, float pWidth, float pHeight, BaseLogicScene pParentScene, EPointModel pPointModel) {
        super(pSceneId, pOffsetX, pOffsetY, pWidth, pHeight);
        pointModel = pPointModel;

     /*   if(pPointModel == EPointModel.POINT_MODEL_CENTER) {
            CameraRange cr = pParentScene.getLogicCamera().getCameraRenge();
            float cx = (cr.xMax + cr.xMin) / 2.0f;
            float cy = (cr.yMax + cr.yMin) / 2.0f;

            setOffsetXY(cx - width / 2.0f, cy - height / 2.0f);
        }
        if(pPointModel == EPointModel.POINT_MODEL_OFFSET) {
            setOffset(pOffsetX, pOffsetY);
        }*/
    }
}
