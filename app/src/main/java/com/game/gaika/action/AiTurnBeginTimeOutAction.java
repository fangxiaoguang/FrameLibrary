package com.game.gaika.action;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SceneManager;
import com.game.frame.sprite.DelaySprite;
import com.game.gaika.data.GameSetup;
import com.game.gaika.scene.BattlefieldScene;

/**
 * Created by fangxg on 2015/7/29.
 */
public class AiTurnBeginTimeOutAction implements BaseAction {
    @Override
    public void doAction() {



        BattlefieldScene battlefieldScene = new BattlefieldScene(false);
        battlefieldScene.addSprite(new DelaySprite(GameSetup.DELAY_SHORT_S, new TouchMessage(MSG_ID.MSG_SCENE_BATTLEFIELD__AI_REPAIR_NEXT, null, battlefieldScene)));
        SceneManager.render(battlefieldScene);
    }
}
