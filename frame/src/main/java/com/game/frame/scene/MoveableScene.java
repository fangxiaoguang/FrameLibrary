package com.game.frame.scene;


import android.util.Pair;

import com.game.frame.scene.camera.MoveableCamera;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.SurfaceScrollDetector;

import static com.game.frame.global.FrameGlobal.getGameActivity;

/**
 * Created by devuser1 on 2016/9/27.
 */

public abstract class MoveableScene extends BaseLogicScene implements IOnSceneTouchListener, ScrollDetector.IScrollDetectorListener{
    private SurfaceScrollDetector mScrollDetector;

    public MoveableScene(SCENE_ID pSceneId, float pWidth, float pHeight,float deviceWidth, float deviceHeight,float zoom) {
        super(pSceneId, 0.0f, 0.0f, pWidth, pHeight);
        setCamera(new MoveableCamera( deviceWidth, deviceHeight, zoom, this));
    }

    @Override
    public boolean onSceneTouchEvent(Scene scene, TouchEvent pSceneTouchEvent) {
        if (pSceneTouchEvent.isActionDown()) {
            this.mScrollDetector.setEnabled(true);
        }
        this.mScrollDetector.onTouchEvent(pSceneTouchEvent);
        return true;
    }

    @Override
    public void onScrollStarted(ScrollDetector pScollDetector, int pPointerID, float pDistanceX, float pDistanceY) {
    }

    @Override
    public void onScroll(ScrollDetector pScollDetector, int pPointerID, float pDistanceX, float pDistanceY) {
        Camera camera = getGameActivity().getEngine().getCamera();

        float centerX = camera.getCenterX() - pDistanceX;
        float centerY = camera.getCenterY() - pDistanceY;
        if (centerX < camera.getWidth() / 2.0f) {
            centerX = camera.getWidth() / 2.0f;
        } else if (centerX > width - camera.getWidth() / 2.0f) {
            centerX = width - camera.getWidth() / 2.0f;
        }
        if (centerY < camera.getHeight() / 2.0f) {
            centerY = camera.getHeight() / 2.0f;
        } else if (centerY > height - camera.getHeight() / 2.0f) {
            centerY = height - camera.getHeight() / 2.0f;
        }

        camera.setCenter(centerX, centerY);


        getLogicCamera().setCente(new Pair<Float, Float>( centerX, centerY));
    }

    @Override
    public void onScrollFinished(ScrollDetector pScollDetector, int pPointerID, float pDistanceX, float pDistanceY) {

        // Log.d("SEL", "onScrollFinished = x: " + pDistanceX);
    }

    @Override
    public Scene getScene() {
        this.mScrollDetector = new SurfaceScrollDetector(this);
        Scene bkScne = super.getScene();
        bkScne.setOnSceneTouchListener(this);
        return bkScne;
    }
}
