package com.game.gaika.action;


import java.util.Random;

/**
 * Created by fangxg on 2015/8/16.
 */
public class AiCapliuringTimeOutAction  implements BaseAction {
    private int aiWeaponID ;
    public AiCapliuringTimeOutAction(int pAiWeaponID) {
        aiWeaponID = pAiWeaponID;
    }
    @Override
    public void doAction() {

        BaseAction act = new GetSomeThingTimeOutAction(aiWeaponID);
        act.doAction();

       /* GameDataManager gdm = GameDataManager.getInstance();
        ID.WIN_TYPE win = gdm.checkWinOrLose();

        if (win == ID.WIN_TYPE.NON) {
            BattlefieldScene battlefieldScene = new BattlefieldScene(false);
            battlefieldScene.addSprite(new DelaySprite(GameSetup.DELAY_SHORT_S, new TouchMessage(ID.MSG_ID.MSG_SCENE_BATTLEFIELD__CHECK_WIN_TIME_OUT, null, battlefieldScene, aiWeaponID)));
            SceneManager.render(battlefieldScene);
        }
        if (win == ID.WIN_TYPE.WIN) {

            //本关卡得分
            Random random1 = new Random(20);
            int score = 80 + random1.nextInt() % 20;

            ChapterCompleteScene chapterCompleteScene = new ChapterCompleteScene(score);
            SceneManager.render(chapterCompleteScene);
        }
        if (win == ID.WIN_TYPE.LOSE) {

            ChapterLoseScene chapterLoseScene = new ChapterLoseScene();
            SceneManager.render(chapterLoseScene);
        }*/
    }
}
