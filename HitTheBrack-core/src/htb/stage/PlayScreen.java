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
	
	public void addspiders(){
		float width = uiStage.getWidth();
		float height = uiStage.getHeight();
		
		float spacingX = 20;
		float spacingY = 20;
		
		float spiderWidth = width /numspidersX - spacingX;
		float spiderHeight = height*0.8f/numspidersY - spacingY;
	
		float upperOffset = uiStage.getHeight()*0.07f;
		float lowerOffset =  uiStage.getHeight()*0.12f;
	
		//Create the upper horizontal line of spiders
		for (int i=0; i<numspidersX; i++){
			Spider spider = new Spider(i*(spiderWidth + spacingX),height - spiderHeight - upperOffset, spiderWidth, spiderHeight);
			uiStage.addActor(spider);
			spiderList.add(spider);
		}
		//Create the lower horizontal line of spiders
		for (int i=0; i<numspidersX; i++){
			Spider spider = new Spider(i*(spiderWidth + spacingX), lowerOffset, spiderWidth, spiderHeight);
			uiStage.addActor(spider);
			spiderList.add(spider);
		}
		
		//Create the left vertical line of spiders
		for (int i=0; i<numspidersY-2; i++){
			Spider spider = new Spider(spacingX,(i+1)*(spiderHeight+ spacingY) +lowerOffset, spiderWidth, spiderHeight);
			uiStage.addActor(spider);
			spiderList.add(spider);
		}
		//Create the right vertical line of spiders
				for (int i=0; i<numspidersY-2; i++){
					Spider spider = new Spider(width-spiderWidth+ spacingX,(i+1)*(spiderHeight+ spacingY) +lowerOffset, spiderWidth, spiderHeight);
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
						delayer.reset(3);
						stopwatch.reset(6);
						stopwatch.running = false;
						player.score += 100;
						spider.remove();
						spiderToBeRemoved.add(spider);
					}
					else{
						player.lives -= 1;
						if (player.lives == 0){
							pause();
							game.setScreen(game.gameoverScreen);
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
	}
	
	public void handleKeys(){
		if (Gdx.input.isKeyJustPressed(Keys.P)){
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
			Bullet bullet = player.fireBullet();
			bulletList.add(bullet);
			uiStage.addActor(bullet);
		}

		if (Gdx.input.isKeyJustPressed(Keys.I)){
			game.getScreen().pause();
			game.setScreen(game.infoScreen);
			game.lastScreen = game.playScreen;
		}
		

		if (Gdx.input.isKeyJustPressed(Keys.Q)){
			game.getScreen().pause();
			game.restart();
			
		}
		
		
		
		
	}
	
	
}