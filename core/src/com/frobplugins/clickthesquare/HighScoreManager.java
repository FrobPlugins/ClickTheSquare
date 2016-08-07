package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class HighScoreManager {

    private static Preferences prefs;

    public HighScoreManager(){
        prefs = Gdx.app.getPreferences("ClickTheSquare");

        if (!prefs.contains("highScore_easy")) {
            prefs.putInteger("highScore_easy", 0);
        }
        if (!prefs.contains("highScore_easy")) {
            prefs.putInteger("highScore_easy", 0);
        }
        if (!prefs.contains("highScore_easy")) {
            prefs.putInteger("highScore_easy", 0);
        }
        if (!prefs.contains("highScore_easy")) {
            prefs.putInteger("highScore_easy", 0);
        }
        if(!prefs.contains("Difficulty")){
            prefs.putInteger("Difficulty", 0);
        }
    }

    public static void setDifficulty(int val){
        prefs.putInteger("Difficulty", val);
        prefs.flush();
    }

    public static void setHighScore(int val) {
        if(getDifficulty() == 0) {
            prefs.putInteger("highScore_easy", val);
            prefs.flush();
        }
        if(getDifficulty() == 1) {
            prefs.putInteger("highScore_normal", val);
            prefs.flush();
        }
        if(getDifficulty() == 2) {
            prefs.putInteger("highScore_hard", val);
            prefs.flush();
        }
        if(getDifficulty() == 3) {
            prefs.putInteger("highScore_expert", val);
            prefs.flush();
        }
    }

    public static int getHighScoreEasy() {
        return prefs.getInteger("highScore_easy");
    }
    public static int getHighScoreNormal() {
        return prefs.getInteger("highScore_normal");
    }
    public static int getHighScoreHard() {
        return prefs.getInteger("highScore_hard");
    }
    public static int getHighScoreExpert() {
        return prefs.getInteger("highScore_expert");
    }
    public static int getDifficulty() { return prefs.getInteger("Difficulty"); }
}
