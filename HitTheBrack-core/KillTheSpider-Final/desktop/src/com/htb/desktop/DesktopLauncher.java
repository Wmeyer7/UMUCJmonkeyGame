package com.htb.desktop;


import com.htb.game.KillTheSpider;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher  {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable  = false;
		config.width = 480;
		config.height = 640;
		new LwjglApplication(new KillTheSpider(), config);
		}
}
