package com.frobplugins.clickthesquare;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

/**
 * This app is copyrighted by FrobPlugins
 */

public class Main implements Screen {
	AndroidOnlyInterface aoi;
	static Buttons[][] buttons;
	float tileSize;
	float boardOffsetX;
	float boardOffsetY;
	static int score = 0;
	Vector3 touch;
	MainClass main;
	float timer;
	GlyphLayout glyphLayout;
	GlyphLayout glyphLayout2;
	GlyphLayout addScoreText;
	GlyphLayout scoreToGo;
	Viewport viewport;
	private SkinSaver ss;
	private HighScoreManager hsm;
	private CurrentScoreManager csm;
	private MoneyManager moneyManager;
	private int StarterScore = 50;
	private static float timer2 = 0;
	float showTimer = 0;
	boolean showText = false;
	static int oldX = -1;
	static int oldY = -1;
	static int randX;
	static int randY;

	public Main(MainClass main, AndroidOnlyInterface pAOI){
		this.main = main;
		aoi = pAOI;
		score = 0;
		hsm = new HighScoreManager();
		csm = new CurrentScoreManager();
		moneyManager = new MoneyManager();
		Buttons.isFalse = false;
		ss = new SkinSaver();
		timer = 30;
		viewport = new StretchViewport(main.screen_width, main.screen_height, main.camera);
		viewport.apply();
		main.camera.position.set(main.camera.viewportWidth, main.camera.viewportHeight / 2, 0);
		create();
	}

	public void create () {
		Difficulty.selectedDifficulty = false;
		if(HighScoreManager.getDifficulty() == 0) {
			buttons = new Buttons[3][3];
		}
		if(HighScoreManager.getDifficulty() == 1) {
			buttons = new Buttons[4][4];
		}
		if(HighScoreManager.getDifficulty() == 2) {
			buttons = new Buttons[5][5];
		}
		if(HighScoreManager.getDifficulty() == 3) {
			buttons = new Buttons[6][6];
		}
		tileSize = Gdx.graphics.getWidth() / buttons[0].length;
		boardOffsetY = (Gdx.graphics.getHeight() - (tileSize * buttons[0].length)) / 2;
		boardOffsetX = (Gdx.graphics.getWidth() - (tileSize * buttons.length)) / 2;
		touch = new Vector3();
		for(int x=0;x<buttons.length;x++) {
			for (int y = 0; y < buttons[0].length; y++) {
				if (SkinSaver.getSkin() == SkinList.gold)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_gold);

				if (SkinSaver.getSkin() == SkinList.green)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_green);

				if (SkinSaver.getSkin() == SkinList.light_green)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_light_green);

