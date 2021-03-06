package com.game.gaika.scene;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sound.SoundManager;
import com.game.frame.sprite.DelaySprite;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.TextSprite;
import com.game.frame.string.StringManager;
import com.game.frame.texture.TexRegionManager;
import com.game.gaika.MainActivity;
import com.game.gaika.data.GameSetup;

import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.ParallelEntityModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.ui.activity.BaseGameActivity;

import java.util.ArrayList;
import java.util.List;

import static com.game.frame.sound.SoundManager.playSound;
import static com.game.frame.texture.TexRegionManager.getFont32;


/**
 * Created by fangxg on 2015/6/17.
 */
public class Logo3Scene extends SimpleScene {

    static private List<String> ss = new ArrayList<String>();

    static {
        ss.add(StringManager.getInstance().getString("S01001"));
        ss.add(StringManager.getInstance().getString("S01002"));
        ss.add(StringManager.getInstance().getString("S01003"));
        ss.add(StringManager.getInstance().getString("S01004"));
        ss.add(StringManager.getInstance().getString("S01005"));
        ss.add(StringManager.getInstance().getString("S01006"));
        ss.add(StringManager.getInstance().getString("S01007"));
        ss.add(StringManager.getInstance().getString("S01008"));
        ss.add(StringManager.getInstance().getString("S01009"));
        ss.add(StringManager.getInstance().getString("S01010"));
        ss.add(StringManager.getInstance().getString("S01011"));
        ss.add(StringManager.getInstance().getString("S01012"));
        ss.add(StringManager.getInstance().getString("S01013"));
        ss.add(StringManager.getInstance().getString("S01014"));
        ss.add(StringManager.getInstance().getString("S01015"));
        ss.add(StringManager.getInstance().getString("S01016"));
        ss.add(StringManager.getInstance().getString("S01017"));
        ss.add(StringManager.getInstance().getString("S01018"));
        ss.add(StringManager.getInstance().getString("S01019"));
        ss.add(StringManager.getInstance().getString("S01020"));
        ss.add(StringManager.getInstance().getString("S01021"));
        ss.add(StringManager.getInstance().getString("S01022"));
        ss.add(StringManager.getInstance().getString("S01023"));
        ss.add(StringManager.getInstance().getString("S01024"));
        ss.add(StringManager.getInstance().getString("S01025"));
        ss.add(StringManager.getInstance().getString("S01026"));
        ss.add(StringManager.getInstance().getString("S01027"));
        ss.add(StringManager.getInstance().getString("S01028"));
        ss.add(StringManager.getInstance().getString("S01029"));
        ss.add(StringManager.getInstance().getString("S01030"));
        ss.add(StringManager.getInstance().getString("S01031"));
        ss.add(StringManager.getInstance().getString("S01032"));
        ss.add(StringManager.getInstance().getString("S01033"));
        ss.add(StringManager.getInstance().getString("S01034"));
        ss.add(StringManager.getInstance().getString("S01035"));
        ss.add(StringManager.getInstance().getString("S01036"));
        ss.add(StringManager.getInstance().getString("S01037"));
        ss.add(StringManager.getInstance().getString("S01038"));
        ss.add(StringManager.getInstance().getString("S01039"));
        ss.add(StringManager.getInstance().getString("S01040"));
        ss.add(StringManager.getInstance().getString("S01041"));
        ss.add(StringManager.getInstance().getString("S01042"));
    }

    public Logo3Scene() {
        super(SCENE_ID.LOGO_3, 800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);
    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {
        float initAlpha = 0.25f;

        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "titl_bg1", 0, new TouchMessage(MSG_ID.MSG_SCENE_LOGO_3__BACKUP_SCENE_TOUCH, null, this));
        backSprite.getFlyweight().setAlpha(initAlpha);
        backSprite.setId("id001");
        addSprite(backSprite);

        int initX = 0;//-100;// 25;
        int count = 0;
        for (String s : ss) {
            TextSprite textSprite = new TextSprite(initX, 700, true, s, getFont32());

            textSprite.registerEntityModifier(new SequenceEntityModifier(
                            new DelayModifier(1.0f * count), new ParallelEntityModifier(
                            new MoveModifier(15.0f, initX, initX, 550, 30),
                            new SequenceEntityModifier(new AlphaModifier(3, 0.0f, 1.0f), new DelayModifier(9.0f), new AlphaModifier(3, 1.0f, 0.0f))
                    )
                    )
            );

            addSprite(textSprite);
            count++;
        }
        backSprite.registerEntityModifier(new SequenceEntityModifier(new DelayModifier(1.0f * count + 10), new AlphaModifier(5, initAlpha, 1.0f)));
        DelaySprite delaySprite = new DelaySprite((1.0f * count + 15.0f) , new TouchMessage(MSG_ID.MSG_SCENE_LOGO_3__DELAY_TIME_OUT, null, this));
        addSprite(delaySprite);
    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {

        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_LOGO_3__DELAY_TIME_OUT || pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_LOGO_3__BACKUP_SCENE_TOUCH) {
            playSound("select01");
            BeginMenuSceen beginMenuSceen = new BeginMenuSceen();
            SceneManager.render(beginMenuSceen);
        }
    }
}
