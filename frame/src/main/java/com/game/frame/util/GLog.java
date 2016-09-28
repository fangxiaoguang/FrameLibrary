package com.game.frame.util;

import android.util.Log;

/**
 * Created by devuser1 on 2016/9/28.
 */

public class GLog {
    private static String TAG;

    public static void setTAG(String TAG) {
        GLog.TAG = TAG;
    }

    public static int v( String msg) {
        return Log.v(TAG, msg);
    }
    public static int d( String msg) {
        return Log.d(TAG, msg);
    }
    public static int i( String msg) {
        return Log.i(TAG, msg);
    }
    public static int w( String msg) {
        return Log.w(TAG, msg);
    }
    public static int e( String msg) {
        return Log.e(TAG, msg);
    }
}
