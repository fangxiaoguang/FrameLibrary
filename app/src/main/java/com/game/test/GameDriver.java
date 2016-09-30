package com.game.test;


import com.game.frame.scene.SCENE_ID;

/**
 * Created by devuser1 on 2016/9/22.
 */

public class GameDriver <T extends Testable>
{
    private T mActivity;
    private long timeOutMS = 1000;

    public GameDriver(T pActivityClass) {
        mActivity = pActivityClass;
    }

    public GameElement findElementById(String pId){

        return mActivity.getElement(pId);

    }

    public void waitScenc(SCENE_ID pSceneId) throws Exception {
        try {
            Thread.sleep(timeOutMS);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        int i = 0;
        while(true){
            i ++ ;
            if(i > 30){
                throw  new Exception();
            }
            SCENE_ID id = null;

            try{
                id = mActivity.getCurrentSceneId();
            }catch (NullPointerException e) {
                try {
                    Thread.sleep(timeOutMS);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                continue;
            }

            if(mActivity.getCurrentSceneId() == pSceneId){
                break;
            }else{
                try {
                    Thread.sleep(timeOutMS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Thread.sleep(timeOutMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
