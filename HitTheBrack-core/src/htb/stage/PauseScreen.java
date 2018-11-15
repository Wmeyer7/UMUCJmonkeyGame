package htb.stage;

import htb.game.Assets;
import htb.game.KillTheSpider;
import htb.object.MyActor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class PauseScreen extends GameScreen {
	
	Label startLabel;
	float time; 		//It is used to store the current time elapsed since last switching of background
	float animationTime = 0.3f; //Animation time is the time after which the background will be switched to other texture.
	public static Texture pauseScreenFirst;
	public static Texture pauseScreenSecond;
	int bgIndex;
	
	public static MyActor background;
	public PauseScreen(KillTheSpider g) {
		super(g);
		create();
	}

	
	public void create(){
	    pauseScreenFirst = new Texture("images/pauseScreenFirst.jpeg");
		pauseScreenSecond = new Texture("images/pauseScreenSecond.jpeg");
		bgIndex = 0;
		background = new MyActor();
		background.setTexture(pauseScreenFirst);
		background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
		
		mainStage.addActor(background);
			
	}
	
	public void update(float dt){
		
		if (time > animationTime){
			if (bgIndex == 0) {
				background.setTexture(pauseScreenSecond); 
				background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
				bgIndex = 1;
		    }
			else {
				background.setTexture(pauseScreenFirst); 
				background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
				bgIndex=0;
		    }
			time = 0;
		}
		time += dt;
		
		
		if (Gdx.input.isKeyJustPressed(Keys.P)){
			game.getScreen().pause();
			game.setScreen(game.playScreen);
			game.lastScreen = game.pauseScreen;
		
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.I)){
			game.getScreen().pause();
			game.setScreen(game.infoScreen);
			game.lastScreen = game.pauseScreen;
		}
	}
	}