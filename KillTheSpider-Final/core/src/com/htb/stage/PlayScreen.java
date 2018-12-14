package com.htb.stage;

import java.util.ArrayList;
import java.util.Random;

import com.htb.object.Bullet;
import com.htb.object.Live;
import com.htb.object.MyActor;
import com.htb.object.Spider;
import com.htb.object.StopWatch;
import com.htb.object.Tank;

import com.htb.game.Assets;
import com.htb.game.KillTheSpider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen extends GameScreen {
	
	Label score, stopWatch, livesAmount;
	int scoreValue = 0;
	public boolean paused;
	Tank player;
	public static ArrayList<Spider> spiderList;
	public static ArrayList<Bullet> bulletList;
	public static MyActor background;
	public int numspidersXLevel1 = 7, numspidersYLevel1= 8;
	
	public int currentLevel = 1;
	
	public int difficultyMode = 1;
	public float redTimer = 5;
	
	public StopWatch stopwatch;
	public StopWatch delayer;
	
	public int stopwatchTime = 5;
	public int delayerTime = 3;
	public float levelOneMusicPos;
	public float levelTwoMusicPos;
	public float levelThreeMusicPos;
	public float tickTockPos;
	public Spider chosenSpider;
	public boolean isLastTen = false;
	
	
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
		
		//addSpiders2();
		
		//Add the score and lives labels
		LabelStyle style = new LabelStyle(Assets.font, Color.RED);
		score = new Label("0", style);
		livesAmount = new Label("x " + player.numLives, style);
		delayer = new StopWatch("Delay: ", delayerTime); //Delays the things!!
		delayer.running = true;
		stopwatch = new StopWatch("Time: ", stopwatchTime);
		
		//We will create a title name MyActor to show the title of the game
		MyActor title = new MyActor();
		title.setTexture(Assets.title);
		
		//We will create an actor for the Score
		MyActor scoreTitle = new MyActor();
		scoreTitle.setTexture(Assets.scoreTitle);
		
		Table scoreTable = new Table();
		scoreTable.add(scoreTitle);
		scoreTable.add(score).center().fill().padBottom(25).padLeft(10);
		
		Table table = new Table();
		table.setFillParent(true);
		
		table.pad(10);
		table.add(title).width(400).height(120);
		table.add().expandX();
		table.add(scoreTable);
		table.row();
		table.add().colspan(3).expandY();
		table.row();
		table.add(player.lives);
		table.add().expandX();
		table.add(stopwatch);
		mainStage.addActor(table);

		
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		Assets.backgroundMusic.dispose();
		Assets.bulletFired.dispose();
		Assets.bulletHitsStrongBrick.dispose();
		Assets.bulletHitsWeakBrick.dispose();
		Assets.buttonPressedSound.dispose();
		Assets.levelTwoMusic.dispose();
		Assets.levelThreeMusic.dispose();
		Assets.newLife.dispose();
		Assets.playerDeath.dispose();
	}
	
	public void addspiders(){
		
		float width = uiStage.getWidth();
		float height = uiStage.getHeight();
		
		
		int[] yCoords = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 200, 200, 200, 200, 200, 200, 200, 200};
		int[] xCoords = {120, 210, 300, 390, 480, 570, 660, 750, 120, 210, 300, 390, 480, 570, 660, 750 };
		
		float spiderWidth = width/10;
		float spiderHeight = height*0.8f/10;
		
		for (int i=0; i<16; i++) {
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
		delayer.updateStopwatch(dt);
		stopwatch.updateStopwatch(dt);
		
		if (delayer.running && delayer.seconds == 0) {
			//Start the stop watch and make a spider red!
			int randomSpiderIndex = new Random().nextInt(spiderList.size());
			chosenSpider = spiderList.get(randomSpiderIndex);
			chosenSpider.changeSpiderCharacter();//Change the spiders character
			stopwatch.reset(stopwatchTime);
			stopwatch.running = true;
			delayer.running = false;
			
		}
		if (stopwatch.running && stopwatch.seconds == 0){
			stopwatch.running = false;
			//By now the chosen spider must be killed, if not take a life.
			if (chosenSpider.alive){
				Assets.bulletHitsStrongBrick.play();
				player.removeLife();
				if (!player.alive){
					Assets.playerDeath.play();
					pause();
					game.setScreen(game.gameoverScreen);
				}
				chosenSpider.changeSpiderCharacter();
				delayer.reset(delayerTime);
			}
			else{
				//If the spider is killed!
			}
		}
		
		//If less than 10 spiders are left, then set the difficultyMode to 2!
		if (spiderList.size() <= 10 && isLastTen == false){
			isLastTen = true;
			difficultyMode = 2;
			stopwatchTime = 3; //Decrease the stopwatch time
			delayerTime = 2; //Decrease the delayer time
			//TO DO: We can stop the backgroundMusic and start the Tense BG music here.
			//System.out.println("Here is the problem");
			checkLastTen();
		}
		
		
		
		score.setText(""+ player.score);
	}
	public void checkLastTen() {
		if (isLastTen = true) {
			if(currentLevel == 1)
			System.out.println("Hurry up level 1");
			levelOneMusicPos = Assets.backgroundMusic.getPosition();
			Assets.tickTock.play();
			Assets.tickTock.setLooping(true);
			Assets.tickTock.setPosition(levelOneMusicPos  / 1.25f);
			Assets.tickTock.setVolume(.4f);
			Assets.backgroundMusic.stop();
		}
		if(currentLevel == 2) {
			System.out.println("Hurry up level 2");
			levelTwoMusicPos = Assets.levelTwoMusic.getPosition();
			Assets.tickTock.play();
			Assets.tickTock.setLooping(true);
			Assets.tickTock.setPosition(levelTwoMusicPos  / 1.25f);
			Assets.tickTock.setVolume(.4f);
			Assets.levelTwoMusic.stop();
		}
		if(currentLevel == 3) {
			System.out.println("Hurry up level 3");
			levelThreeMusicPos = Assets.levelThreeMusic.getPosition();
			Assets.tickTock.play();
			Assets.tickTock.setLooping(true);
			Assets.tickTock.setPosition(levelThreeMusicPos  / 1.25f);
			Assets.tickTock.setVolume(.4f);
			Assets.levelThreeMusic.stop();
			
		}
		return;
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
						Assets.bulletHitsWeakBrick.play(.5f);
						delayer.reset(delayerTime);
						stopwatch.reset(stopwatchTime);
						stopwatch.running = false;
						player.addScore(100);
						spider.remove();
						spiderToBeRemoved.add(spider);
					}
					else{
						Assets.bulletHitsStrongBrick.play();
						player.removeLife();
						if (!player.alive){
							Assets.playerDeath.play();
							pause();
							game.setScreen(game.gameoverScreen);
							Assets.tickTock.stop();
							Assets.backgroundMusic.stop();
							Assets.levelTwoMusic.stop();
							Assets.levelThreeMusic.stop();
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
			Assets.levelThreeMusic.stop();
			Assets.tickTock.stop();
			Assets.winMusic.play();
			Assets.startScreenBGMusic.play();
		}else if (spiderList.size() == 0) {
			currentLevel++;
			difficultyMode = 1;
			stopwatchTime = 5;
			delayerTime = 3;
			isLastTen = false;
			System.out.println(isLastTen);
			System.out.println(difficultyMode);
			
			 if (currentLevel == 2) {
				levelOneMusicPos = Assets.backgroundMusic.getPosition();
				tickTockPos = Assets.tickTock.getPosition();
				Assets.levelTwoMusic.play();
				Assets.levelTwoMusic.setLooping(true);
				Assets.levelTwoMusic.setVolume(.4f);
				Assets.levelTwoMusic.setPosition(tickTockPos * 1.25f);
				Assets.tickTock.stop();
				Assets.backgroundMusic.stop();
				System.out.println(tickTockPos);
				System.out.println(difficultyMode);
				System.out.println(stopwatchTime);
				

				addSpiders2();
			} else if (currentLevel == 3) {
				tickTockPos = Assets.tickTock.getPosition();
				levelTwoMusicPos = Assets.levelTwoMusic.getPosition();
				Assets.levelThreeMusic.play();
				Assets.levelThreeMusic.setLooping(true);
				Assets.levelThreeMusic.setVolume(.4f);
				Assets.levelThreeMusic.setPosition(tickTockPos * 1.25f);
				Assets.levelTwoMusic.stop();
				Assets.tickTock.stop();
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
