package com.game.gaika.scene.dialg;

import com.game.frame.fsm.IMessageHandler;
import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.dialg.DialogScene;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.TextSprite;
import com.game.frame.texture.TexRegionManager;

import static com.game.frame.texture.TexRegionManager.getFont16;

/**
 * Created by fangxg on 2015/6/30.
 */
public class Dialg6YesNoDialogScene extends DialogScene {

    public Dialg6YesNoDialogScene(String pText, MSG_ID pYesEMsgID, MSG_ID pNoEMsgID, IMessageHandler pHandler, BaseLogicScene pParentScene) {
        this(pText, new TouchMessage(pYesEMsgID, null, pHandler), new TouchMessage(pNoEMsgID, null, pHandler),pParentScene);

    }
    public Dialg6YesNoDialogScene(String pText, TouchMessage pYesMsg, TouchMessage pNoMsg, BaseLogicScene pParentScene) {
        super( SCENE_ID.YES_NO_DIALOG, 0.0f, 0.0f, 406, 173,  pParentScene, EPointModel.POINT_MODEL_CENTER);



        NormalSprite bkSprite = new NormalSprite(0.0f, 0.0f, "dialg6");
        addSprite(bkSprite);

        TextSprite textSprite = new TextSprite(40, 45, true, pText, getFont16());
        addSprite(textSprite);

        NormalSprite yesSprite = new NormalSprite(43, 127, "dialg6bt", 2, pYesMsg);
        addSprite(yesSprite);

        NormalSprite noSprite = new NormalSprite(287, 127, "dialg6bt", 3, pNoMsg);
        addSprite(noSprite);
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

    }
}
