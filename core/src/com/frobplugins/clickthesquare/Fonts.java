package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Gebruiker on 26-2-2016.
 */
public class Fonts {

    static FreeTypeFontGenerator gen1;
    static FreeTypeFontGenerator.FreeTypeFontParameter par1;

    static FreeTypeFontGenerator gen2;
    static FreeTypeFontGenerator.FreeTypeFontParameter par2;

    static FreeTypeFontGenerator gen3;
    static FreeTypeFontGenerator.FreeTypeFontParameter par3;

    static FreeTypeFontGenerator gen4;
    static FreeTypeFontGenerator.FreeTypeFontParameter par4;

    static FreeTypeFontGenerator gen5;
    static FreeTypeFontGenerator.FreeTypeFontParameter par5;

    static BitmapFont font1;

    static BitmapFont font2;

    static BitmapFont font3;

    static BitmapFont font4;

    static BitmapFont font5;

    public static void loadFonts(){
        gen1 = new FreeTypeFontGenerator(Gdx.files.internal("assets/6809 chargen.ttf"));
        par1 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par1.borderWidth = Gdx.graphics.getWidth() * 2 / 600;
        par1.size = (Gdx.graphics.getWidth() * 24) / 600;
        par1.flip = true;
        par1.color = Color.CORAL;
        par1.borderColor = Color.CLEAR;
        font1 = gen1.generateFont(par1);

        gen2 = new FreeTypeFontGenerator(Gdx.files.internal("assets/6809 chargen.ttf"));
        par2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par2.borderWidth = Gdx.graphics.getWidth() * 5 / 600;
        par2.size = (Gdx.graphics.getWidth() * 60) / 600;
        par2.flip = true;
        par2.color = Color.RED;
        par2.borderColor = Color.BROWN;
        font2 = gen2.generateFont(par2);

        gen3 = new FreeTypeFontGenerator(Gdx.files.internal("assets/6809 chargen.ttf"));
        par3 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par3.size = Gdx.graphics.getWidth() * 50 / 600;
        par3.borderWidth = (Gdx.graphics.getWidth() * 4) / 600;
        par3.borderColor = Color.BLACK;
        par3.color = Color.CORAL;
        par3.flip = true;
        font3 = gen3.generateFont(par3);

        gen4 = new FreeTypeFontGenerator(Gdx.files.internal("assets/6809 chargen.ttf"));
        par4 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par4.borderWidth = (Gdx.graphics.getWidth() * 5) / 600;
        par4.size = (Gdx.graphics.getWidth() * 60) / 600;
        par4.flip = true;
        par4.color = Color.RED;
        par4.borderColor = Color.BROWN;
        font4 = gen4.generateFont(par4);

        gen5 = new FreeTypeFontGenerator(Gdx.files.internal("assets/6809 chargen.ttf"));
        par5 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        par5.borderWidth = Gdx.graphics.getWidth() * 2 / 600;
        par5.size = Gdx.graphics.getWidth() * 48 / 600;
        par5.flip = true;
        par5.color = Color.CORAL;
        par5.borderColor = Color.BLACK;
        font5 = gen5.generateFont(par5);

        gen1.dispose();
        gen2.dispose();
        gen3.dispose();
        gen4.dispose();
        gen5.dispose();
    }
}