package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/**
 * This app is copyrighted by FrobPlugins
 */

public class SkinsMenu implements Screen{
    MainClass main;
    GlyphLayout glyphLayout;
    GlyphLayout money;
    Buttons[][] buttons;

    float tileSizeX;
    float tileSizeY;
    float boardOffsetY;
    float boardOffsetX;

    public HighScoreManager hsm = new HighScoreManager();
    public MoneyManager moneyManager = new MoneyManager();
    public SkinStoreManager skinStoreManager = new SkinStoreManager();

    AndroidOnlyInterface aoi;

    public SkinsMenu(MainClass main, AndroidOnlyInterface pAOI){
        this.main = main;
        aoi = pAOI;
    }

    @Override
    public void show() {
        buttons = new Buttons[4][2];

        tileSizeX = Gdx.graphics.getWidth() / buttons.length;
        tileSizeY = Gdx.graphics.getWidth() / buttons.length;
        boardOffsetY = (Gdx.graphics.getHeight() - (tileSizeY * buttons[0].length)) / 2;
        boardOffsetX = (Gdx.graphics.getWidth() - (tileSizeX * buttons.length)) / 2;
        for(int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++){
                buttons[x][y] = new Buttons(x * tileSizeX + boardOffsetX, y * tileSizeY + boardOffsetY, tileSizeX, tileSizeY, IDList.Button_off);
            }
        }
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(Fonts.font2, "Skin Selector");

        money = new GlyphLayout();
        money.setText(Fonts.font6, "Money: " + moneyManager.getDecryptedMoney());

        buttons[0][0].ID = IDList.Button_off;
        buttons[1][0].ID = IDList.Button_off_green;
        buttons[2][0].ID = IDList.Button_off_light_green;
        buttons[3][0].ID = IDList.Button_off_purple;
        buttons[0][1].ID = IDList.Button_off_gold;
        buttons[1][1].ID = IDList.Button_off_wood;
        buttons[2][1].ID = IDList.Button_off_nature;
        buttons[3][1].ID = IDList.Button_off_metal;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        float glyphLayout_w = glyphLayout.width;
        float money_w = money.width;
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
        Fonts.font2.draw(main.batch, glyphLayout, ((main.screen_width - glyphLayout_w) / 2), 30);
        Fonts.font6.draw(main.batch, money, ((main.screen_width - money_w) / 2), 240);
        for (int x=0;x<buttons.length;x++){
            for(int y=0;y<buttons[0].length;y++){
                buttons[x][y].Draw(main.batch);
            }
        }

        if(skinStoreManager.checkIfGoldUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[0][1].x + buttons[0][1].width/2 - ((tileSizeX/4)*3)/2, buttons[0][1].y + buttons[0][1].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }
        if(skinStoreManager.checkIfGreenUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[1][0].x + buttons[1][0].width/2 - ((tileSizeX/4)*3)/2, buttons[1][0].y + buttons[1][0].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }
        if(skinStoreManager.checkIfLightGreenUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[2][0].x + buttons[2][0].width/2 - ((tileSizeX/4)*3)/2, buttons[2][0].y + buttons[2][0].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }
        if(skinStoreManager.checkIfMetalUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[3][1].x + buttons[3][1].width/2 - ((tileSizeX/4)*3)/2, buttons[3][1].y + buttons[3][1].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }
        if(skinStoreManager.checkIfNatureUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[2][1].x + buttons[2][1].width/2 - ((tileSizeX/4)*3)/2, buttons[2][1].y + buttons[2][1].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }
        if(skinStoreManager.checkIfPurpleUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[3][0].x + buttons[3][0].width/2 - ((tileSizeX/4)*3)/2, buttons[3][0].y + buttons[3][0].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }
        if(skinStoreManager.checkIfWoodUnlocked() == 0){
            main.batch.draw(Assets.sprite_lock, buttons[1][1].x + buttons[1][1].width/2 - ((tileSizeX/4)*3)/2, buttons[1][1].y + buttons[1][1].height/2 - ((tileSizeX/4)*3)/2, (tileSizeX/4)*3, (tileSizeY/4)*3);
        }

        main.batch.end();
        if(Gdx.input.justTouched()){
            int oldSkin = SkinSaver.getSkin();
            for(int x=0;x<buttons.length;x++){
                for(int y=0;y<buttons[0].length;y++){
                    if(buttons[x][y].sprite.contains(Gdx.input.getX(), Gdx.input.getY())) {
                        if (buttons[x][y].ID == IDList.Button_off_gold) {
                            if(skinStoreManager.checkIfGoldUnlocked() == 1) {
                                SkinSaver.setSkin(SkinList.gold);
                                Assets.loadSkinGold();
                                Assets.unloadSkins(SkinList.gold, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                        if (buttons[x][y].ID == IDList.Button_off_green) {
                            if(skinStoreManager.checkIfGreenUnlocked() == 1){
                                SkinSaver.setSkin(SkinList.green);
                                Assets.loadSkinGreen();
                                Assets.unloadSkins(SkinList.green, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                        if (buttons[x][y].ID == IDList.Button_off_light_green) {
                            if(skinStoreManager.checkIfLightGreenUnlocked() == 1) {
                                SkinSaver.setSkin(SkinList.light_green);
                                Assets.loadSkinLightGreen();
                                Assets.unloadSkins(SkinList.light_green, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                        if (buttons[x][y].ID == IDList.Button_off_metal) {
                            if(skinStoreManager.checkIfMetalUnlocked() == 1) {
                                SkinSaver.setSkin(SkinList.metal);
                                Assets.loadSkinMetal();
                                Assets.unloadSkins(SkinList.metal, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                        if (buttons[x][y].ID == IDList.Button_off_nature) {
                            if(skinStoreManager.checkIfNatureUnlocked() == 1) {
                                SkinSaver.setSkin(SkinList.nature);
                                Assets.loadSkinNature();
                                Assets.unloadSkins(SkinList.nature, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                        if (buttons[x][y].ID == IDList.Button_off_purple) {
                            if(skinStoreManager.checkIfPurpleUnlocked() == 1) {
                                SkinSaver.setSkin(SkinList.purple);
                                Assets.loadSkinPurple();
                                Assets.unloadSkins(SkinList.purple, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                        if (buttons[x][y].ID == IDList.Button_off) {
                            SkinSaver.setSkin(SkinList.water);
                            Assets.loadSkinWater();
                            Assets.unloadSkins(SkinList.water, oldSkin);
                            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                        }
                        if (buttons[x][y].ID == IDList.Button_off_wood) {
                            if(skinStoreManager.checkIfWoodUnlocked() == 1) {
                                SkinSaver.setSkin(SkinList.wood);
                                Assets.loadSkinWood();
                                Assets.unloadSkins(SkinList.wood, oldSkin);
                                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                            }else{
                                aoi.toast("Not unlocked yet");
                            }
                        }
                    }
                }
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
        }
    }

    @Override
    public void dispose() {
        Fonts.font1.dispose();
        Fonts.font2.dispose();
        Fonts.font3.dispose();
        Fonts.font4.dispose();
        Fonts.font5.dispose();
        Fonts.font6.dispose();
        Fonts.font7.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
