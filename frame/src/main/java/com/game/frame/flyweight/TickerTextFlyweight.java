package com.game.frame.flyweight;


import com.game.frame.fsm.TouchMessage;

import org.andengine.entity.shape.RectangularShape;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TickerText;
import org.andengine.opengl.font.Font;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.HorizontalAlign;

/**
 * Created by fangxg on 2015/6/20.
 */
public class TickerTextFlyweight  extends BaseFlyweight {

    public String text = "";
    public Font font;
    private BaseGameActivity gameActivity;

    public TickerTextFlyweight(String pText, Font pFont,  BaseGameActivity pGameActivity) {
        this(0.0f, 0.0f,  pText, pFont, pGameActivity);
    }

    public TickerTextFlyweight(float pOffsetX, float pOffsetY, String pText, Font pFont,  BaseGameActivity pGameActivity) {
        super(pOffsetX, pOffsetY);
        this.text = pText;
        font = pFont;
        gameActivity = pGameActivity;
    }

    @Override
    public RectangularShape getShapeSelf(TouchMessage pTouchMessage) {

        Text msg = new TickerText(offsetX,offsetY, font, text, new TickerText.TickerTextOptions(HorizontalAlign.LEFT, 15),
                gameActivity.getVertexBufferObjectManager());
        return msg;
    }
}