				if (SkinSaver.getSkin() == SkinList.nature)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_nature);

				if (SkinSaver.getSkin() == SkinList.metal)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_metal);

				if (SkinSaver.getSkin() == SkinList.purple)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_purple);

				if (SkinSaver.getSkin() == SkinList.water)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off);

				if (SkinSaver.getSkin() == SkinList.wood)
					buttons[x][y] = new Buttons(x * tileSize + boardOffsetX, y * tileSize + boardOffsetY, tileSize, tileSize, IDList.Button_off_wood);
			}
		}

		randX = new Random().nextInt(buttons.length);
		randY = new Random().nextInt(buttons[0].length);
		oldX = randX;
		oldY = randY;

		if(SkinSaver.getSkin() == SkinList.gold)
			buttons[randX][randY].ID = IDList.Button_on_gold;

		if(SkinSaver.getSkin() == SkinList.green)
			buttons[randX][randY].ID = IDList.Button_on_green;

		if(SkinSaver.getSkin() == SkinList.light_green)
			buttons[randX][randY].ID = IDList.Button_on_light_green;

		if(SkinSaver.getSkin() == SkinList.nature)
			buttons[randX][randY].ID = IDList.Button_on_nature;

		if(SkinSaver.getSkin() == SkinList.metal)
			buttons[randX][randY].ID = IDList.Button_on_metal;

		if(SkinSaver.getSkin() == SkinList.purple)
			buttons[randX][randY].ID = IDList.Button_on_purple;

		if(SkinSaver.getSkin() == SkinList.water)
			buttons[randX][randY].ID = IDList.Button_on;

		if(SkinSaver.getSkin() == SkinList.wood)
			buttons[randX][randY].ID = IDList.Button_on_wood;

		glyphLayout = new GlyphLayout();
		glyphLayout2 = new GlyphLayout();
		addScoreText = new GlyphLayout();
		scoreToGo = new GlyphLayout();
		scoreToGo.setText(Fonts.font1, "Goal: " + StarterScore);
		addScoreText.setText(Fonts.font1, "+25 sec.");
	}

	@Override
	public void render (float delta) {
		main.camera.update();
		glyphLayout.setText(Fonts.font3, "Score: " + score);
		float w = glyphLayout.width;
		String time = String.format("%.2f", timer);
		glyphLayout2.setText(Fonts.font3, time);
		float w2 = glyphLayout2.width;
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		main.camera.update();
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
				if(timer < 5f && timer > 4.5f){
					buttons[x][y].toRed();
				}
				else if(timer < 4.5f && timer > 4f){
					buttons[x][y].toBlue();
				}
				else if(timer < 4f && timer > 3.5f){
					buttons[x][y].toRed();
				}
				else if(timer < 3.5f && timer > 3f){
					buttons[x][y].toBlue();
				}
				else if(timer < 3f && timer > 2.5f){
					buttons[x][y].toRed();
				}
				else if(timer < 2.5f && timer > 2f){
					buttons[x][y].toBlue();
				}
				else if(timer < 2f && timer > 1.5f){
					buttons[x][y].toRed();
				}
				else if(timer < 1.5f && timer > 1f){
					buttons[x][y].toBlue();
				}
				else if(timer < 1f && timer > 0.5f){
					buttons[x][y].toRed();
				}
				else if(timer < 0.5f && timer > 0f){
					buttons[x][y].toBlue();
				}
				buttons[x][y].Draw(main.batch);
			}
		}
		generateNumber(delta);
		Fonts.font3.draw(main.batch, glyphLayout, ((main.screen_width - w) / 2), main.screen_height / 100);
		Fonts.font3.draw(main.batch, glyphLayout2, ((main.screen_width - w2) / 2), main.screen_height / 15);
		Fonts.font1.draw(main.batch, scoreToGo, ((main.screen_width - scoreToGo.width)-scoreToGo.width/4), 0 + (buttons[0][0].y/2));
		if(showText == true){
			Fonts.font1.draw(main.batch, " +25 sec.", (main.screen_width / 2) + (main.screen_width/6), main.screen_height / 15);
		}
		main.batch.end();
		if(score >= 1) {
			timer -= delta;
		}

		for(int x=0;x<buttons.length;x++) {
			for (int y = 0; y < buttons[0].length; y++) {
				buttons[x][y].Update(Gdx.graphics.getDeltaTime());
			}
		}
		if((Buttons.isFalse) || timer <= 0){
			if(HighScoreManager.getDifficulty() == 0) {
				if (HighScoreManager.getHighScoreEasy() <= score) {
					hsm.setHighScore(score);
				}
			}
			if(HighScoreManager.getDifficulty() == 1) {
				if (HighScoreManager.getHighScoreNormal() <= score) {
					hsm.setHighScore(score);
				}
			}
			if(HighScoreManager.getDifficulty() == 2) {
				if (HighScoreManager.getHighScoreHard() <= score) {
					hsm.setHighScore(score);
				}
			}
			if(HighScoreManager.getDifficulty() == 3) {
				if (HighScoreManager.getHighScoreExpert() <= score) {
					hsm.setHighScore(score);
				}
			}
			csm.setCurrentScore(score);
			moneyManager.encryptAndSaveMoney(moneyManager.getDecryptedMoney()+score);
			Assets.sound_died.play(1.0f);

			((Game) Gdx.app.getApplicationListener()).setScreen(new Died(main, aoi));
		}
		if(score == StarterScore){
			StarterScore += 50;
			scoreToGo.setText(Fonts.font1, "Goal: " + StarterScore);
			Assets.sound_addTime.play(1.0f);
			timer += 25;
			showText = true;
		}
		if(showTimer >= 3f){
			showText = false;
			showTimer = 0;
		}else if(showText == true){
			showTimer += delta;
		}
	}

	public static void generateNumber(float delta){
		if(timer2 <= 1f && score >= 1) {
			timer2 += delta;
		}else if(timer2 >= 1f){
			timer2 = 0;
			timer2 = 0;
			generateNextNumber();
		}
		if(Buttons.isCorrect) {
			timer2 = 0;
			timer2 = 0;
			generateNextNumber();
		}
	}

	public static void generateNextNumber(){
		for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[0].length; col++) {
				if(SkinSaver.getSkin() == SkinList.gold)
					buttons[row][col].ID = IDList.Button_off_gold;

				if(SkinSaver.getSkin() == SkinList.green)
					buttons[row][col].ID = IDList.Button_off_green;

				if(SkinSaver.getSkin() == SkinList.light_green)
					buttons[row][col].ID = IDList.Button_off_light_green;

				if(SkinSaver.getSkin() == SkinList.nature)
					buttons[row][col].ID = IDList.Button_off_nature;

				if(SkinSaver.getSkin() == SkinList.metal)
					buttons[row][col].ID = IDList.Button_off_metal;

				if(SkinSaver.getSkin() == SkinList.purple)
					buttons[row][col].ID = IDList.Button_off_purple;

				if(SkinSaver.getSkin() == SkinList.water)
					buttons[row][col].ID = IDList.Button_off;

				if(SkinSaver.getSkin() == SkinList.wood)
					buttons[row][col].ID = IDList.Button_off_wood;
			}
		}
		randX = new Random().nextInt(buttons.length);
		randY = new Random().nextInt(buttons[0].length);
		if(oldX == randX && oldY == randY) {
			generateNextNumber();
			oldX = randX;
			oldY = randY;

			if(SkinSaver.getSkin() == SkinList.gold)
				buttons[randX][randY].ID = IDList.Button_on_gold;

			if(SkinSaver.getSkin() == SkinList.green)
				buttons[randX][randY].ID = IDList.Button_on_green;

			if(SkinSaver.getSkin() == SkinList.light_green)
				buttons[randX][randY].ID = IDList.Button_on_light_green;

			if(SkinSaver.getSkin() == SkinList.nature)
				buttons[randX][randY].ID = IDList.Button_on_nature;

			if(SkinSaver.getSkin() == SkinList.metal)
				buttons[randX][randY].ID = IDList.Button_on_metal;

			if(SkinSaver.getSkin() == SkinList.purple)
				buttons[randX][randY].ID = IDList.Button_on_purple;

			if(SkinSaver.getSkin() == SkinList.water)
				buttons[randX][randY].ID = IDList.Button_on;

			if(SkinSaver.getSkin() == SkinList.wood)
				buttons[randX][randY].ID = IDList.Button_on_wood;

			Buttons.isCorrect = false;
			System.out.println("true");
		}else{
			oldX = randX;
			oldY = randY;

			if(SkinSaver.getSkin() == SkinList.gold)
				buttons[randX][randY].ID = IDList.Button_on_gold;

			if(SkinSaver.getSkin() == SkinList.green)
				buttons[randX][randY].ID = IDList.Button_on_green;

			if(SkinSaver.getSkin() == SkinList.light_green)
				buttons[randX][randY].ID = IDList.Button_on_light_green;

			if(SkinSaver.getSkin() == SkinList.nature)
				buttons[randX][randY].ID = IDList.Button_on_nature;

			if(SkinSaver.getSkin() == SkinList.metal)
				buttons[randX][randY].ID = IDList.Button_on_metal;

			if(SkinSaver.getSkin() == SkinList.purple)
				buttons[randX][randY].ID = IDList.Button_on_purple;

			if(SkinSaver.getSkin() == SkinList.water)
				buttons[randX][randY].ID = IDList.Button_on;

			if(SkinSaver.getSkin() == SkinList.wood)
				buttons[randX][randY].ID = IDList.Button_on_wood;

			Buttons.isCorrect = false;
			System.out.println("false");
		}
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		main.camera.position.set(main.camera.viewportWidth/2, main.camera.viewportHeight/2, 0);
	}

	@Override
	public void show() {
		create();
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
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void hide() {

	}
}
