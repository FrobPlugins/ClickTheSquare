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

/**
 * Created by Gebruiker on 2-2-2016.
 */
public class Died implements Screen {

    Texture background;
    MainClass main;
    Buttons[][] buttons;
    float boardOffset;
    float tileSize;
    GlyphLayout glyphLayout;
    GlyphLayout glyphLayout2;
    GlyphLayout glyphLayout3;
    GlyphLayout glyphLayout4;
    GlyphLayout glyphLayout5;
    private HighScoreManager hsm;
    private CurrentScoreManager csm;

    public Died(MainClass main){
        this.main = main;
        hsm = new HighScoreManager();
        csm = new CurrentScoreManager();
    }

    @Override
    public void show() {
        buttons = new Buttons[2][2];
        tileSize = Gdx.graphics.getWidth() / buttons[0].length;
        boardOffset = (Gdx.graphics.getHeight() - (tileSize * buttons.length)) / 2;
        for(int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++){
                if(SkinSaver.getSkin() == SkinList.gold)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_gold);
                if(SkinSaver.getSkin() == SkinList.green)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_green);
                if(SkinSaver.getSkin() == SkinList.light_green)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_light_green);
                if(SkinSaver.getSkin() == SkinList.nature)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_nature);
                if(SkinSaver.getSkin() == SkinList.metal)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_metal);
                if(SkinSaver.getSkin() == SkinList.purple)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_purple);
                if(SkinSaver.getSkin() == SkinList.water)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off);
                if(SkinSaver.getSkin() == SkinList.wood)
                    buttons[x][y] = new Buttons(x * tileSize, y * tileSize + boardOffset, tileSize, tileSize, IDList.Button_off_wood);            }
        }
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(Fonts.font2, "Game Over");
        glyphLayout2 = new GlyphLayout();
        glyphLayout3 = new GlyphLayout();
        glyphLayout4 = new GlyphLayout();
        glyphLayout5 = new GlyphLayout();

        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        glyphLayout2.setText(Fonts.font1, "Score: " + CurrentScoreManager.getCurrentScore());
        glyphLayout3.setText(Fonts.font1, "HighScores: \n" + "\n"
                + "Easy: " + HighScoreManager.getHighScoreEasy() + "\n"
                + "Normal: " + HighScoreManager.getHighScoreNormal() + "\n"
                + "Hard: " + HighScoreManager.getHighScoreHard() + "\n"
                + "Expert: " + HighScoreManager.getHighScoreExpert());
        glyphLayout4.setText(Fonts.font1, "Difficulty");
        glyphLayout5.setText(Fonts.font1, "Retry");
        float w = glyphLayout.width;
        float w2 = glyphLayout2.width;
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
        Fonts.font2.draw(main.batch, glyphLayout, ((main.screen_width - w)/2), 30);
        for (int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++){
                buttons[x][y].Draw(main.batch);
            }
        }
        Fonts.font1.draw(main.batch, glyphLayout2, ((main.screen_width/4 * 3) - (glyphLayout2.width/2)), ((buttons[1][0].y + buttons[1][0].height) - (buttons[1][0].height/2)) - glyphLayout2.height/2);
        Fonts.font1.draw(main.batch, glyphLayout3, ((main.screen_width/4) - (glyphLayout3.width/2)), ((buttons[1][1].y + buttons[1][1].height) - (buttons[1][1].height/2)) - glyphLayout3.height/2);
        Fonts.font1.draw(main.batch, glyphLayout4, ((main.screen_width/4 * 3) - (glyphLayout4.width/2)), ((buttons[1][1].y + buttons[1][1].height) - (buttons[1][1].height/2)) - glyphLayout4.height/2);
        Fonts.font1.draw(main.batch, glyphLayout5, ((main.screen_width/4) - (glyphLayout5.width/2)), ((buttons[1][0].y + buttons[1][0].height) - (buttons[1][0].height/2)) - glyphLayout5.height/2);
        main.batch.end();
        for (int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++) {
                if (buttons[x][y].sprite.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    if(x == 0 && y == 0){
                        if(Gdx.input.justTouched()){
                            ((Game) Gdx.app.getApplicationListener()).setScreen(new Main(main));
                            Buttons.isFalse = false;

                        }
                    }
                    if(x == 1 && y == 1){
                        if(Gdx.input.justTouched()) {
                            ((Game) Gdx.app.getApplicationListener()).setScreen(new Difficulty(main));
                            Buttons.isFalse = false;
                        }
                    }
                }
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main));
        }
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
