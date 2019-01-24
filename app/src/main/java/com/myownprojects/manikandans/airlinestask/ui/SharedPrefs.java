package com.myownprojects.manikandans.airlinestask.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefs {

    protected Context context;

    public static SharedPreferences get(Context context) {
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(context);
        return preference;
    }

    public static void putBoolean(Context context, String booleanKey, boolean bValue) {
        SharedPreferences preference = get(context);
        preference.edit().putBoolean(booleanKey, bValue).apply();
    }

    public static boolean getBoolean(Context context, String booleanKey) {
        SharedPreferences preference = get(context);
        return preference.getBoolean(booleanKey, false);
    }

}
