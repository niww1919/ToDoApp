
/**
 * .apply() async operation
 * .commit() sync operation
 * We new create cash class to save data
 * */
package com.example.todoapp;

import android.app.Activity;
import android.content.Context;

import java.util.Set;

public class PreferenceWrapper {

    public static final String PREFERENCE_KEY = "Preference";
    private static  PreferenceWrapper _instance;
    String textString;
    Set<String> textStringSet;


    static PreferenceWrapper getInstance(Activity activity) {
        _instance = _instance ==null ?new PreferenceWrapper(activity) : _instance;
        return _instance;
    }


    public PreferenceWrapper(Activity activity) {
        textString = activity.getSharedPreferences("Preference", Context.MODE_PRIVATE).getString("Text","");
    }

    public String getTextString() {
        return textString;
    }

    public void setTextString(Activity activity, String t) {
        this.textString = t;
        activity.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).edit().putString("Text",t).apply();
    }

    public void setTextStringSet(Activity activity, Set<String> tSet) {
        this.textStringSet = tSet;
        activity.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).edit().putStringSet("SetText",tSet).apply();
    }
}
