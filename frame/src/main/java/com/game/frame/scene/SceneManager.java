package com.game.frame.scene;

import com.game.frame.flyweight.BaseFlyweight;
import com.game.frame.fsm.IMessageHandler;
import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.graph.MyScreenCapture;
import com.game.frame.scene.camera.CameraRange;
import com.game.frame.scene.dialg.DialogScene;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.Scene;

import static com.game.frame.global.FrameGlobal.getGameActivity;
//import com.game.gaika.profile.Profile;


public class SceneManager {

    private static BaseLogicScene topBaseLogicScene;
    private static Scene bkTopScne;
    public static void init() {

    }

    public static BaseLogicScene getTopBaseLogicScene() {
        return topBaseLogicScene;
    }

    public static void render(final BaseLogicScene pBaseLogicScene) {

        getGameActivity().runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                BaseFlyweight.clearTagedEntity();
                SceneManager.topBaseLogicScene = pBaseLogicScene;


                bkTopScne =  pBaseLogicScene.getScene();
                getGameActivity().getEngine().getScene().clearChildScene();
                getGameActivity().getEngine().getScene().setChildSceneModal(bkTopScne);


//                HUD mHud = null;
                if (pBaseLogicScene.getHUDScene() != null) {
                    HUD mHud = (HUD) (pBaseLogicScene.getHUDScene().getScene());
                    getGameActivity().getEngine().getCamera().setHUD(mHud);
                } else {
                    getGameActivity().getEngine().getCamera().setHUD(null);
                }

                DialogScene dialogScene = pBaseLogicScene.getDialogSecne();
                if (dialogScene != null) {

                    if (getGameActivity().getEngine().getCamera().getHUD() != null) {
                        getGameActivity().getEngine().getCamera().getHUD().clearTouchAreas();
                    }

                    Scene lostScene = bkTopScne;
                    lostScene.clearTouchAreas();
                    lostScene.setOnSceneTouchListener(null);

                    while (lostScene.hasChildScene()) {
                        lostScene = lostScene.getChildScene();
                        lostScene.clearTouchAreas();
                        lostScene.setOnSceneTouchListener(null);
                    }

                    Scene dialog = dialogScene.getScene();
                    dialog.setPosition(dialogScene.getFinalOffset().first, dialogScene.getFinalOffset().second);
                    dialog.setScaleCenter(dialogScene.getWidth() / 2.0f, dialogScene.getHeight() / 2.0f);
                    //dialog.setScale(1.0f / GameSetup.settingBattlefieldZoom);//fangxg
                    lostScene.setChildScene(dialog);
                }

                CameraRange cr = pBaseLogicScene.getLogicCamera().getCameraRenge();
                getGameActivity().getEngine().getCamera().set(cr.xMin, cr.yMin, cr.xMax, cr.yMax);
            }
        });
    }
    public static void captureScene(String path, final IMessageHandler pPopupMenuHandler, float pDeviceWidthPixels, float pDeviceHeightPixels) {

        MyScreenCapture screenCapture = new MyScreenCapture();
        bkTopScne.attachChild(screenCapture);

        float captureWidth = pDeviceHeightPixels * 4.0f / 3.0f;
        float captureHeight = pDeviceHeightPixels;

        float captureX = (pDeviceWidthPixels - captureWidth) / 2;
        float captureY = 0.0f;


        screenCapture.capture((int) captureX, (int) captureY, (int) captureWidth, (int) captureHeight,
                path, new MyScreenCapture.IScreenCaptureCallback() {

                    @Override
                    public void onScreenCaptured(String pFilePath) {

                        TouchMessage msg = new TouchMessage(MSG_ID.MSG_SCENE_SYSTEM_POPUP_MENU__CAPTURED, null, pPopupMenuHandler);
                        msg.doProcess();
                    }

                    @Override
                    public void onScreenCaptureFailed(String pFilePath, Exception pException) {

                    }

                });
    }

}