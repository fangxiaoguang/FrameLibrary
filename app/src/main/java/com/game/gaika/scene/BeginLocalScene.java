package com.game.gaika.scene;

import com.game.frame.fsm.FSMClass;
import com.game.frame.fsm.FSMState;
import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.TextSprite;
import com.game.frame.string.StringManager;
import com.game.frame.texture.TexRegionManager;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.GameSetup;
import com.game.gaika.scene.sub.BorderSubScene;
import com.game.gaika.sprite.BeginLocalSprite;

import static com.game.frame.sound.SoundManager.playSound;
import static com.game.frame.texture.TexRegionManager.getFont16;
import static com.game.gaika.scene.BeginLocalScene.StateID.*;

import static com.game.gaika.data.ID.COUNTRY.*;


/**
 * Created by fangxg on 2015/6/18.
 */


public class BeginLocalScene extends SimpleScene {

    enum StateID {STATE_ID_SELECTED_LOCAL_NON, STATE_ID_SELECTED_LOCAL_1, STATE_ID_SELECTED_LOCAL_2, STATE_ID_SELECTED_LOCAL_3, STATE_ID_SELECTED_LOCAL_4, STATE_ID_SELECTED_LOCAL_5, STATE_ID_SELECTED_LOCAL_6}

    private static FSMClass fsmClass;
    // enum MSG_ID {MSG_BUTTON_SELECT_LOCAL_1, MSG_BUTTON_SELECT_LOCAL_2, MSG_BUTTON_SELECT_LOCAL_3, MSG_BUTTON_SELECT_LOCAL_4, MSG_BUTTON_SELECT_LOCAL_5, MSG_BUTTON_SELECT_LOCAL_6, MSG_BUTTON_BACK}

    public BeginLocalScene() {
        this(STATE_ID_SELECTED_LOCAL_NON);
    }

    public BeginLocalScene(Enum pStateID) {
        super(SCENE_ID.BEGIN_LOCAL,  800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);


        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "stat1_bg");
        addSprite(backSprite);

        buildFSM(pStateID);

