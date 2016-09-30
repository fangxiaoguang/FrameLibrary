package com.game.frame.sprite;


import com.game.frame.flyweight.DelayFlyweight;
import com.game.frame.fsm.TouchMessage;

/**
 * Created by fangxg on 2015/6/16.
 */
public class DelaySprite extends BaseSprite {

    public DelaySprite(float pDelayTimeS, TouchMessage pTimeOutMessage) {

//        if(GameSetup.isDebug_delay_to_touch){
//
//            NormalFlyweight bkFlyweight = new NormalFlyweight(0, 0, "greenBox", 2);
//            TextFlyweight timeFlyweight = new TextFlyweight(0.0f, 48.0f,true , "delayS = " + pDelayTimeS, TexRegionManager.getInstance().getFont12() );
//            bkFlyweight.addChildFlyweight(timeFlyweight);
//            TextFlyweight msgFlyweight = new TextFlyweight(0.0f, 48.0f + 12.0f,true , "MSG_ID = " + pTimeOutMessage.getMessageID(), TexRegionManager.getInstance().getFont12());
//            bkFlyweight.addChildFlyweight(msgFlyweight);
//
//            setFlyweight(bkFlyweight);
//            setTouchMessage(pTimeOutMessage);
//            setZ(100);
//        }else {
            setFlyweight(new DelayFlyweight(pDelayTimeS));
            setTouchMessage(pTimeOutMessage);
//        }
    }
}
