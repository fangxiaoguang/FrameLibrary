package com.game.gaika.scene.sub;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.sub.SubScene;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.ID;
import com.game.gaika.scene.SceneFactory;

import java.util.Set;

import static com.game.frame.scene.value.SceneValueMap.getSceneValuesMap;
import static com.game.frame.sound.SoundManager.playSound;
import static com.game.gaika.data.ID.COUNTRY.*;

/**
 * Created by fangxg on 2015/6/23.
 */
public class FlagsSubScene extends SubScene{
//    enum MSG_ID {MSG_BUTTON_FLAG_1, MSG_BUTTON_FLAG_2, MSG_BUTTON_FLAG_3, MSG_BUTTON_FLAG_4, MSG_BUTTON_FLAG_5, MSG_BUTTON_FLAG_6, MSG_BUTTON_FLAG_7}

    private String subTag = "";

    public FlagsSubScene(String pSubTag, BaseLogicScene pParentScene) {
        super(SCENE_ID.FLAGS_SUB);


        setParentScene(pParentScene);
        subTag = pSubTag;
        Set<Enum> filterSet = (Set<Enum>) getSceneValuesMap().getObject("countryFilter" + subTag);
        float offsetX = 0.0f;
        NormalSprite btnFlags1 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(USA) ? 9 : 33, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_1, null, this));
        addSprite(btnFlags1);
        offsetX += 34;
        NormalSprite btnFlags2 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(USN) ? 10 : 34, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_2, null, this));
        addSprite(btnFlags2);
        offsetX += 34;
        NormalSprite btnFlags3 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(RUSSIA) ? 11 : 35, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_3, null, this));
        addSprite(btnFlags3);
        offsetX += 34;
        NormalSprite btnFlags4 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(GERMANY) ? 12 : 36, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_4, null, this));
        addSprite(btnFlags4);
        offsetX += 34;
        NormalSprite btnFlags5 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(ENGLAND) ? 13 : 37, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_5, null, this));
        addSprite(btnFlags5);
        offsetX += 34;
        NormalSprite btnFlags6 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(JAPAN) ? 14 : 38, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_6, null, this));
        addSprite(btnFlags6);
        offsetX += 34;
        NormalSprite btnFlags7 = new NormalSprite(offsetX, 0.0f, "oper_bt2", filterSet.contains(ALL) ? 15 : 39, new TouchMessage(MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_7, null, this));
        addSprite(btnFlags7);


    }

    @Override
    public boolean isBacegroundEnabled() {
        return false;
    }

    @Override
    public void buildScene() {

    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        Enum msgID = pTouchMessage.getMessageID();
        Set<Enum> filterSet = (Set<Enum>) getSceneValuesMap().getObject("countryFilter" + subTag);
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_1) {
             playSound("select01");
            if (filterSet.contains(USA) == true) {
                filterSet.remove(USA);
            } else {
                filterSet.add(USA);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_2) {
             playSound("select01");
            if (filterSet.contains(USN) == true) {
                filterSet.remove(USN);
            } else {
                filterSet.add(USN);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_3) {
             playSound("select01");
            if (filterSet.contains(RUSSIA) == true) {
                filterSet.remove(RUSSIA);
            } else {
                filterSet.add(RUSSIA);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_4) {
             playSound("select01");
            if (filterSet.contains(GERMANY) == true) {
                filterSet.remove(GERMANY);
            } else {
                filterSet.add(GERMANY);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_5) {
             playSound("select01");
            if (filterSet.contains(ENGLAND) == true) {
                filterSet.remove(ENGLAND);
            } else {
                filterSet.add(ENGLAND);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_6) {
             playSound("select01");
            if (filterSet.contains(JAPAN) == true) {
                filterSet.remove(JAPAN);
            } else {
                filterSet.add(JAPAN);
            }
        }
        if (msgID == MSG_ID.MSG_SCENE_FLAGS_SUB__BUTTON_FLAG_7) {
             playSound("select01");
            if (filterSet.contains(ALL) == true) {
                filterSet.remove(ALL);
            } else {
                filterSet.add(ALL);
            }
        }
        getSceneValuesMap().remove("selectedWeaponID");
        BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
        SceneManager.render(baseLogicScene);
    }
}
