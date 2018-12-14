package com.htb.stage;

import com.htb.game.Assets;
import com.htb.game.KillTheSpider;
import com.htb.object.MyActor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class GameoverScreen extends GameScreen {
	
	Label startLabel;
	public static Texture infoScreen;
	public static MyActor background;
	
	public GameoverScreen(KillTheSpider g) {
		super(g);
		create();
	}

	
	public void create(){
	    infoScreen = new Texture("images/gameoverScreen.jpeg");
		background = new MyActor();
		background.setTexture(infoScreen);
		background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
		mainStage.addActor(background);
			
	}
	
	public void update(float dt){
		Assets.backgroundMusic.stop();
		Assets.levelTwoMusic.stop();
		Assets.levelThreeMusic.stop();
		Assets.startScreenBGMusic.play();
		if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)){
			game.getScreen().pause();
			game.restart();
		}
	}
}