package com.game.gaika.scene.sub;

import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.BaseLogicScene;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.sub.SubScene;
import com.game.frame.sprite.NormalSprite;
import com.game.gaika.data.GameSetup;


/**
 * Created by fangxg on 2015/9/19.
 */
public class BorderSubScene extends SubScene{
    public BorderSubScene(BaseLogicScene pParentScene) {
        super(SCENE_ID.BORDER_SUB);
        setParentScene(pParentScene);
    }

    @Override
    public boolean isBacegroundEnabled() {
        return false;
    }

    @Override
    public void buildScene() {
        if(GameSetup.show_border_sub==true) {
            int lx = -200;
            int ly = 0;
            float alpha = 0.5f;
            NormalSprite map1Sprite = new NormalSprite(lx, ly, "hq001");
            map1Sprite.setScale(2.0f);
            map1Sprite.setAlpha(alpha);
            addSprite(map1Sprite);
            ly += 200;

            NormalSprite map2Sprite = new NormalSprite(lx, ly, "hq002");
            map2Sprite.setScale(2.0f);
            map2Sprite.setAlpha(alpha);
            addSprite(map2Sprite);
            ly += 200;

            NormalSprite map3Sprite = new NormalSprite(lx, ly, "hq003");
            map3Sprite.setScale(2.0f);
            map3Sprite.setAlpha(alpha);
            addSprite(map3Sprite);
            ly += 200;

            int rx = 800;
            int ry = 0;

            NormalSprite map4Sprite = new NormalSprite(rx, ry, "hq004");
            map4Sprite.setScale(2.0f);
            map4Sprite.setAlpha(alpha);
            addSprite(map4Sprite);
            ry += 200;

            NormalSprite map5Sprite = new NormalSprite(rx, ry, "hq005");
            map5Sprite.setScale(2.0f);
            map5Sprite.setAlpha(alpha);
            addSprite(map5Sprite);
            ry += 200;

            NormalSprite map6Sprite = new NormalSprite(rx, ry, "hq006");
            map6Sprite.setScale(2.0f);
            map6Sprite.setAlpha(alpha);
            addSprite(map6Sprite);
            ry += 200;
        }
    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {

    }
}
