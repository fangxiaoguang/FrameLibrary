package com.game.gaika.scene;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.scene.value.SceneValueMap;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.NumberSprite;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.GameSetup;
import com.game.gaika.data.SaveManager;
import com.game.gaika.scene.sub.BorderSubScene;
import com.game.gaika.sprite.GameSaveSprite;

import java.util.Map;


import static com.game.frame.scene.value.SceneValueMap.getSceneValuesMap;
import static com.game.frame.sound.SoundManager.playSound;
import static com.game.gaika.data.ID.SCENE_INIT_TYPE.NOT_INIT;

/**
 * Created by fangxg on 2015/7/3.
 */
public class LoadGameScene  extends SimpleScene {

    private Map<Integer, SaveManager.ShowSaveNode> saves;

    public LoadGameScene(boolean pInit, SCENE_ID pPreSceneID) {
        super(SCENE_ID.LOAD_GAME,  800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);
        preSceneID = pPreSceneID;

        if (pInit == true) {
            SceneValueMap sceneValues = getSceneValuesMap();
            sceneValues.cleanAllValues();
            sceneValues.setInt("pageNumber", GameSetup.settingSaveDatePage);
        }

    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {
        GameDataManager gdm = GameDataManager.getInstance();

        NormalSprite backSprite = new NormalSprite(0.0f, 0.0f, "data_bg1");
        addSprite(backSprite);

        SceneValueMap sceneValues = getSceneValuesMap();
        int page = sceneValues.getInt("pageNumber");

        if (page > 1) {
            NormalSprite buttonUpSprite = new NormalSprite(298, 54, "scroolb2", 0, new TouchMessage(MSG_ID.MSG_SCENE_LOAD_GAME__PAGE_UP, null, this));
            addSprite(buttonUpSprite);
        }

        saves = SaveManager.getSaves(page);
        //----------------------------------------------------------------------
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {

                int saveNo = (page - 1) * 20 + i * 5 + j + 1;
                SaveManager.ShowSaveNode save = saves.get(saveNo);
                GameSaveSprite dataSprite = new GameSaveSprite(40 + j * 143, 100 + i * 107, save, new TouchMessage(MSG_ID.MSG_SCENE_LOAD_GAME__SELECT_SAVE_DATA, null, this, saveNo));
                addSprite(dataSprite);
            }
        }
        //----------------------------------------------------------------------

        if (page < 99) {

            NormalSprite buttonDownSprite = new NormalSprite(298, 554, "scroolb2", 1, new TouchMessage(MSG_ID.MSG_SCENE_LOAD_GAME__PAGE_DOWN, null, this));
            addSprite(buttonDownSprite);
        }
        NormalSprite buttonRetSprite = new NormalSprite(35, 556, "retn_bt1", 0, new TouchMessage(MSG_ID.MSG_SCENE_LOAD_GAME__RETURN, null, this, 0));
        addSprite(buttonRetSprite);

        NumberSprite numberSprite1 = new NumberSprite(652 - 20, 544, true, "font04", page, 2, 0, 1.0f);
        addSprite(numberSprite1);

        NumberSprite numberSprite2 = new NumberSprite(710 - 20, 544, true, "font04", 99, 2, 0, 1.0f);
        addSprite(numberSprite2);

        addChildScene(new BorderSubScene(this));
    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        GameDataManager gdm = GameDataManager.getInstance();
        Enum msgID = pTouchMessage.getMessageID();
        SceneValueMap sceneValues = getSceneValuesMap();
        if (msgID == MSG_ID.MSG_SCENE_LOAD_GAME__PAGE_UP) {
            playSound("scrl01");

            int page = sceneValues.getInt("pageNumber");
            sceneValues.setInt("pageNumber", page - 1);
            GameSetup.settingSaveDatePage = page - 1;
            SaveManager.saveConfig();
            LoadGameScene scene = new LoadGameScene(false, preSceneID);
            SceneManager.render(scene);
        }
        if (msgID == MSG_ID.MSG_SCENE_LOAD_GAME__PAGE_DOWN) {
            playSound("scrl01");

            int page = sceneValues.getInt("pageNumber");
            sceneValues.setInt("pageNumber", page + 1);
            GameSetup.settingSaveDatePage = page + 1;
            SaveManager.saveConfig();
            LoadGameScene scene = new LoadGameScene(false, preSceneID);
            SceneManager.render(scene);
        }
        if (msgID == MSG_ID.MSG_SCENE_LOAD_GAME__SELECT_SAVE_DATA) {
            int saveNo = pTouchMessage.getParam();
            SaveManager.ShowSaveNode save = saves.get(saveNo);
            if (save.saveNo != 0) {
                playSound("select01");
                SaveManager.load(saveNo);

                BaseLogicScene scene = SceneFactory.createScene(save.preSceneId);
                SceneManager.render(scene);
            }
        }

        if (msgID == MSG_ID.MSG_SCENE_LOAD_GAME__RETURN) {
            playSound("back01");
            BaseLogicScene scene = SceneFactory.createScene(preSceneID, NOT_INIT);
            SceneManager.render(scene);
        }
    }
}
