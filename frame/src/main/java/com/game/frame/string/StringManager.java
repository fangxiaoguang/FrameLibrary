package com.game.frame.string;

/**
 * Created by fangxg on 2015/6/17.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.game.frame.db.DatabaseManager;

import java.util.HashMap;
import java.util.Map;

public class StringManager {

    public Map<String, String> strings;

    private static StringManager _nistance;

    public static StringManager getInstance() {
        if (_nistance == null) {
            _nistance = new StringManager();
        }
        return _nistance;
    }

    private StringManager() {
    }

    public void init( String dbFullPath) {

        SQLiteDatabase dbData = DatabaseManager.getSqLiteDatabase(dbFullPath);//SQLiteDatabase.openDatabase(GameSetup.sdcartdPahtDB + "data.db", null, SQLiteDatabase.OPEN_READWRITE);
        strings = new HashMap<>();

        Cursor cursor = dbData.query("STRING", new String[] { "id", "value" }, null, null, null, null, null);

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            String id = cursor.getString(cursor.getColumnIndex("id"));
            String value = cursor.getString(cursor.getColumnIndex("value"));
            strings.put(id, value);

            cursor.moveToNext();
        }
        cursor.close();
        dbData.close();
    }

    public String getString(String id) {

        String retStr = strings.get(id);
        if (retStr == null) {
            retStr = "ERROR";
        }
        return retStr;
    }
}
