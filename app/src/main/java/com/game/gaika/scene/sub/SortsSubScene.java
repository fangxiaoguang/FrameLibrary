package com.game.gaika.scene.sub;

import android.util.Pair;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.dialg.DialogScene;
import com.game.frame.scene.sub.SubScene;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.TextSprite;
import com.game.gaika.data.ID;
import com.game.gaika.scene.SceneFactory;
import com.game.gaika.scene.dialg.SortMenuScene;
import java.util.ArrayList;
import java.util.List;

import static com.game.frame.scene.value.SceneValueMap.getSceneValuesMap;
import static com.game.frame.sound.SoundManager.playSound;
import static com.game.frame.texture.TexRegionManager.getFont16;
import static com.game.gaika.data.ID.STOR_TYPE.*;
import static com.game.gaika.data.ID.SORT_ASCEND.*;
import static com.game.gaika.scene.sub.SortsSubScene.ShowStatic.*;

/**
 * Created by fangxg on 2015/6/23.
 */
public class SortsSubScene extends SubScene {


    enum ShowStatic {SHOW_STATIC_NON, SHOW_STATIC_SHOW_MENU}

//    enum MSG_ID {MSG_BUTTON_SORT, MSG_BUTTON_TYPE, MSG_BUTTON_NAME, MSG_BUTTON_LEVEL, MSG_BUTTON_SUPPLY, MSG_BUTTON_ASCEND;}

    private String subTag = "";

    private List<ID.STOR_TYPE> items;

    private Enum showState;
//
//    private Enum sortType;
//    private Enum sortAssend;
//    private IMessageHandler parentMsgHandler;


    public SortsSubScene(String pSubTag, List<ID.STOR_TYPE> pItems, BaseLogicScene pParentScene) {
        super(SCENE_ID.SORTS_SUB);
        setParentScene(pParentScene);
        subTag = pSubTag;
        items = pItems;

        NormalSprite btnSortSprite = new NormalSprite(0.0f, 0.0f, "oper_bt1", 0, new TouchMessage(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_SORT, null, this));
        addSprite(btnSortSprite);

        ID.STOR_TYPE eSortType = (ID.STOR_TYPE) getSceneValuesMap().getEnum("sortType" + subTag);
        TextSprite textSprite = new TextSprite(74.0f, 5.0f, true, eSortType.toDescribeString(), getFont16());
        addSprite(textSprite);

        if (getSceneValuesMap().containsKey("sortShowState" + subTag) == true && getSceneValuesMap().getEnum("sortShowState" + subTag) == SHOW_STATIC_SHOW_MENU) {
            List<Enum> listItems = new ArrayList<>();
            List<MSG_ID> listMessageIDs = new ArrayList<>();

            for (ID.STOR_TYPE sortType : items) {
                listItems.add(sortType);
                if (sortType == ID.STOR_TYPE.TYPE) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_TYPE);
                } else if (sortType == ID.STOR_TYPE.NAME) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_NAME);
                } else if (sortType == ID.STOR_TYPE.COUNTRY) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_COUNTRY);
                } else if (sortType == ID.STOR_TYPE.BUY_COST) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_BUY_COST);
                } else if (sortType == ID.STOR_TYPE.LEVEL) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_LEVEL);
                } else if (sortType == ID.STOR_TYPE.REPAIR_COST) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_REPAIR_COST);
                } else if (sortType == ID.STOR_TYPE.SELL_COST) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_SELL_COST);
                } else if (sortType == ID.STOR_TYPE.SUPPLY) {
                    listMessageIDs.add(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_SUPPLY);
                }
            }

            DialogScene sortMenuScene = new SortMenuScene(listItems, listMessageIDs, this);
            sortMenuScene.setOffset(new Pair<Float, Float>(74.0f, 25.0f));
            setDialogSecne(sortMenuScene);
        }


        int index = 8;
        if (getSceneValuesMap().getEnum("sortAscend" + subTag) == UP) {
            index = 32;
        } else if (getSceneValuesMap().getEnum("sortAscend" + subTag) == DOWN) {
            index = 8;
        }
        NormalSprite btnSortAscendSprite = new NormalSprite(142.0f, 0.0f, "oper_bt2", index, new TouchMessage(MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_ASCEND, null, this));
        addSprite(btnSortAscendSprite);

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


        //MSG_BUTTON_SORT, MSG_BUTTON_TYPE, MSG_BUTTON_NAME, MSG_BUTTON_LEVEL, MSG_BUTTON_SUPPLY, MSG_BUTTON_ASCEND
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_SORT) {
            playSound("select01");
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_SHOW_MENU);
            getSceneValuesMap().remove("selectedWeaponID" + subTag);

            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
