package com.game.test;


import com.game.frame.scene.BaseLogicScene;
import com.game.frame.sprite.BaseSprite;

import org.andengine.ui.activity.BaseGameActivity;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Created by devuser1 on 2016/9/22.
 */

public class GameElement {
    private BaseGameActivity gameActivity;
    private BaseLogicScene blScene;
    private BaseSprite bSprite;

    public GameElement(BaseLogicScene blScene, BaseSprite bSprite, BaseGameActivity pGameActivity) {

        this.blScene = blScene;
        this.bSprite = bSprite;
        this.gameActivity = pGameActivity;
    }

    public void click() {
        gameActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //blScene.onHandlMessage(bSprite.getTouchMessage());
                bSprite.getTouchMessage().doProcess();
            }
        });


    }
}
