package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class CurrentScoreManager {

    private static Preferences prefs;

    public CurrentScoreManager(){
        prefs = Gdx.app.getPreferences("ClickTheSquare");

        if (!prefs.contains("currentScore")) {
            prefs.putInteger("currentScore", 0);
        }
    }

    public static void setCurrentScore(int val) {
        prefs.putInteger("currentScore", val);
        prefs.flush();
    }

    public static int getCurrentScore() {
        return prefs.getInteger("currentScore");
    }
}
