package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This app is copyrighted now
 */
public class Assets {

    static Texture background;
    static Texture background_green;
    static Texture background_light_green;
    static Texture background_purple;
    static Texture background_gold;
    static Texture background_wood;
    static Texture background_nature;
    static Texture background_metal;

    static Texture button_on;
    static Texture button_on_green;
    static Texture button_on_light_green;
    static Texture button_on_purple;
    static Texture button_on_gold;
    static Texture button_on_wood;
    static Texture button_on_nature;
    static Texture button_on_metal;

    static Texture button_off;
    static Texture button_off_green;
    static Texture button_off_light_green;
    static Texture button_off_purple;
    static Texture button_off_gold;
    static Texture button_off_wood;
    static Texture button_off_nature;
    static Texture button_off_metal;

    static Texture button_on_red;
    static Texture button_off_red;

    static Sound sound_died;
    static Sound sound_count;
    static Sound sound_addTime;

    static Sprite sprite_background;
    static Sprite sprite_background_green;
    static Sprite sprite_background_light_green;
    static Sprite sprite_background_purple;
    static Sprite sprite_background_gold;
    static Sprite sprite_background_wood;
    static Sprite sprite_background_nature;
    static Sprite sprite_background_metal;


    public static void loadAssets() {
        button_on_red = new Texture(Gdx.files.internal("assets/water/Button_on_red.png"));
        button_off_red = new Texture(Gdx.files.internal("assets/water/Button_off_red.png"));

        button_off_gold = new Texture(Gdx.files.internal("assets/gold/Button_off.png"));
        button_off_green = new Texture(Gdx.files.internal("assets/green/Button_off.png"));
        button_off_light_green = new Texture(Gdx.files.internal("assets/lightgreen/Button_off.png"));
        button_off_metal = new Texture(Gdx.files.internal("assets/metal/Button_off.png"));
        button_off_nature = new Texture(Gdx.files.internal("assets/nature/Button_off.png"));
        button_off_purple = new Texture(Gdx.files.internal("assets/purple/Button_off.png"));
        button_off = new Texture(Gdx.files.internal("assets/water/Button_off.png"));
        button_off_wood = new Texture(Gdx.files.internal("assets/wood/Button_off.png"));

        sound_died = Gdx.audio.newSound(Gdx.files.internal("assets/Died.wav"));
        sound_count = Gdx.audio.newSound(Gdx.files.internal("assets/Count.wav"));
        sound_addTime = Gdx.audio.newSound(Gdx.files.internal("assets/AddTime.wav"));
    }

    public static void loadSkinGold(){
        background_gold = new Texture(Gdx.files.internal("assets/gold/Background.jpg"));
        button_on_gold = new Texture(Gdx.files.internal("assets/gold/Button_on.png"));

        sprite_background_gold = new Sprite(background_gold);
        sprite_background_gold.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_gold.flip(false, true);
    }

    public static void loadSkinGreen(){
        background_green = new Texture(Gdx.files.internal("assets/green/Background.jpg"));
        button_on_green = new Texture(Gdx.files.internal("assets/green/Button_on.png"));

        sprite_background_green = new Sprite(background_green);
        sprite_background_green.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_green.flip(false, true);
    }

    public static void loadSkinLightGreen(){
        background_light_green = new Texture(Gdx.files.internal("assets/lightgreen/Background.jpg"));
        button_on_light_green = new Texture(Gdx.files.internal("assets/lightgreen/Button_on.png"));

        sprite_background_light_green = new Sprite(background_light_green);
        sprite_background_light_green.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_light_green.flip(false, true);
    }

    public static void loadSkinMetal(){
        background_metal = new Texture(Gdx.files.internal("assets/metal/Background.jpg"));
        button_on_metal = new Texture(Gdx.files.internal("assets/metal/Button_on.png"));

        sprite_background_metal = new Sprite(background_metal);
        sprite_background_metal.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_metal.flip(false, true);
    }

    public static void loadSkinNature(){
        background_nature = new Texture(Gdx.files.internal("assets/nature/Background.jpg"));
        button_on_nature = new Texture(Gdx.files.internal("assets/nature/Button_on.png"));

        sprite_background_nature = new Sprite(background_nature);
        sprite_background_nature.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_nature.flip(false, true);
    }

    public static void loadSkinPurple(){
        background_purple = new Texture(Gdx.files.internal("assets/purple/Background.jpg"));
        button_on_purple = new Texture(Gdx.files.internal("assets/purple/Button_on.png"));

        sprite_background_purple = new Sprite(background_purple);
        sprite_background_purple.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_purple.flip(false, true);
    }

    public static void loadSkinWater(){
        background = new Texture(Gdx.files.internal("assets/water/Background.jpg"));
        button_on = new Texture(Gdx.files.internal("assets/water/Button_on.png"));

        sprite_background = new Sprite(background);
        sprite_background.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background.flip(false, true);

    }

    public static void loadSkinWood(){
        background_wood = new Texture(Gdx.files.internal("assets/wood/Background.jpg"));
        button_on_wood = new Texture(Gdx.files.internal("assets/wood/Button_on.png"));

        sprite_background_wood = new Sprite(background_wood);
        sprite_background_wood.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite_background_wood.flip(false, true);
    }

    public static void disposeGold(){
        background_gold.dispose();
        button_on_gold.dispose();
    }

    public static void disposeGreen(){
        background_green.dispose();
        button_on_green.dispose();
    }

    public static void disposeLightGreen(){
        background_light_green.dispose();
        button_on_light_green.dispose();
    }

    public static void disposeMetal(){
        background_metal.dispose();
        button_on_metal.dispose();
    }

    public static void disposeNature(){
        background_nature.dispose();
        button_on_nature.dispose();
    }

    public static void disposePurple(){
        background_purple.dispose();
        button_on_purple.dispose();
    }

    public static void disposeWater(){
        background.dispose();
        button_on.dispose();
    }

    public static void disposeWood(){
        background_wood.dispose();
        button_on_wood.dispose();
    }

    public static void unloadSkins(int skin, int oldSkin){
        if(oldSkin == SkinList.gold && skin != SkinList.gold){
            disposeGold();
        }
        if(oldSkin == SkinList.green && skin != SkinList.green){
            disposeGreen();
        }
        if(oldSkin == SkinList.light_green && skin != SkinList.light_green){
            disposeLightGreen();
        }
        if(oldSkin == SkinList.metal && skin != SkinList.metal){
            disposeMetal();
        }
        if(oldSkin == SkinList.nature && skin != SkinList.nature){
            disposeNature();
        }
        if(oldSkin == SkinList.purple && skin != SkinList.purple){
            disposePurple();
        }
        if(oldSkin == SkinList.water && skin != SkinList.water){
            disposeWater();
        }
        if(oldSkin == SkinList.wood && skin != SkinList.wood){
            disposeWood();
        }
    }
}
