package com.game.gaika.scene;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.GameSetup;
import com.game.gaika.scene.sub.BorderSubScene;

import static com.game.frame.sound.SoundManager.playSound;
import static com.game.gaika.data.ID.GAME_DIFF.*;

/**
 * Created by fangxg on 2015/6/18.
 */
public class DiffMenuScene extends SimpleScene{
//    enum MSG_ID{MSG_BUTTON_EASE, MSG_BUTTON_HARD, MSG_BUTTON_VERY_HARD, MSG_BUTTON_BACK}

    public DiffMenuScene() {
        super(SCENE_ID.DIFF_MENU,  800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);
        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "titl_bg4");
        addSprite(backSprite);


        NormalSprite buttonSprite1 = new NormalSprite(326, 380, "titl_bt2", 4, new TouchMessage(MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_EASE, null, this));
        buttonSprite1.setId("bt001");
        addSprite(buttonSprite1);
        NormalSprite buttonSprite2 = new NormalSprite(326, 420, "titl_bt2", 5, new TouchMessage(MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_HARD, null, this));
        addSprite(buttonSprite2);
        NormalSprite buttonSprite3 = new NormalSprite(326, 460, "titl_bt2", 6, new TouchMessage(MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_VERY_HARD, null, this));
        addSprite(buttonSprite3);
        NormalSprite buttonSprite4 = new NormalSprite(326, 520, "titl_bt2", 7, new TouchMessage(MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_BACK, null, this));
        addSprite(buttonSprite4);

        addChildScene(new BorderSubScene(this));
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
        GameDataManager gdm = GameDataManager.getInstance();
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_EASE
                || pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_HARD
                || pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_VERY_HARD) {
            playSound("select01");
            if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_EASE) {
                gdm.gameBeginDiff = HARD;
            }
            if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_HARD) {
                gdm.gameBeginDiff = HARD;
            }
            if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_VERY_HARD) {
                gdm.gameBeginDiff = VERY_HARD;
            }

            BeginLocalScene beginLocalScene = new BeginLocalScene();
            SceneManager.render(beginLocalScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_DIFF_MENU__BUTTON_BACK) {
            playSound("back01");
            BeginMenuSceen beginMenuSceen = new BeginMenuSceen();
            SceneManager.render(beginMenuSceen);
        }
    }
}
