package com.game.frame.scene.camera;

import android.util.Pair;

import com.game.frame.scene.BaseLogicScene;


/**
 * Created by devuser1 on 2016/9/27.
 */

public abstract class BaseLogicCamera {

    protected BaseLogicScene parentScene;

    protected float cameraWidth;
    protected float cameraHeight;
    protected float centeX;
    protected float centeY;

    public CameraRange getCameraRenge() {
        float xMin = centeX - cameraWidth / 2;
        float xMax = centeX + cameraWidth / 2;
        float yMin = centeY - cameraHeight / 2;
        float yMax = centeY + cameraHeight / 2;
        return new CameraRange(xMin, yMin, xMax, yMax);
    }

    public float getCameraWidth() {
        return cameraWidth;
    }

    public float getCameraHeight() {
        return cameraHeight;
    }

    public Pair<Float, Float> getCente() {
        return new Pair<>(centeX, centeY);
    }


    public void setCente(Pair<Float, Float> cente) {
        centeX = cente.first;
        centeY = cente.second;
    }

}
