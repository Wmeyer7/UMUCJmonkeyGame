package com.htb.stage;

import com.htb.object.MyActor;
import com.htb.game.Assets;
import com.htb.game.KillTheSpider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class InfoScreen extends GameScreen {
	
	Label startLabel;
	public static Texture infoScreen;
	public static MyActor background;
	
	public InfoScreen(KillTheSpider g) {
		super(g);
		create();
	}

	
	public void create(){
	    infoScreen = new Texture("images/infoScreen.jpeg");
		background = new MyActor();
		background.setTexture(infoScreen);
		background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
		mainStage.addActor(background);
			
	}
	
	@Override
	public void dispose() {
		super.dispose();
		Assets.buttonPressedSound.dispose();
	}
	
	public void update(float dt){
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			Assets.buttonPressedSound.play(0.1f);
			game.getScreen().pause();
			game.setScreen(game.lastScreen);
			game.lastScreen = game.infoScreen;
		}
	}
}
