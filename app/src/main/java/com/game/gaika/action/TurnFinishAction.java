package com.game.gaika.action;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SceneManager;
import com.game.gaika.scene.BattlefieldScene;
import com.game.gaika.scene.dialg.Dialg6YesNoDialogScene;

/**
 * Created by fangxg on 2015/7/24.
 */
public class TurnFinishAction implements BaseAction {
    @Override
    public void doAction() {
        BattlefieldScene battlefieldScene = new BattlefieldScene(false);

        Dialg6YesNoDialogScene yesNoDialog = new Dialg6YesNoDialogScene("结束本回合。",
                new TouchMessage(MSG_ID.MSG_SCENE_HUD__TURN_FINISH_DILOG_YES, null, battlefieldScene),
                new TouchMessage(MSG_ID.MSG_SCENE_HUD__TURN_FINISH_DILOG_NO, null, battlefieldScene),battlefieldScene );

        battlefieldScene.setDialogSecne(yesNoDialog);
        SceneManager.render(battlefieldScene);

    }
}
