package com.game.frame.scene;

import android.util.Pair;


import com.game.frame.fsm.IMessageHandler;
import com.game.frame.scene.camera.BaseLogicCamera;
import com.game.frame.scene.dialg.DialogScene;
import com.game.frame.sprite.BaseSprite;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.IEntityMatcher;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.shape.RectangularShape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by devuser1 on 2016/9/27.
 */

public abstract  class BaseLogicScene implements IMessageHandler {
    protected SCENE_ID preSceneID;
    protected SCENE_ID sceneId;
    protected float offsetX;
    protected float offsetY;
    protected float width;
    protected float height;

    private List<BaseSprite> spriteList;

    private BaseLogicScene parentScene;
    private List<BaseLogicScene> childScenes;
    private BaseLogicScene hudScene;
    private DialogScene dialogSecne;

    private BaseLogicCamera camera;

//    public BaseLogicScene(ID.SCENE_ID pSceneId) {
//        this(pSceneId, 800.0f, 600.0f);
//    }
//
//    public BaseLogicScene(ID.SCENE_ID pSceneId, float pWidth, float pHeight) {
//        this(pSceneId, 0.0f, 0.0f, pWidth, pHeight);
//    }
    public BaseLogicScene(SCENE_ID pSceneId, float pOffsetX, float pOffsetY, float pWidth, float pHeight) {
        sceneId = pSceneId;
        offsetX = pOffsetX;
        offsetY = pOffsetY;
        width = pWidth;
        height = pHeight;
        spriteList = new ArrayList<BaseSprite>();
    }

    public void setPreSceneID(SCENE_ID preSceneID) {
        this.preSceneID = preSceneID;
    }

    public SCENE_ID getPreSceneID() {
        return preSceneID;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void addSprite(BaseSprite pSprite) {

        spriteList.add(pSprite);
        pSprite.setParentScene(this);
    }

    public void setParentScene(BaseLogicScene parentScene) {
        this.parentScene = parentScene;
    }

    public void addChildScene(BaseLogicScene pChildScene) {
        if (parentScene != null) {
            throw new IllegalArgumentException("Scene layer outnumber 2. ");
        }

        if (childScenes == null) {
            childScenes = new ArrayList<BaseLogicScene>();
        }
        pChildScene.parentScene = this;
        childScenes.add(pChildScene);
    }

    public void setHUDScene(BaseLogicScene pHUDScene) {
        hudScene = pHUDScene;
    }
    public BaseLogicScene getHUDScene() {
        return hudScene;
    }

    public void setDialogSecne(DialogScene pDialogScene) {
        if (pDialogScene != null) {
            pDialogScene.setParentScene(this);
        }
        dialogSecne = pDialogScene;
    }

    public DialogScene getDialogSecne() {

        DialogScene dialog = null;
        if (dialogSecne != null) {
            dialog = dialogSecne;
        }
        if (childScenes != null) {
            for (BaseLogicScene childScene : childScenes) {
                if (childScene.getDialogSecne() != null) {
                    if (dialog == null) {
                        dialog = childScene.getDialogSecne();
                    } else {
                        throw new IllegalArgumentException("DialogScenes count outnumber 2 --   Dialge 1: " + dialog.getSceneId() + "   Dialog 2: " + childScene.getDialogSecne());
                    }
                }
            }
        }

        return dialog;

    }

    public abstract boolean isBacegroundEnabled();

    private Scene getBackupScene() {
        Set<Integer> setZ = new HashSet<>();

        for (BaseSprite sprite : spriteList) {
            setZ.add(sprite.getZ());
        }
        Scene bkScene = new Scene();
        for (Integer z : setZ) {
            Entity entity = new Entity();
            entity.setZIndex(z);
            bkScene.attachChild(entity);
        }
        bkScene.sortChildren();
        return bkScene;

    }
    private static IEntity getChildByZIndex(Scene pBkScne, final int pZ) {
        IEntity zEntity = pBkScne.getChildByMatcher(new IEntityMatcher() {
            @Override
            public boolean matches(IEntity pEntity) {
                return pEntity.getZIndex() == pZ;
            }
        });
        return zEntity;
    }

    public Scene getScene() {

        this.buildScene();
        Scene bkScene = getBackupScene();

        bkScene.setBackgroundEnabled(isBacegroundEnabled());

        bkScene.clearTouchAreas();

//        sortSpriteListByZIndex();
        for (BaseSprite baseSprite : spriteList) {

            final RectangularShape shape = baseSprite.getShape();
            if (shape != null) {

                IEntity zEntity = getChildByZIndex(bkScene, baseSprite.getZ());
                zEntity.attachChild(shape);

                if (baseSprite.getTouchMessage() != null) {
                    bkScene.registerTouchArea(shape);
                }
            }
        }

        if (childScenes != null) {
            Scene lostChildScene = bkScene;
            float unOffsetX = 0.0f;
            float unOffsetY = 0.0f;
            for (BaseLogicScene childScene : childScenes) {
                Scene scene = childScene.getScene();

                scene.setPosition(childScene.getFinalOffset().first, childScene.getFinalOffset().second);
                lostChildScene.setChildScene(scene);

                unOffsetX -= childScene.getFinalOffset().first;
                unOffsetY -= childScene.getFinalOffset().second;

                lostChildScene = scene;
            }
        }
        bkScene.setTouchAreaBindingOnActionDownEnabled(true);
        return bkScene;
    }

    public Pair<Float, Float> getFinalOffset() {
        if (parentScene == null) {
            return new Pair(offsetX, offsetY);
        } else {
            Pair<Float, Float> parentOffset = parentScene.getFinalOffset();
            return new Pair(parentOffset.first + offsetX, parentOffset.second + offsetY);
        }

    }

    public abstract void buildScene();

//    public void f1(){
//
//        MyScreenCapture.captureSceneSmall4_3("", null,  1280, 720, this, ID.MSG_ID.MSG_SCENE_SYSTEM_POPUP_MENU__CAPTURED);
//    }

    public SCENE_ID getSceneId() {
        return sceneId;
    }

    public void setCamera(BaseLogicCamera camera) {
        this.camera = camera;
    }

    public BaseLogicCamera getCamera() {
        return camera;
    }
}
