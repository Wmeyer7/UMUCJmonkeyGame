package com.htb.stage;



import com.htb.game.Assets;
import com.htb.game.KillTheSpider;
import com.htb.object.MyActor;
import com.htb.object.Tank;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;


public class TitleScreen extends GameScreen {
	
	Label startLabel;
	float time; 		//It is used to store the current time elapsed since last switching of background
	float animationTime = 1; //Animation time is the time after which the background will be switched to other texture.
	public static Texture titleScreenFirst;
	public static Texture titleScreenSecond;
	int bgIndex;
	
	public static MyActor background; //Refers to either titleScreenFirst or titleScreenSecond
	
	public TitleScreen(KillTheSpider g) {
		super(g);
		create();
		
	}
	
	public void create(){
		titleScreenFirst = new Texture("images/titleScreenFirst.jpeg");
		titleScreenSecond = new Texture("images/titleScreenSecond.jpeg");
		bgIndex = 0;
		background = new MyActor();
		background.setTexture(titleScreenFirst);
		background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
		
		
		mainStage.addActor(background);
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		Assets.startScreenBGMusic.dispose();
		Assets.buttonPressedSound.dispose();
		Assets.backgroundMusic.dispose();
		Assets.levelTwoMusic.dispose();
		Assets.levelThreeMusic.dispose();
	}
	
	public void update(float dt){
		Assets.startScreenBGMusic.setLooping(true);
		Assets.startScreenBGMusic.setVolume(0.4f);
		Assets.startScreenBGMusic.play();
		Assets.backgroundMusic.stop();
		Assets.levelTwoMusic.stop();
		Assets.levelThreeMusic.stop();
		Assets.backgroundMusic.setLooping(true);
		Assets.backgroundMusic.setVolume(0.4f);
		
		if (time > animationTime){
			if (bgIndex == 0) {
				background.setTexture(titleScreenSecond); 
				background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
				bgIndex = 1;
		    }
			else {
				background.setTexture(titleScreenFirst); 
				background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
				bgIndex=0;
		    }
			time = 0;
		}
		time += dt;
		
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)){
			Assets.buttonPressedSound.play(0.1f);
			game.getScreen().pause();
			game.setScreen(game.playScreen);
			game.lastScreen = game.titleScreen;
			Assets.startScreenBGMusic.stop();
			Assets.backgroundMusic.play();
		
		}
		
		else if (Gdx.input.isKeyJustPressed(Keys.I)){
			Assets.buttonPressedSound.play(0.1f);
			game.getScreen().pause();
			game.setScreen(game.infoScreen);
			game.lastScreen = game.titleScreen;
			
		}
	}
	
	
	
}
