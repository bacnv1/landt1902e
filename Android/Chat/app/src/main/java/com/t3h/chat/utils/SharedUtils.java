package com.t3h.chat.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtils {
    private SharedPreferences preferences;

    public SharedUtils(Context context) {
        this.preferences = context.getSharedPreferences(
                "SharedUtils",
                Context.MODE_PRIVATE
        );
    }

    public void put(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

    public String get(String key) {
        return preferences.getString(key, "");
    }
}