//            WeaponSetoutScene WeaponSetoutScene = new WeaponSetoutScene();
//            SceneManager.render(WeaponSetoutScene);
        }

        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_TYPE) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, TYPE);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_NAME) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, NAME);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_COUNTRY) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, COUNTRY);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_BUY_COST) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, BUY_COST);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_LEVEL) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, LEVEL);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_REPAIR_COST) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, REPAIR_COST);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_SELL_COST) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, SELL_COST);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_SUPPLY) {
            getSceneValuesMap().setEnum("sortShowState" + subTag, SHOW_STATIC_NON);
            getSceneValuesMap().setEnum("sortType" + subTag, SUPPLY);
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
        if (pTouchMessage.getMessageID() == MSG_ID.MSG_SCENE_SORTS_SUB__BUTTON_ASCEND) {
            playSound("select01");
            if (getSceneValuesMap().getEnum("sortAscend" + subTag) == UP) {
                getSceneValuesMap().setEnum("sortAscend" + subTag, DOWN);
            } else if (getSceneValuesMap().getEnum("sortAscend" + subTag) == DOWN) {
                getSceneValuesMap().setEnum("sortAscend" + subTag, UP);
            }
            getSceneValuesMap().remove("selectedWeaponID");
            BaseLogicScene baseLogicScene = SceneFactory.createScene(getParentScene().getSceneId(), ID.SCENE_INIT_TYPE.NOT_INIT);
            SceneManager.render(baseLogicScene);
        }
    }

   /* @Override
    public void onStateChanged(Enum oldState, Enum newState, TouchMessage pTouchMessage) {

    }

    @Override
    public void buildFSM(Enum pCurrentStateID) {

        addFSMClass("showStateFSM", new FSMClass(showState));

       *//* FSMState showStateNON = new FSMState(SHOW_STATIC_NON);
        showStateNON.addTransition(MSG_BUTTON_SORT, SHOW_STATIC_SHOW_MENU);
        getFSMClass("showStateFSM").addState(showStateNON);*//*


        addFSMClass("sortTypeFSM", new FSMClass(sortType));

        FSMState stateType = new FSMState(TYPE);
        stateType.addTransition(MSG_BUTTON_TYPE, TYPE);
        stateType.addTransition(MSG_BUTTON_NAME, NAME);
        stateType.addTransition(MSG_BUTTON_LEVEL, LEVEL);
        stateType.addTransition(MSG_BUTTON_SUPPLY, SUPPLY);
        getFSMClass("sortTypeFSM").addState(stateType);

        FSMState stateName = new FSMState(NAME);
        stateName.addTransition(MSG_BUTTON_TYPE, TYPE);
        stateName.addTransition(MSG_BUTTON_NAME, NAME);
        stateName.addTransition(MSG_BUTTON_LEVEL, LEVEL);
        stateName.addTransition(MSG_BUTTON_SUPPLY, SUPPLY);
        getFSMClass("sortTypeFSM").addState(stateName);

        FSMState stateLevel = new FSMState(LEVEL);
        stateLevel.addTransition(MSG_BUTTON_TYPE, TYPE);
        stateLevel.addTransition(MSG_BUTTON_NAME, NAME);
        stateLevel.addTransition(MSG_BUTTON_LEVEL, LEVEL);
        stateLevel.addTransition(MSG_BUTTON_SUPPLY, SUPPLY);
        getFSMClass("sortTypeFSM").addState(stateLevel);

        FSMState stateSupply = new FSMState(SUPPLY);
        stateSupply.addTransition(MSG_BUTTON_TYPE, TYPE);
        stateSupply.addTransition(MSG_BUTTON_NAME, NAME);
        stateSupply.addTransition(MSG_BUTTON_LEVEL, LEVEL);
        stateSupply.addTransition(MSG_BUTTON_SUPPLY, SUPPLY);
        getFSMClass("sortTypeFSM").addState(stateSupply);


        addFSMClass("sortAscendFSM", new FSMClass(sortAssend));

        FSMState stateAssendUp = new FSMState(UP);
        stateAssendUp.addTransition(MSG_BUTTON_ASCEND, DOWN);
        getFSMClass("sortAscendFSM").addState(stateAssendUp);


        FSMState stateAssendDown = new FSMState(DOWN);
        stateAssendDown.addTransition(MSG_BUTTON_ASCEND, UP);
        getFSMClass("sortAscendFSM").addState(stateAssendDown);

    }*/

}
