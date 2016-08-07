package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import javafx.scene.input.MouseButton;

/**
 * Created by Gebruiker on 27-1-2016.
 */
public class Buttons extends Sprite {
    float ID;
    float x, y, width, height;
    float timer = 0;
    static boolean isCorrect = false;
    static boolean isFalse = false;
    Rectangle sprite;

    public Buttons(float x, float y, float width, float height, float ID){
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        sprite = new Rectangle(x, y, width, height);
        setBounds(x, y, width, height);
    }

    public void Update(float dt){
        if(sprite.contains(Gdx.input.getX(), Gdx.input.getY()) && (ID == IDList.Button_off_gold || ID == IDList.Button_off_green ||
                ID == IDList.Button_off_light_green || ID == IDList.Button_off_nature || ID == IDList.Button_off_metal ||
                ID == IDList.Button_off_purple || ID == IDList.Button_off || ID == IDList.Button_off_wood ||
                ID == IDList.Button_off_red) && Main.score >= 1){
            if(Gdx.input.justTouched()) {
                isFalse = true;
            }
        }
        if(sprite.contains(Gdx.input.getX(), Gdx.input.getY()) && (ID == IDList.Button_on_gold || ID == IDList.Button_on_green ||
                ID == IDList.Button_on_light_green || ID == IDList.Button_on_nature || ID == IDList.Button_on_metal || ID == IDList.Button_on_purple ||
                ID == IDList.Button_on || ID == IDList.Button_on_wood || ID == IDList.Button_on_red)){
            if(Gdx.input.justTouched()) {
                Main.score++;
                isCorrect = true;
                Random random = new Random();
                int rand = random.nextInt(3);
                if (rand == 0){
                    Assets.sound_count.play(1.0f, 1.0f, 2.0f);
                }
                if (rand == 1){
                    Assets.sound_count.play(1.0f, 1.1f, 2.0f);
                }
                if (rand == 2){
                    Assets.sound_count.play(1.0f, 0.9f, 2.0f);
                }
            }
        }
    }

    public void toRed(){
        if(ID == IDList.Button_off_gold || ID == IDList.Button_off_green ||
                ID == IDList.Button_off_light_green || ID == IDList.Button_off_nature || ID == IDList.Button_off_metal ||
                ID == IDList.Button_off_purple || ID == IDList.Button_off || ID == IDList.Button_off_wood) {
            ID = IDList.Button_off_red;
        }
        if(ID == IDList.Button_on_gold || ID == IDList.Button_on_green ||
                ID == IDList.Button_on_light_green || ID == IDList.Button_on_nature || ID == IDList.Button_on_metal || ID == IDList.Button_on_purple ||
                ID == IDList.Button_on || ID == IDList.Button_on_wood){
            ID = IDList.Button_on_red;
        }
    }

    public void toBlue(){
        if(ID == IDList.Button_off_red) {
            if(SkinSaver.getSkin() == SkinList.gold)
                ID = IDList.Button_off_gold;
            if(SkinSaver.getSkin() == SkinList.green)
                ID = IDList.Button_off_green;
            if(SkinSaver.getSkin() == SkinList.light_green)
                ID = IDList.Button_off_light_green;
            if(SkinSaver.getSkin() == SkinList.nature)
                ID = IDList.Button_off_nature;
            if(SkinSaver.getSkin() == SkinList.metal)
                ID = IDList.Button_off_metal;
            if(SkinSaver.getSkin() == SkinList.purple)
                ID = IDList.Button_off_purple;
            if(SkinSaver.getSkin() == SkinList.water)
                ID = IDList.Button_off;
            if(SkinSaver.getSkin() == SkinList.wood)
                ID = IDList.Button_off_wood;
        }
        if(ID == IDList.Button_on_red){
            if(SkinSaver.getSkin() == SkinList.gold)
                ID = IDList.Button_on_gold;
            if(SkinSaver.getSkin() == SkinList.green)
                ID = IDList.Button_on_green;
            if(SkinSaver.getSkin() == SkinList.light_green)
                ID = IDList.Button_on_light_green;
            if(SkinSaver.getSkin() == SkinList.nature)
                ID = IDList.Button_on_nature;
            if(SkinSaver.getSkin() == SkinList.metal)
                ID = IDList.Button_on_metal;
            if(SkinSaver.getSkin() == SkinList.purple)
                ID = IDList.Button_on_purple;
            if(SkinSaver.getSkin() == SkinList.water)
                ID = IDList.Button_on;
            if(SkinSaver.getSkin() == SkinList.wood)
                ID = IDList.Button_on_wood;
        }
    }

    public void Draw(SpriteBatch batch){
        if(ID == IDList.Button_off){
            batch.draw(Assets.button_off, x, y, width, height);
        }
        if(ID == IDList.Button_on){
            batch.draw(Assets.button_on, x, y, width, height);
        }

        if(ID == IDList.Button_on_red){
            batch.draw(Assets.button_on_red, x, y, width, height);
        }
        if(ID == IDList.Button_off_red){
            batch.draw(Assets.button_off_red, x, y, width, height);
        }

        if(ID == IDList.Button_off_green){
            batch.draw(Assets.button_off_green, x, y, width, height);
        }
        if(ID == IDList.Button_on_green){
            batch.draw(Assets.button_on_green, x, y, width, height);
        }

        if(ID == IDList.Button_off_light_green){
            batch.draw(Assets.button_off_light_green, x, y, width, height);
        }
        if(ID == IDList.Button_on_light_green){
            batch.draw(Assets.button_on_light_green, x, y, width, height);
        }

        if(ID == IDList.Button_off_purple){
            batch.draw(Assets.button_off_purple, x, y, width, height);
        }
        if(ID == IDList.Button_on_purple){
            batch.draw(Assets.button_on_purple, x, y, width, height);
        }

        if(ID == IDList.Button_off_gold){
            batch.draw(Assets.button_off_gold, x, y, width, height);
        }
        if(ID == IDList.Button_on_gold){
            batch.draw(Assets.button_on_gold, x, y, width, height);
        }

        if(ID == IDList.Button_off_wood){
            batch.draw(Assets.button_off_wood, x, y, width, height);
        }
        if(ID == IDList.Button_on_wood){
            batch.draw(Assets.button_on_wood, x, y, width, height);
        }

        if(ID == IDList.Button_off_nature){
            batch.draw(Assets.button_off_nature, x, y, width, height);
        }
        if(ID == IDList.Button_on_nature){
            batch.draw(Assets.button_on_nature, x, y, width, height);
        }

        if(ID == IDList.Button_off_metal){
            batch.draw(Assets.button_off_metal, x, y, width, height);
        }
        if(ID == IDList.Button_on_metal){
            batch.draw(Assets.button_on_metal, x, y, width, height);
        }
    }
}
