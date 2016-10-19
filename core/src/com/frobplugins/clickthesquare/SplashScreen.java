package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * This app is copyrighted by FrobPlugins
 */

public class SplashScreen implements Screen {
    final MainClass main;
    AndroidOnlyInterface aoi;
    private Texture texture = new Texture(Gdx.files.internal("assets/Splash2.png"));
    private Image splashImage = new Image(texture);
    private Stage stage;
    private SkinSaver ss;
    adController adController;

    public SplashScreen(MainClass main, adController adController, AndroidOnlyInterface pAOI){
        this.main = main;
        aoi = pAOI;
        this.adController = adController;
        splashImage.setWidth(Gdx.graphics.getWidth());
        splashImage.setHeight(Gdx.graphics.getHeight());
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        stage.addActor(splashImage);
        loadMainMenu();
    }

    public void loadMainMenu(){
        splashImage.addAction(Actions.sequence(
                Actions.fadeIn(2f), Actions.run(new Runnable() {
                    public void run() {
                        Assets.loadAssets();
                        ss = new SkinSaver();
                        if(SkinSaver.getSkin() == 0){
                            SkinSaver.setDefaultSkin();
                        }
                        if(SkinSaver.getSkin() == SkinList.gold){
                            Assets.loadSkinGold();
                        }
                        if(SkinSaver.getSkin() == SkinList.green){
                            Assets.loadSkinGreen();
                        }
                        if(SkinSaver.getSkin() == SkinList.light_green){
                            Assets.loadSkinLightGreen();
                        }
                        if(SkinSaver.getSkin() == SkinList.metal){
                            Assets.loadSkinMetal();
                        }
                        if(SkinSaver.getSkin() == SkinList.nature){
                            Assets.loadSkinNature();
                        }
                        if(SkinSaver.getSkin() == SkinList.purple){
                            Assets.loadSkinPurple();
                        }
                        if(SkinSaver.getSkin() == SkinList.water){
                            Assets.loadSkinWater();
                        }
                        if(SkinSaver.getSkin() == SkinList.wood){
                            Assets.loadSkinWood();
                        }

                        Fonts.loadFonts();
                        ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu(main, aoi));
                    }
                })));
    }

    public void dispose(){
        texture.dispose();
        stage.dispose();
    }

    public void hide() {
        dispose();
    }

    public void pause() {

    }

    public void render(float arg0) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {

    }

    public void resume() {

    }

    public void show() {
       // adController.hideBannerAd();

    }
}