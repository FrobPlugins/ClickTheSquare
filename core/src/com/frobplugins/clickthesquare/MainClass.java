package com.frobplugins.clickthesquare;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gebruiker on 2-2-2016.
 */
public class MainClass extends Game implements ApplicationListener {
    AndroidOnlyInterface aoi;
    OrthographicCamera camera;
    SpriteBatch batch;
    float screen_width;
    float screen_height;
    adController adController;

    public MainClass(adController adController, AndroidOnlyInterface pAOI){
        this.adController = adController;
        aoi = pAOI;
    }

    @Override
    public void create() {
        screen_width = Gdx.graphics.getWidth();
        screen_height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(true, screen_width, screen_height);
        batch = new SpriteBatch();
        setScreen(new SplashScreen(this, adController, aoi));
    }

    @Override
    public void render() {
        super.render();
    }
}
