package com.game.frame.sprite;


import com.game.frame.flyweight.TickerTextFlyweight;

import org.andengine.opengl.font.Font;
import org.andengine.ui.activity.BaseGameActivity;

/**
 * Created by fangxg on 2015/6/20.
 */
public class TickerTextSprite extends BaseSprite {
    public TickerTextSprite(float pX, float pY, String pText, Font pFont) {
        super(pX, pY);

        TickerTextFlyweight textFlyweight = new TickerTextFlyweight(pText, pFont);
        setFlyweight(textFlyweight);
    }
}
