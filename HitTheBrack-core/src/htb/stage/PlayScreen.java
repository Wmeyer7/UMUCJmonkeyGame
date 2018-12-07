package htb.stage;

import java.util.ArrayList;
import java.util.Random;

import htb.game.Assets;
import htb.game.KillTheSpider;
import htb.object.Spider;
import htb.object.Bullet;
import htb.object.MyActor;
import htb.object.Spider;
import htb.object.StopWatch;
import htb.object.Tank;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen extends GameScreen {
	
	Label score, lives, stopWatch;
	int scoreValue = 0;
	public boolean paused;
	Tank player;
	public static ArrayList<Spider> spiderList;
	public static ArrayList<Bullet> bulletList;
	public static MyActor background;
	public int numspidersX = 10, numspidersY=10;
	
	public int currentLevel = 1;
	
	public float redTimer = 5;
	
	public StopWatch stopwatch;
	public StopWatch delayer;
	
	public Spider chosenSpider;
	
	public PlayScreen(KillTheSpider g) {
		super(g);
		create();
	}
	
	
	
	public void create(){
		//Initialize variables
		spiderList = new ArrayList<Spider>();
		bulletList = new ArrayList<Bullet>();
		//Initialize the Background
		background = new MyActor();
		background.setTexture(new Texture("images/fullBG.jpeg"));
		background.setBounds(0, 0, mainStage.getWidth(), mainStage.getHeight());
		
		//Add the actors to the mainStage
		mainStage.addActor(background);
		
		// Initialize the Tank player
		player = new Tank();
		player.setX((uiStage.getWidth()-player.getWidth())/2);
		player.setY((uiStage.getHeight()-player.getHeight())/2);
		player.setOrigin(player.getWidth()/2, player.getHeight()/2);
		//Add the actors to UI Stage
		uiStage.addActor(player);
		
		//Add the spiders to the uiStage
		addspiders();
		
		//Add the score and lives labels
		LabelStyle style = new LabelStyle(Assets.font, Color.WHITE);
		score = new Label("Score:0", style);
		lives = new Label("Lives:5", style);
		
		score.setPosition(mainStage.getWidth()*0.05f, 100);
		lives.setPosition(mainStage.getWidth()*0.3f, 100);
		
		delayer = new StopWatch("Delay: ", 3); //Delays the things!!
		delayer.running = true;
		stopwatch = new StopWatch("Time: ", 5);
		stopwatch.label.setPosition(mainStage.getWidth()*0.5f, 100);
		delayer.label.setPosition(mainStage.getWidth()*0.7f, 100);
		
		mainStage.addActor(score);
		mainStage.addActor(lives);
		mainStage.addActor(stopwatch.label); //Label of stop watch
		mainStage.addActor(delayer.label); //Label of delayer
		
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		Assets.backgroundMusic.dispose();
		Assets.bulletFired.dispose();
		Assets.bulletHitsStrongBrick.dispose();
		Assets.bulletHitsWeakBrick.dispose();
		Assets.buttonPressedSound.dispose();
	}
	
	public void addspiders(){
		
		System.out.println("Width is " + uiStage.getWidth() + " and the height is " + uiStage.getHeight());
		
		int[] yCoords = {1100, 1100, 1100, 1100, 1100, 1100, 1100, 1100, 160, 160, 160, 160, 160, 160, 160, 160, 
				250, 350, 450, 550, 650, 750, 850, 950, 250, 350, 450, 550, 650, 750, 850, 950,};
		int[] xCoords = {120, 210, 300, 390, 480, 570, 660, 750, 120, 210, 300, 390, 480, 570, 660, 750, 
				20, 20, 20, 20, 20, 20, 20, 20, 840, 840, 840, 840, 840, 840, 840, 840};
		
		float width = uiStage.getWidth();
		float height = uiStage.getHeight();
		
		float spiderWidth = width/10;
		float spiderHeight = height*0.8f/10;
		
		for (int i=0; i<32; i++) {
			Spider spider = new Spider(xCoords[i], yCoords[i], spiderWidth, spiderHeight);
			uiStage.addActor(spider);
			spiderList.add(spider);
		}
		
	}
	
	public void addSpiders2() {
		
		int[] yCoords = {150, 230, 310, 390, 470, 550, 630, 710, 790, 870, 950, 1030, 1030, 950, 870, 790, 710, 630, 550, 470, 390, 310, 230, 150};
		int[] xCoords = {380, 312, 244, 176, 108, 40, 40, 108, 176, 244, 312, 380, 480, 548, 616, 684, 752, 820, 820, 752, 684, 616, 548, 480};
		
		float width = uiStage.getWidth();
		float height = uiStage.getHeight();
		
		float spiderWidth = width/10;
		float spiderHeight = height*0.8f/10;
		
		for (int i=0; i<24; i++) {
			Spider spider = new Spider(xCoords[i], yCoords[i], spiderWidth, spiderHeight);
			uiStage.addActor(spider);
			spiderList.add(spider);
		}
		
	}
	
	public void addSpiders3() {
		int[] yCoords = {400, 370, 330, 290, 400, 370, 330, 290, 700, 680, 660, 640, 700, 680, 660, 640, 850, 950, 1050, 950, 1050, 300, 200, 200};
		int[] xCoords = {570, 670, 770, 870, 320, 220, 120, 20, 320, 220, 120, 20, 570, 670, 770, 870, 440, 370, 310, 510, 570, 440, 370, 510};
		
		float width = uiStage.getWidth();
		float height = uiStage.getHeight();
		
		float spiderWidth = width/12;
		float spiderHeight = height*0.8f/12;
		
		for (int i=0; i<24; i++) {
			Spider spider = new Spider(xCoords[i], yCoords[i], spiderWidth, spiderHeight);
			uiStage.addActor(spider);
			spiderList.add(spider);
		}
		
	}
	
	public void update(float dt){
		//Handle the key inputs
		handleKeys();
		checkCollision();
		
		delayer.update(dt);
		stopwatch.update(dt);
		if (delayer.running && delayer.seconds == 0) {
			//Start the stop watch and make a spider red!
			int randomSpiderIndex = new Random().nextInt(spiderList.size());
			chosenSpider = spiderList.get(randomSpiderIndex);
			chosenSpider.changeSpiderCharacter();//Change the spiders character
			stopwatch.reset(6);
			stopwatch.running = true;
			delayer.running = false;
			
		}
		if (stopwatch.running && stopwatch.seconds == 0){
			stopwatch.running = false;
			//By now the chosen spider must be killed, if not take a life.
			if (chosenSpider.alive){
				player.lives -= 1;
				if (player.lives == 0){
					pause();
					game.setScreen(game.gameoverScreen);
				}
				chosenSpider.changeSpiderCharacter();
				delayer.reset(3);
			}
			else{
				//If the spider is killed!
			}
		}
		
		score.setText("Score: "+ player.score);
		lives.setText("Lives: "+ player.lives);
	}
	
	public void checkCollision(){
		ArrayList<Spider> spiderToBeRemoved = new ArrayList<Spider>();
		ArrayList<Bullet> bulletToBeRemoved = new ArrayList<Bullet>();
		for (Bullet bullet:bulletList){
			for (Spider spider:spiderList){
				spider.getBoundingRectangle();
				bullet.getBoundingRectangle();
				if (spider.bound.overlaps(bullet.bound)){
					//Collision detected! Destroy bullet and spider

					bulletToBeRemoved.add(bullet);
					bullet.remove();
					boolean success = spider.collisionWithBullet();
					if (success){
						Assets.bulletHitsWeakBrick.play();
						delayer.reset(3);
						stopwatch.reset(6);
						stopwatch.running = false;
						player.score += 100;
						spider.remove();
						spiderToBeRemoved.add(spider);
					}
					else{
						Assets.bulletHitsStrongBrick.play();
						player.lives -= 1;
						if (player.lives == 0){
							pause();
							game.setScreen(game.gameoverScreen);
							Assets.backgroundMusic.stop();
							Assets.startScreenBGMusic.play();
						}
					}
					
					//If a bullet has collided with some spider, then there is no need to check more 
					//collisions, and loop must be broken
					break;
				}
			}
		}
		bulletList.removeAll(bulletToBeRemoved);
		spiderList.removeAll(spiderToBeRemoved);
		
		if ((spiderList.size() == 0) && (currentLevel == 3)) {
			pause();
			game.setScreen(game.winScreen);
			Assets.backgroundMusic.stop();
			Assets.winMusic.play();
		} else if (spiderList.size() == 0) {
			currentLevel++;
			if (currentLevel == 2) {
				addSpiders2();
			} else if (currentLevel == 3) {
				addSpiders3();
			}
		}
	}
	
	public void handleKeys(){
		if (Gdx.input.isKeyJustPressed(Keys.P)){
			Assets.buttonPressedSound.play(0.1f);
			paused = !paused;
			game.playScreen.pause();
			game.lastScreen = game.playScreen;
			game.setScreen(game.pauseScreen);
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.RIGHT) ) {
			player.setRotation(player.getRotation() + 1f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.RIGHT) && Gdx.input.isKeyPressed(Keys.X)){ //Speeded rotation
			player.setRotation(player.getRotation() + 3f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT) && !Gdx.input.isKeyPressed(Keys.LEFT) ) {
			player.setRotation(player.getRotation() - 1f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT) && !Gdx.input.isKeyPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.X)){ //Speeded rotation
			player.setRotation(player.getRotation() - 3f);
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)){
			//Bullet is fired!
			Assets.bulletFired.play();
			Bullet bullet = player.fireBullet();
			bulletList.add(bullet);
			uiStage.addActor(bullet);
		}

		if (Gdx.input.isKeyJustPressed(Keys.I)){
			Assets.buttonPressedSound.play(0.1f);
			game.getScreen().pause();
			game.setScreen(game.infoScreen);
			game.lastScreen = game.playScreen;
		}
		

		if (Gdx.input.isKeyJustPressed(Keys.Q)){
			Assets.buttonPressedSound.play(0.1f);
			game.getScreen().pause();
			game.restart();
			
		}
		
		
		
		
	}
	
	
}
