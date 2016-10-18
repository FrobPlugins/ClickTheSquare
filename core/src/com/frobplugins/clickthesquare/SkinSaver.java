package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * This app is copyrighted by FrobPlugins
 */

public class SkinSaver {
    private static Preferences prefs;

    public SkinSaver(){
        prefs = Gdx.app.getPreferences("ClickTheSquare");

        if (!prefs.contains("skin")) {
            prefs.putInteger("skin", 7);
            prefs.flush();
        }
    }

    public static void setDefaultSkin(){
        prefs.putInteger("skin", 7);
        prefs.flush();
    }

    public static void setSkin(int val){
        prefs.putInteger("skin", val);
        prefs.flush();
    }

    public static int getSkin() {
        return prefs.getInteger("skin");
    }
}
