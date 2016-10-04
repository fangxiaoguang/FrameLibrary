package com.game.gaika.scene.dialg;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.dialg.DialogScene;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.TextSprite;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.ID;
import com.game.gaika.data.weapon.BaseWeapon;

import static com.game.frame.texture.TexRegionManager.getFont16;
import static com.game.frame.texture.TexRegionManager.getFont16Grey;

/**
 * Created by fangxg on 2015/7/25.
 */
public class ChoosePassengerDialogScene extends DialogScene {
    public ChoosePassengerDialogScene(BaseWeapon pTransporter, BaseLogicScene pParentScene) {
        super(SCENE_ID.CHOOSE_ARMS_MENU, pTransporter.getPixelX(), pTransporter.getPixelY(), 0.0f, 0.0f, pParentScene, EPointModel.POINT_MODEL_OFFSET);

        GameDataManager gdm = GameDataManager.getInstance();

        float x = 50.0f;
        float y = 50.0f;

        if (pTransporter.moveEnding == false) {
            NormalSprite buttonTransporterSprite = new NormalSprite(x, y, "cary_wn1", 0, new TouchMessage(MSG_ID.MSG_SCENE_BATTLEFIELD__SELECT_WEAPON, null, pParentScene, pTransporter.id));
            addSprite(buttonTransporterSprite);
            TextSprite textTransporterSprite = new TextSprite(x + 11, y + 7, true, pTransporter.info.name, getFont16());
            addSprite(textTransporterSprite);
        } else {
            NormalSprite buttonTransporterSprite = new NormalSprite(x, y, "cary_wn1", 0);
            addSprite(buttonTransporterSprite);
            TextSprite textTransporterSprite = new TextSprite(x + 11, y + 7, true, pTransporter.info.name, getFont16Grey());
            addSprite(textTransporterSprite);
        }

        y += 30;
        for (BaseWeapon passenger : pTransporter.getPassengers()) {

            if (passenger.moveEnding == false) {
                NormalSprite buttonPassengerSprite = new NormalSprite(x, y, "cary_wn2", 0, new TouchMessage(MSG_ID.MSG_SCENE_BATTLEFIELD__SELECT_PASSENGER, null, pParentScene, passenger.id));
                addSprite(buttonPassengerSprite);

                TextSprite textPassengerSprite = new TextSprite(x + 11, y, true, passenger.info.name + " " + passenger.getLifeEx() + passenger.info.getUnitString(), getFont16());
                addSprite(textPassengerSprite);
            } else {
                NormalSprite buttonPassengerSprite = new NormalSprite(x, y, "cary_wn2", 0);
                addSprite(buttonPassengerSprite);

                TextSprite textPassengerSprite = new TextSprite(x + 11, y, true, passenger.info.name + " " + passenger.getLifeEx() + passenger.info.getUnitString(), getFont16Grey());
                addSprite(textPassengerSprite);
            }
            y += 18;
        }

        NormalSprite endingLineSprite = new NormalSprite(x, y, "cary_wn3", 0);
        addSprite(endingLineSprite);

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
