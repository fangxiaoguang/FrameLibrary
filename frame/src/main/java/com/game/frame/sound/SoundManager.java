package com.game.frame.sound;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;

import com.game.frame.db.DatabaseManager;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.ui.activity.BaseGameActivity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.game.frame.sound.SoundManager.SOUND_LOCATION.ASSETS;

public class SoundManager {

    private static final String FILE_EXC = ".wav";
    // private static final String FILE_EXC = ".mp3";

    public boolean settingOpenSound;
    public float settingSoundVolume;

    private BaseGameActivity gameActivity;
    private Map<String, Sound> sounds = null;

    private Handler handler;

    public enum SOUND_LOCATION {
        ASSETS,
        SDCARD
    }

    private SOUND_LOCATION soundLocation;
    private String sdcartdPahtSound;

    private static SoundManager _nistance = null;

    public static SoundManager getInstance() {
        if (_nistance == null) {
            _nistance = new SoundManager();
        }
        return _nistance;
    }

    private SoundManager() {
    }

    public void setSettingOpenSound(boolean settingOpenSound) {
        this.settingOpenSound = settingOpenSound;
    }

    public void setSettingSoundVolume(float settingSoundVolume) {
        this.settingSoundVolume = settingSoundVolume;
    }


    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void init(BaseGameActivity pGameActivity, String dbFullPath, SOUND_LOCATION pSoundLocation, String pSdcartdPahtSound) {
        settingOpenSound = true;
        settingSoundVolume = 1.0f;

        gameActivity = pGameActivity;
//        handler = pHandler;
        soundLocation = pSoundLocation;
        sdcartdPahtSound = pSdcartdPahtSound;

        SQLiteDatabase dbData = DatabaseManager.getSqLiteDatabase(dbFullPath);//SQLiteDatabase.openDatabase(GameSetup.sdcartdPahtDB + "data.db", null, SQLiteDatabase.OPEN_READWRITE);

        sounds = new HashMap<>();

        Cursor cursor = dbData.query("SOUND", new String[]{"name"}, null, null, null, null, null);

        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            String name = cursor.getString(cursor.getColumnIndex("name"));

            if (pSoundLocation == ASSETS) {
                try {
                    Sound sound = SoundFactory.createSoundFromAsset(gameActivity.getEngine().getSoundManager(), gameActivity, "sound/" + name + FILE_EXC);
                    sounds.put(name, sound);
                } catch (IOException e) {
                    throw new IllegalArgumentException("createSoundFromAsset filed : " + name + FILE_EXC);
                }
            } else {
                File resFile = new File(sdcartdPahtSound + name + FILE_EXC);
                Sound sound = SoundFactory.createSoundFromFile(gameActivity.getEngine().getSoundManager(), resFile);
                sounds.put(name, sound);
            }

            cursor.moveToNext();
        }
        cursor.close();
        dbData.close();
    }

    public static void playSound(final String key) {

        Map<String, Sound> ss = SoundManager.getInstance().sounds;

        final Sound s = ss.get(key);

        if (ss.containsKey(key) == false) {
            throw new IllegalArgumentException("Illegal src;sound key : " + key);
        }


        if (SoundManager.getInstance().settingOpenSound == true) {
            SoundManager.getInstance().handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    s.stop();

                    s.setVolume(SoundManager.getInstance().settingSoundVolume);
                    s.play();
                }
            }, 0);
        }
    }

    public static void stopSound(final String key) {
        Map<String, Sound> ss = SoundManager.getInstance().sounds;

        if (ss.containsKey(key) == false) {
            throw new IllegalArgumentException("Illegal src.sound key : " + key);
        }
        final Sound s = ss.get(key);

        if (SoundManager.getInstance().settingOpenSound == true) {
            SoundManager.getInstance().handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    s.stop();
                }
            }, 0);
        }
    }
}
