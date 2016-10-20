package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * This app is copyrighted by FrobPlugins
 */

public class SkinStoreManager {
    private static Preferences prefs;

    public SkinStoreManager(){
        prefs = Gdx.app.getPreferences("ClickTheSquare");

        if(!prefs.contains("greenUnlocked")){
            prefs.putInteger("greenUnlocked", 0);
        }

        if(!prefs.contains("lightgreenUnlocked")){
            prefs.putInteger("lightgreenUnlocked", 0);
        }

        if(!prefs.contains("purpleUnlocked")){
            prefs.putInteger("purpleUnlocked", 0);
        }

        if(!prefs.contains("goldUnlocked")){
            prefs.putInteger("goldUnlocked", 0);
        }

        if(!prefs.contains("woodUnlocked")){
            prefs.putInteger("woodUnlocked", 0);
        }

        if(!prefs.contains("natureUnlocked")){
            prefs.putInteger("natureUnlocked", 0);
        }

        if(!prefs.contains("metalUnlocked")){
            prefs.putInteger("metalUnlocked", 0);
        }
    }

    public static void unlockGreen(){
        prefs.putInteger("greenUnlocked", 1);
    }

    public static void unlockLightGreen(){
        prefs.putInteger("lightgreenUnlocked", 1);
    }

    public static void unlockPurple(){
        prefs.putInteger("purpleUnlocked", 1);
    }

    public static void unlockGold(){
        prefs.putInteger("goldUnlocked", 1);
    }

    public static void unlockWood(){
        prefs.putInteger("woodUnlocked", 1);
    }

    public static void unlockNature(){
        prefs.putInteger("natureUnlocked", 1);
    }

    public static void unlockMetal(){
        prefs.putInteger("metalUnlocked", 1);
    }


    public int checkIfGreenUnlocked(){
        return prefs.getInteger("greenUnlocked");
    }

    public int checkIfLightGreenUnlocked(){
        return prefs.getInteger("lightgreenUnlocked");
    }

    public int checkIfPurpleUnlocked(){
        return prefs.getInteger("purpleUnlocked");
    }

    public int checkIfGoldUnlocked(){
        return prefs.getInteger("goldUnlocked");
    }

    public int checkIfWoodUnlocked(){
        return prefs.getInteger("woodUnlocked");
    }

    public int checkIfNatureUnlocked(){
        return prefs.getInteger("natureUnlocked");
    }

    public int checkIfMetalUnlocked(){
        return prefs.getInteger("metalUnlocked");
    }
}
