package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * This app is copyrighted by FrobPlugins
 */

public class MoneyManager {
    private static Preferences prefs;
    private static int encryptedVal;
    private static int decryptedVal;

    public MoneyManager(){
        prefs = Gdx.app.getPreferences("ClickTheSquare");

        if(!prefs.contains("encryptedMoney")){
            prefs.putInteger("encryptedMoney", 0);
        }
    }

    private static void encrypt(int decryptedMoney){
        encryptedVal = (decryptedMoney*500)+325;
        saveMoney(encryptedVal);
    }

    private static void decrypt(){
        decryptedVal = (prefs.getInteger("encryptedMoney")-325)/500;
    }

    private static void saveMoney(int encryptedMoney){
        prefs.putInteger("encryptedMoney", encryptedMoney);
        prefs.flush();
    }

    public void encryptAndSaveMoney(int decryptedMoney){
        encrypt(decryptedMoney);
    }

    public int getDecryptedMoney(){
        decrypt();
        return decryptedVal;
    }
}
