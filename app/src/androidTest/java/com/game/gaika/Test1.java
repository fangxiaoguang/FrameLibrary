package com.game.gaika;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import com.game.frame.scene.SCENE_ID;
import com.game.frame.util.GLog;
import com.game.test.GameDriver;
import com.game.test.GameElement;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by devuser1 on 2016/9/29.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class Test1 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);



    @Test
    public void sayHello() throws Exception {

        long l1 = System.currentTimeMillis();
        GameDriver d = new GameDriver<MainActivity>(mActivityRule.getActivity());

        d.waitScenc(SCENE_ID.LOGO_3);
        long l2 = System.currentTimeMillis();


        GameElement e = d.findElementById("id001");
        e.click();
        d.waitScenc(SCENE_ID.BEGIN_MENU);

        GLog.d("THIS IS SCENE -- BEGIN_MENU");
        GameElement bt1 = d.findElementById("bt001");
        bt1.click();
        d.waitScenc(SCENE_ID.DIFF_MENU);

        GLog.d("THIS IS SCENE -- DIFF_MENU");
         bt1 = d.findElementById("bt001");
        bt1.click();
        d.waitScenc(SCENE_ID.BEGIN_LOCAL);

        GLog.d("THIS IS SCENE -- BEGIN_LOCAL");
        bt1 = d.findElementById("bl001");
        bt1.click();
        d.waitScenc(SCENE_ID.BEGIN_LOCAL);
        bt1 = d.findElementById("bl001");
        bt1.click();
        d.waitScenc(SCENE_ID.BEGIN_COUNTY);



        GLog.d("THIS IS SCENE -- BEGIN_COUNTY");
        bt1 = d.findElementById("bc001");
        bt1.click();
        d.waitScenc(SCENE_ID.BEGIN_COUNTY);
        bt1.click();
        d.waitScenc(SCENE_ID.BATTLEFIELD_ENTER_INFO);

        GLog.d("THIS IS SCENE -- BATTLEFIELD_ENTER_INFO");
        bt1 = d.findElementById("bt_002");
        bt1.click();
        d.waitScenc(SCENE_ID.BEGIN_COUNTY);

        GLog.d("THIS IS SCENE -- BEGIN_COUNTY");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        String s = mActivityRule.toString();
        int l = s.length();
        Log.d("TAG1", s);
    }
}