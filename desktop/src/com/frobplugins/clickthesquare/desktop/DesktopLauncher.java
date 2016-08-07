package com.frobplugins.clickthesquare.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frobplugins.clickthesquare.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MainClass(null), config);
		config.width = 600;
		config.height = 800;
		config.resizable = false;
		config.title = "ClickTheSquare";
	}
}