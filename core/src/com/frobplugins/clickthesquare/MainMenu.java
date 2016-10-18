package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;

/**
 * This app is copyrighted by FrobPlugins
 */

public class MainMenu implements Screen {
    MainClass main;
    AndroidOnlyInterface aoi;
    Buttons[][] buttons;
    float tileSizeY;
    float tileSizeX;
    float boardOffsetY;
    float boardOffsetX;
    GlyphLayout glyphLayout;
    GlyphLayout play;
    GlyphLayout difficulty;
    GlyphLayout SkinSelector;
    Rectangle play_rect;
    Rectangle difficulty_rect;
    Rectangle SkinSelector_rect;

    public MainMenu(MainClass main, AndroidOnlyInterface pAOI){
        this.main = main;
        aoi = pAOI;
        buttons = new Buttons[1][3];

        tileSizeY = (Gdx.graphics.getWidth() / buttons[0].length) / 1.5f;
        tileSizeX = Gdx.graphics.getWidth() / buttons.length;
        boardOffsetY = (Gdx.graphics.getHeight() - (tileSizeY * buttons[0].length)) / 2;
        boardOffsetX = (Gdx.graphics.getWidth() - ((tileSizeX) * buttons.length)) / 2;
        for(int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++) {
                if(SkinSaver.getSkin() == SkinList.gold)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_gold);
                if(SkinSaver.getSkin() == SkinList.green)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_green);
                if(SkinSaver.getSkin() == SkinList.light_green)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_light_green);
                if(SkinSaver.getSkin() == SkinList.nature)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_nature);
                if(SkinSaver.getSkin() == SkinList.metal)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_metal);
                if(SkinSaver.getSkin() == SkinList.purple)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_purple);
                if(SkinSaver.getSkin() == SkinList.water)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off);
                if(SkinSaver.getSkin() == SkinList.wood)
                    buttons[x][y] = new Buttons(x * (tileSizeX) + boardOffsetX, y * tileSizeY + boardOffsetY, (tileSizeX), tileSizeY, IDList.Button_off_wood);

            }
        }

        if(SkinSaver.getSkin() == SkinList.gold || SkinSaver.getSkin() == SkinList.purple){
            Fonts.font1.setColor(Color.CYAN);
            Fonts.font3.setColor(Color.CYAN);
            Fonts.font4.setColor(Color.CYAN);
            Fonts.font5.setColor(Color.CYAN);
        }else{
            Fonts.font1.setColor(Color.CORAL);
            Fonts.font3.setColor(Color.CORAL);
            Fonts.font4.setColor(Color.RED);
            Fonts.font5.setColor(Color.CORAL);
        }

        glyphLayout = new GlyphLayout();
        play = new GlyphLayout();
        difficulty = new GlyphLayout();
        SkinSelector = new GlyphLayout();

        glyphLayout.setText(Fonts.font3, "ClickTheSquare");
        play.setText(Fonts.font5, "Play");
        difficulty.setText(Fonts.font5, "Difficulty");
        SkinSelector.setText(Fonts.font5, "Skin Selector");

        play_rect = new Rectangle(buttons[0][0].x, buttons[0][0].y,buttons[0][0].getWidth(), buttons[0][0].getHeight());
        difficulty_rect = new Rectangle(buttons[0][1].x, buttons[0][1].y,buttons[0][1].getWidth(), buttons[0][1].getHeight());
        SkinSelector_rect = new Rectangle(buttons[0][2].x, buttons[0][2].y,buttons[0][2].getWidth(), buttons[0][2].getHeight());
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        for(int x=0;x<buttons.length;x++){
                for(int y=0;y<buttons[0].length;y++){
                    buttons[x][y].Draw(main.batch);
                }
            }
        Fonts.font3.draw(main.batch, glyphLayout, ((main.screen_width - glyphLayout.width) / 2), 20);
        Fonts.font5.draw(main.batch, play, ((main.screen_width - play.width) / 2), ((buttons[0][0].y + buttons[0][0].height) - (buttons[0][0].height/2)) - play.height/2);
        Fonts.font5.draw(main.batch, difficulty, ((main.screen_width - difficulty.width) / 2), ((buttons[0][1].y + buttons[0][1].height) - (buttons[0][1].height/2)) - difficulty.height/2);
        Fonts.font5.draw(main.batch, SkinSelector, ((main.screen_width - SkinSelector.width) / 2), ((buttons[0][2].y + buttons[0][2].height) - (buttons[0][2].height/2)) - SkinSelector.height/2);
        main.batch.end();
        if(Gdx.input.justTouched()) {
            if (play_rect.contains(Gdx.input.getX(), Gdx.input.getY())) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new Main(main, aoi));
            }
            if (difficulty_rect.contains(Gdx.input.getX(), Gdx.input.getY())) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MenuDifficulty(main, aoi));
            }
            if (SkinSelector_rect.contains(Gdx.input.getX(), Gdx.input.getY())) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new SkinsMenu(main, aoi));
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.BACK)){
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }
}
