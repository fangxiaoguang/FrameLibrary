package com.game.gaika.scene;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.GameSetup;

/**
 * Created by fangxg on 2015/7/27.
 */
public class ChapterLoseScene extends SimpleScene {
    public ChapterLoseScene() {
        super(SCENE_ID.CHAPTER_LOSE, 800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);

        NormalSprite bkSprite = new NormalSprite(0.0f, 0.0f, "fail_bg1");
        addSprite(bkSprite);

        NormalSprite buttonSprite = new NormalSprite(553, 499, "fail_bt1", 1, new TouchMessage(MSG_ID.MSG_SCENE_CHAPTER_LOSE__BACK,null, this));
        addSprite(buttonSprite);

    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {

    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        MSG_ID msgID = pTouchMessage.getMessageID();
        if(msgID == MSG_ID.MSG_SCENE_CHAPTER_LOSE__BACK){
            BeginMenuSceen  beginMenuSceen = new BeginMenuSceen();
            SceneManager.render(beginMenuSceen);
        }
    }
}
