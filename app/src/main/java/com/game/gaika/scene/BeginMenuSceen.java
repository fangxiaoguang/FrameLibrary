package com.game.gaika.scene;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.global.FrameGlobal;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.GameSetup;
import com.game.gaika.data.SaveManager;
import com.game.gaika.scene.sub.BorderSubScene;

import static com.game.frame.global.FrameGlobal.getGameActivity;
import static com.game.frame.sound.SoundManager.playSound;

/**
 * Created by fangxg on 2015/6/18.
 */
public class BeginMenuSceen  extends SimpleScene {
    public BeginMenuSceen() {
        super(SCENE_ID.BEGIN_MENU,  800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);
        SaveManager.reInitChapters();
    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {
        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "titl_bg3");
        addSprite(backSprite);

        NormalSprite buttonSprite1 = new NormalSprite(326, 368, "titl_bt1", 0, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_NEW_GAME, null, this));
        buttonSprite1.setId("bt001");
        addSprite(buttonSprite1);
        NormalSprite buttonSprite2 = new NormalSprite(326, 406, "titl_bt1", 1, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_LOAD_GAME, null, this));
        addSprite(buttonSprite2);
        NormalSprite buttonSprite3 = new NormalSprite(326, 464, "titl_bt1", 2, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_SETTING, null, this));
        addSprite(buttonSprite3);
        NormalSprite buttonSprite4 = new NormalSprite(326, 520, "titl_bt1", 3, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_BACK_GAME, null, this));
        addSprite(buttonSprite4);

        addChildScene(new BorderSubScene(this));
    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_NEW_GAME) {
            playSound("select01");
            DiffMenuScene scene = new DiffMenuScene();
            SceneManager.render(scene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_LOAD_GAME) {
            playSound("select01");
            LoadGameScene scene = new LoadGameScene(true, SCENE_ID.BEGIN_MENU);
            SceneManager.render(scene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_SETTING) {
            playSound("select01");
            SettingScene scene = new SettingScene(true,SCENE_ID.BEGIN_MENU);
            SceneManager.render(scene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_BEGIN_MENU__BUTTON_BACK_GAME) {
            playSound("back01");
            getGameActivity().finish();
        }
    }
}