        BeginLocalSprite blSprite1 = new BeginLocalSprite(121, 388, StringManager.getInstance().getString("S02001"), 1, pStateID == STATE_ID_SELECTED_LOCAL_1, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, null, this, 0));//  1 3 4 0 5 2
        blSprite1.setId("bl001");
        addSprite(blSprite1);
        BeginLocalSprite blSprite2 = new BeginLocalSprite(199, 358, StringManager.getInstance().getString("S02002"), 3, pStateID == STATE_ID_SELECTED_LOCAL_2, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, null, this, 0));//  1 3 4 0 5 2
        addSprite(blSprite2);
        BeginLocalSprite blSprite3 = new BeginLocalSprite(289, 385, StringManager.getInstance().getString("S02003"), 4, pStateID == STATE_ID_SELECTED_LOCAL_3, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, null, this, 0));//  1 3 4 0 5 2
        addSprite(blSprite3);
        BeginLocalSprite blSprite4 = new BeginLocalSprite(395, 365, StringManager.getInstance().getString("S02004"), 0, pStateID == STATE_ID_SELECTED_LOCAL_4, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, null, this, 0));//  1 3 4 0 5 2
        addSprite(blSprite4);
        BeginLocalSprite blSprite5 = new BeginLocalSprite(468, 297, StringManager.getInstance().getString("S02005"), 5, pStateID == STATE_ID_SELECTED_LOCAL_5, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, null, this, 0));//  1 3 4 0 5 2
        addSprite(blSprite5);
        BeginLocalSprite blSprite6 = new BeginLocalSprite(606, 106, StringManager.getInstance().getString("S02006"), 2, pStateID == STATE_ID_SELECTED_LOCAL_6, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, null, this, 0));//  1 3 4 0 5 2
        addSprite(blSprite6);


        String str1 = "";
        String str2 = "";
        if (pStateID == STATE_ID_SELECTED_LOCAL_1) {
            str1 = StringManager.getInstance().getString("S02001");
            str2 = StringManager.getInstance().getString("S02011");
        }
        if (pStateID == STATE_ID_SELECTED_LOCAL_2) {
            str1 = StringManager.getInstance().getString("S02002");
            str2 = StringManager.getInstance().getString("S02012");
        }
        if (pStateID == STATE_ID_SELECTED_LOCAL_3) {
            str1 = StringManager.getInstance().getString("S02003");
            str2 = StringManager.getInstance().getString("S02013");
        }
        if (pStateID == STATE_ID_SELECTED_LOCAL_4) {
            str1 = StringManager.getInstance().getString("S02004");
            str2 = StringManager.getInstance().getString("S02014");
        }
        if (pStateID == STATE_ID_SELECTED_LOCAL_5) {
            str1 = StringManager.getInstance().getString("S02005");
            str2 = StringManager.getInstance().getString("S02015");
        }
        if (pStateID == STATE_ID_SELECTED_LOCAL_6) {
            str1 = StringManager.getInstance().getString("S02006");
            str2 = StringManager.getInstance().getString("S02016");
        }
        TextSprite textSprite1 = new TextSprite(630 + 120, 490, false, str1, getFont16());
        addSprite(textSprite1);
        TextSprite textSprite2 = new TextSprite(630 + 120, 540, false, str2, getFont16());
        addSprite(textSprite2);


        NormalSprite buttonSprite1 = new NormalSprite(35, 556, "retn_bt1", 0, new TouchMessage(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_BACK, null, this));
        addSprite(buttonSprite1);

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
        MSG_ID msgID = pTouchMessage.getMessageID();

        if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1 || msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2
                || msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3 || msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4
                || msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5 || msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6) {
            playSound("select01");
            if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1) {
                gdm.gameBeginLocal = USN;
            }
            if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2) {
                gdm.gameBeginLocal = GERMANY;
            }
            if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3) {
                gdm.gameBeginLocal = ENGLAND;
            }
            if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4) {
                gdm.gameBeginLocal = USA;
            }
            if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5) {
                gdm.gameBeginLocal = JAPAN;
            }
            if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6) {
                gdm.gameBeginLocal = RUSSIA;
            }

            Enum oldState = fsmClass.getCurrentStateID();
            fsmClass.stateTransition(pTouchMessage.getMessageID());
            Enum newState = fsmClass.getCurrentStateID();
            onStateChanged(oldState, newState, pTouchMessage);
        }
        if (msgID == MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_BACK) {
            playSound("back01");
            DiffMenuScene diffMenuScene = new DiffMenuScene();
            SceneManager.render(diffMenuScene);
        }
    }


    public void onStateChanged(Enum oldState, Enum newState, TouchMessage pTouchMessage) {
        GameDataManager gdm = GameDataManager.getInstance();
        if (oldState != newState) {

            BeginLocalScene beginLocalScene = new BeginLocalScene(newState);

            SceneManager.render(beginLocalScene);
        }
        if (oldState == newState) {


            BeginCountyScene scene = new BeginCountyScene();
            SceneManager.render(scene);
        }
    }


    public void buildFSM(Enum pCurrentStateID) {
        fsmClass = new FSMClass(pCurrentStateID);

        FSMState stateNon = new FSMState(STATE_ID_SELECTED_LOCAL_NON);
        stateNon.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        stateNon.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        stateNon.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        stateNon.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        stateNon.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        stateNon.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(stateNon);

        FSMState state1 = new FSMState(STATE_ID_SELECTED_LOCAL_1);
        state1.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        state1.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        state1.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        state1.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        state1.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        state1.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(state1);

        FSMState state2 = new FSMState(STATE_ID_SELECTED_LOCAL_2);
        state2.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        state2.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        state2.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        state2.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        state2.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        state2.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(state2);

        FSMState state3 = new FSMState(STATE_ID_SELECTED_LOCAL_3);
        state3.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        state3.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        state3.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        state3.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        state3.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        state3.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(state3);

        FSMState state4 = new FSMState(STATE_ID_SELECTED_LOCAL_4);
        state4.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        state4.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        state4.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        state4.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        state4.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        state4.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(state4);

        FSMState state5 = new FSMState(STATE_ID_SELECTED_LOCAL_5);
        state5.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        state5.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        state5.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        state5.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        state5.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        state5.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(state5);

        FSMState state6 = new FSMState(STATE_ID_SELECTED_LOCAL_6);
        state6.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_1, STATE_ID_SELECTED_LOCAL_1);
        state6.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_2, STATE_ID_SELECTED_LOCAL_2);
        state6.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_3, STATE_ID_SELECTED_LOCAL_3);
        state6.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_4, STATE_ID_SELECTED_LOCAL_4);
        state6.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_5, STATE_ID_SELECTED_LOCAL_5);
        state6.addTransition(MSG_ID.MSG_SCENE_BEGIN_LOCAL__BUTTON_SELECT_LOCAL_6, STATE_ID_SELECTED_LOCAL_6);
        fsmClass.addState(state6);

    }
}
