package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Gebruiker on 2-2-2016.
 */
public class MenuDifficulty implements Screen {
    AndroidOnlyInterface aoi;
    Texture background;
    MainClass main;
    GlyphLayout glyphLayout;
    GlyphLayout easy;
    GlyphLayout normal;
    GlyphLayout hard;
    Rectangle rect_easy, rect_normal, rect_hard;
    static int EASY = 1;
    static int NORMAL = 2;
    static int HARD = 3;
    static int Difficulty = 0;
    static boolean selectedDifficulty = false;
    Buttons[][] buttons;

    float tileSize;
    float boardOffsetX;
    float boardOffsetY;

    public MenuDifficulty(MainClass main, AndroidOnlyInterface pAOI){
        this.main = main;
        aoi = pAOI;
    }

    @Override
    public void show() {
        main.camera.update();
        buttons = new Buttons[1][3];
        tileSize = Gdx.graphics.getWidth() / buttons[0].length;
        boardOffsetY = (Gdx.graphics.getHeight() - (tileSize * buttons[0].length)) / 2;
        boardOffsetX = (Gdx.graphics.getWidth() - ((tileSize*3) * buttons.length)) / 2;
        for(int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++){
                if(SkinSaver.getSkin() == SkinList.gold)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_gold);

                if(SkinSaver.getSkin() == SkinList.green)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_green);

                if(SkinSaver.getSkin() == SkinList.light_green)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_light_green);

                if(SkinSaver.getSkin() == SkinList.nature)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_nature);

                if(SkinSaver.getSkin() == SkinList.metal)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_metal);

                if(SkinSaver.getSkin() == SkinList.purple)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_purple);

                if(SkinSaver.getSkin() == SkinList.water)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off);

                if(SkinSaver.getSkin() == SkinList.wood)
                    buttons[x][y] = new Buttons(x * (tileSize*3) + boardOffsetX, y * tileSize + boardOffsetY, (tileSize*3), tileSize, IDList.Button_off_wood);
            }
        }

        glyphLayout = new GlyphLayout();
        easy = new GlyphLayout();
        normal = new GlyphLayout();
        hard = new GlyphLayout();

        glyphLayout.setText(Fonts.font2, "Difficulty");
        easy.setText(Fonts.font5, "EASY");
        normal.setText(Fonts.font5, "NORMAL");
        hard.setText(Fonts.font5, "HARD");

        rect_easy = new Rectangle((buttons[0][0].x), buttons[0][0].y, buttons[0][0].width, buttons[0][0].height);
        rect_normal = new Rectangle((buttons[0][1].x), buttons[0][1].y, buttons[0][1].width, buttons[0][1].height);
        rect_hard = new Rectangle((buttons[0][2].x), buttons[0][2].y, buttons[0][2].width, buttons[0][2].height);

        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        main.camera.update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float w = glyphLayout.width;
        main.batch.setProjectionMatrix(main.camera.combined);
        main.batch.begin();

        if(SkinSaver.getSkin() == SkinList.gold){
            main.batch.draw(Assets.sprite_background_gold, Assets.sprite_background_gold.getX(), Assets.sprite_background_gold.getY(), Assets.sprite_background_gold.getWidth(), Assets.sprite_background_gold.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.green){
            main.batch.draw(Assets.sprite_background_green, Assets.sprite_background_green.getX(), Assets.sprite_background_green.getY(), Assets.sprite_background_green.getWidth(), Assets.sprite_background_green.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.light_green){
            main.batch.draw(Assets.sprite_background_light_green, Assets.sprite_background_light_green.getX(), Assets.sprite_background_light_green.getY(), Assets.sprite_background_light_green.getWidth(), Assets.sprite_background_light_green.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.metal){
            main.batch.draw(Assets.sprite_background_metal, Assets.sprite_background_metal.getX(), Assets.sprite_background_metal.getY(), Assets.sprite_background_metal.getWidth(), Assets.sprite_background_metal.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.nature){
            main.batch.draw(Assets.sprite_background_nature, Assets.sprite_background_nature.getX(), Assets.sprite_background_nature.getY(), Assets.sprite_background_nature.getWidth(), Assets.sprite_background_nature.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.purple){
            main.batch.draw(Assets.sprite_background_purple, Assets.sprite_background_purple.getX(), Assets.sprite_background_purple.getY(), Assets.sprite_background_purple.getWidth(), Assets.sprite_background_purple.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.water){
            main.batch.draw(Assets.sprite_background, Assets.sprite_background.getX(), Assets.sprite_background.getY(), Assets.sprite_background.getWidth(), Assets.sprite_background.getHeight());
        }
        if(SkinSaver.getSkin() == SkinList.wood){
            main.batch.draw(Assets.sprite_background_wood, Assets.sprite_background_wood.getX(), Assets.sprite_background_wood.getY(), Assets.sprite_background_wood.getWidth(), Assets.sprite_background_wood.getHeight());
        }

        for(int x=0;x<buttons.length;x++) {
            for (int y = 0; y < buttons[0].length; y++) {
                buttons[x][y].Draw(main.batch);
            }
        }

        Fonts.font2.draw(main.batch, glyphLayout, ((main.screen_width - w)/2), 20);
        Fonts.font5.draw(main.batch, easy, ((main.screen_width - easy.width) / 2), ((buttons[0][0].y + buttons[0][0].height) - (buttons[0][0].height/2)) - easy.height/2);
        Fonts.font5.draw(main.batch, normal, ((main.screen_width - normal.width)/2), ((buttons[0][1].y + buttons[0][1].height) - (buttons[0][1].height/2)) - normal.height/2);
        Fonts.font5.draw(main.batch, hard, ((main.screen_width - hard.width)/2), ((buttons[0][2].y + buttons[0][2].height) - (buttons[0][2].height/2)) - hard.height/2);
        main.batch.end();

        if(Gdx.input.justTouched()){
            if(rect_easy.contains(Gdx.input.getX(), Gdx.input.getY())){
                setEasy();
                Assets.sound_addTime.play(1.0f);
                HighScoreManager.setDifficulty(0);
                selectedDifficulty = true;
                System.out.println("Set Easy");
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
            }
            if(rect_normal.contains(Gdx.input.getX(), Gdx.input.getY())){
                setNormal();
                Assets.sound_addTime.play(1.0f);
                HighScoreManager.setDifficulty(1);
                selectedDifficulty = true;
                System.out.println("Set Normal");
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
            }
            if(rect_hard.contains(Gdx.input.getX(), Gdx.input.getY())){
                setHard();
                Assets.sound_addTime.play(1.0f);
                HighScoreManager.setDifficulty(2);
                selectedDifficulty = true;
                System.out.println("Set Hard");
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
        }
    }

    public static void setEasy(){
        Difficulty = EASY;
    }
    public static void setNormal(){
        Difficulty = NORMAL;
    }
    public static void setHard(){
        Difficulty = HARD;
    }

    public static int getDifficulty(){
        return Difficulty;
    }

    @Override
    public void dispose() {
        Fonts.font1.dispose();
        Fonts.font2.dispose();
        Fonts.font3.dispose();
        Fonts.font4.dispose();
        Fonts.font5.dispose();
        Assets.sound_addTime.dispose();
        Assets.sound_count.dispose();
        Assets.sound_died.dispose();
        Assets.background.dispose();
        Assets.button_off.dispose();
        Assets.button_on.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
