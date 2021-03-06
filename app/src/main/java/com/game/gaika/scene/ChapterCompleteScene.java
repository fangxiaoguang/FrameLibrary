package com.game.gaika.scene;

import com.game.frame.fsm.MSG_ID;
import com.game.frame.fsm.TouchMessage;
import com.game.frame.scene.SCENE_ID;
import com.game.frame.scene.SceneManager;
import com.game.frame.scene.SimpleScene;
import com.game.frame.sprite.NormalSprite;
import com.game.frame.sprite.NumberSprite;
import com.game.frame.sprite.TextSprite;
import com.game.frame.string.StringManager;
import com.game.gaika.data.GameDataManager;
import com.game.gaika.data.GameSetup;
import com.game.gaika.data.ID;
import com.game.gaika.data.WeaponSelectFilter;
import com.game.gaika.data.weapon.BaseWeapon;

import java.util.List;

import static com.game.frame.sound.SoundManager.playSound;
import static com.game.frame.sound.SoundManager.stopSound;
import static com.game.frame.texture.TexRegionManager.getFont16;


/**
 * Created by fangxg on 2015/7/27.
 */
public class ChapterCompleteScene extends SimpleScene {
    private int score;
    public ChapterCompleteScene( int pScore) {
        super(SCENE_ID.CHAPTER_COMPLETE, 800.0f, 600.0f, GameSetup.deviceWidthPixels, GameSetup.deviceHeightPixels);
        score = pScore;
        GameDataManager gdm = GameDataManager.getInstance();

        NormalSprite bkSprite = new NormalSprite(0, 0, "resu_bg1");
        addSprite(bkSprite);

        //  int ct = gdm.gameTimer.currentTurn;

        // 于第2天15时00分，
        // 完成对精钢的压制。
        TextSprite textSprite1 = new TextSprite(247, 136 + 2, true,
                String.format(StringManager.getInstance().getString("S06001"), gdm.gameTimer.getDayFromTurn(), gdm.gameTimer.getHourFromTurn()),
                getFont16());
        addSprite(textSprite1);

        TextSprite textSprite2 = new TextSprite(247, 136 + 20 + 4, true,
                String.format(StringManager.getInstance().getString("S06002"), gdm.getCurrentChapter().cName),
                getFont16());
        addSprite(textSprite2);


        int redDestroyCount = 0;
        int blueDestroyCount = 0;
        for (BaseWeapon weapon : gdm.weapons.values()) {
            if (weapon.life <= 0) {
                if (gdm.getCurrentChapter().side2.contains(weapon.teamColor)) {
                    redDestroyCount++;
                } else if (gdm.getCurrentChapter().side1.contains(weapon.teamColor)) {
                    blueDestroyCount++;
                }
            }

        }


        int x = 499;
        NumberSprite number1 = new NumberSprite(x, 238, false, "font04", redDestroyCount);
        addSprite(number1);
        NumberSprite number2 = new NumberSprite(x, 278, false, "font04", blueDestroyCount);
        addSprite(number2);

        int addMoney = gdm.getCurrentChapter().getAddMoney();
        NumberSprite number3 = new NumberSprite(x, 318, false, "font04", addMoney);
        addSprite(number3);


        // DEBUG

        NumberSprite number4 = new NumberSprite(x, 374, false, "font04", pScore);
        addSprite(number4);


        NumberSprite number5 = new NumberSprite(x, 414, false, "font04", gdm.scoreCount + pScore);
        addSprite(number5);

        // DEBUG
        // resu_bt2
        int gamePlayerLv = (gdm.scoreCount + pScore) / 300; // 少尉

        if (gamePlayerLv > 9) {
            gamePlayerLv = 9;
        }

        NormalSprite lvNameSprite = new NormalSprite(265, 473, "resu_bt2", gamePlayerLv);
        addSprite(lvNameSprite);

        NormalSprite lvFlagSprite =new NormalSprite(413, 452, "badge01", gamePlayerLv);
        addSprite(lvFlagSprite);


        NormalSprite buttonSprite =new NormalSprite(553, 499, "resu_bt1", 1, new TouchMessage(MSG_ID.MSG_SCENE_CHAPTER_COMPLETE__BACK, null, this));
        addSprite(buttonSprite);

         playSound("gameover");
    }

    @Override
    public boolean isBacegroundEnabled() {
        return true;
    }

    @Override
    public void buildScene() {

    }

    @Override
    public void onHandlMessage(TouchMessage pTouchMessage) {
        GameDataManager gdm = GameDataManager.getInstance();
        MSG_ID msgID = pTouchMessage.getMessageID();

        if(msgID == MSG_ID.MSG_SCENE_CHAPTER_COMPLETE__BACK){
             stopSound("gameover");
             playSound("back01");

            WeaponSelectFilter filter = new WeaponSelectFilter();
            filter.addTeamColor(ID.TEAM_COLOR.BLUE);
            List<BaseWeapon> weapons = filter.getWeapons();
            for(BaseWeapon weapon :weapons){
                if(weapon.life > 0) {
                    weapon.doRepair(10);
                }
                weapon.doSupply();
            }

            gdm.scoreCount += score;
            gdm.getCurrentChapter().finished = true;
            gdm.money += gdm.getCurrentChapter().addMoney;
            SelectTargetScene selectTargetScene = new SelectTargetScene(true);
            SceneManager.render(selectTargetScene);
        }
    }
}
