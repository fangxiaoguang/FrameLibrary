package com.game.frame.scene;

import com.game.frame.flyweight.BaseFlyweight;
import com.game.frame.scene.camera.CameraRange;
import com.game.frame.scene.dialg.DialogScene;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;
//import com.game.gaika.profile.Profile;


public class SceneManager {

    private static BaseLogicScene topBaseLogicScene;
    private static BaseGameActivity gameActivity;

    public static void init(BaseGameActivity pGameActivity) {
        gameActivity = pGameActivity;

    }

    public static BaseLogicScene getTopBaseLogicScene() {
        return topBaseLogicScene;
    }

    public static void render(final BaseLogicScene pBaseLogicScene) {

        gameActivity.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                BaseFlyweight.clearTagedEntity();
                SceneManager.topBaseLogicScene = pBaseLogicScene;

                Scene tScene = pBaseLogicScene.getScene();

                gameActivity.getEngine().getScene().clearChildScene();
                gameActivity.getEngine().getScene().setChildSceneModal(tScene);


//                HUD mHud = null;
                if (pBaseLogicScene.getHUDScene() != null) {
                    HUD mHud = (HUD) (pBaseLogicScene.getHUDScene().getScene());
                    gameActivity.getEngine().getCamera().setHUD(mHud);
                } else {
                    gameActivity.getEngine().getCamera().setHUD(null);
                }

                DialogScene dialogScene = pBaseLogicScene.getDialogSecne();
                if (dialogScene != null) {

                    if (gameActivity.getEngine().getCamera().getHUD() != null) {
                        gameActivity.getEngine().getCamera().getHUD().clearTouchAreas();
                    }

                    Scene lostScene = tScene;
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

                CameraRange cr = pBaseLogicScene.getCamera().getCameraRenge();
                gameActivity.getEngine().getCamera().set(cr.xMin, cr.yMin, cr.xMax, cr.yMax);
            }
        });
    }


}