package com.game.gaika.scene;


import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sprite.DelaySprite;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.GameSetup;

import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;



/**
 * Created by fangxg on 2015/6/17.
 */
public class Logo2Scene extends SimpleScene{

    public Logo2Scene() {
        super(SCENE_ID.LOGO_2,  800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);
    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {
        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "logo_2");
        backSprite.registerEntityModifier(new SequenceEntityModifier(new AlphaModifier(1000 / 1000.0f, 0.0f, 1.0f), new DelayModifier(1000 / 1000.0f), new AlphaModifier(1000 / 1000.0f, 1.0f, 0.0f)));
        addSprite(backSprite);

        DelaySprite delaySprite = new DelaySprite(3.0f, new TouchMessage(MSG_ID.MSG_SCENE_LOGO_2__DELAY_TIME_OUT, null, this));
        addSprite(delaySprite);
    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_LOGO_2__DELAY_TIME_OUT) {
            Logo3Scene logo3Scene = new Logo3Scene();
            SceneManager.render(logo3Scene);
        }
    }
}
