package com.game.frame.global;

import org.andengine.ui.activity.BaseGameActivity;

/**
 * Created by devuser1 on 2016/9/28.
 */

public class FrameGlobal {
    private static BaseGameActivity gameActivity;

    public static void setGameActivity(BaseGameActivity gameActivity) {
        FrameGlobal.gameActivity = gameActivity;
    }

    public static BaseGameActivity getGameActivity() {
        return gameActivity;
    }
}
