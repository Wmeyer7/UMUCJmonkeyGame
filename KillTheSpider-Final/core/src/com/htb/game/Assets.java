package com.htb.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

/**
 * The class is used to load all static assets that we would be using in the game like
 * sounds, bricks pictures, tank picture... etc. 
 * @author Mandy
 *
 */
public class Assets {
	
	public static Music startScreenBGMusic; 		//To be looped on the start screen.
	public static Sound buttonPressedSound;         //To be played when a button is pressed for Pause, Resume, Info... etc
	public static Music backgroundMusic;			//To be played while game is being played.
	public static Music levelTwoMusic;
	public static Music levelThreeMusic;
	public static Music tickTock;
	public static Music winMusic;					//To be played when the game is won
	public static Sound bulletFired;				//To be played when a bullet is fired.
	public static Sound bulletHitsWeakBrick;	    //To be played when a weak brick hit and player gains score!!
	public static Sound bulletHitsStrongBrick;		//To be played when a strong brick is hit, and player loses score.
	public static Sound playerDeath;
	public static Sound newLife;
	
	//Declare the Texture to be used in the game.
	public static Texture tank;
	public static Texture damagedTank;
	public static Texture strongBrick;
	public static Texture weakBrick;
	public static Texture bullet;
	public static Texture background;
	public static Texture title; //title of the game
	public static Texture scoreTitle; //title of the game
	
	//Declare the texture lists
	public static Texture[] redSpider;
	public static Texture[] normalSpider;
	public static Texture[] stopWatch;
	
	
	public static BitmapFont font;
	
	
	public Assets(){
		
		font = new BitmapFont(Gdx.files.internal("font/font45.fnt")); //Generate the default Font
		
		//Initialize the Textures
		tank = new Texture(Gdx.files.internal("images/tank.png"));
		damagedTank = new Texture(Gdx.files.internal("images/damagedTank.png"));
		strongBrick = new Texture(Gdx.files.internal("images/brick.jpeg"));
		weakBrick = new Texture(Gdx.files.internal("images/redBrick.png"));
		bullet = new Texture(Gdx.files.internal("images/fireball.png"));
		background = new Texture(Gdx.files.internal("images/fullBG.jpeg"));
		title = new Texture(Gdx.files.internal("images/title.png"));
		scoreTitle = new Texture(Gdx.files.internal("images/scoreTitle.png"));
		
		//Initialize the textures list
		redSpider = new Texture[6];
		normalSpider = new Texture[6];
		stopWatch = new Texture[11];
		
		//Initialize Music
		startScreenBGMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/umucgamespaceINTRO.ogg"));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/umucgamespaceLevel1.ogg"));
		levelTwoMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/umucgamespaceLevel2.ogg"));
		levelThreeMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/umucgamespaceLevel3.ogg"));
		winMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/CrowdCheer.ogg"));
		tickTock = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/GoFast.ogg"));
		
		//Initialize SFX
		buttonPressedSound = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/BlockDeathPH.ogg"));
		bulletFired = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/PlayerDeathPH.ogg"));
		bulletHitsWeakBrick = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/SpiderScream.ogg"));
		bulletHitsStrongBrick = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/WrongSpider.ogg"));
		playerDeath = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/Death.ogg"));
		newLife = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/NewLife.ogg"));
		
		for (int i=1; i<=6; i++){
			redSpider[i-1] = new Texture(Gdx.files.internal("images/redSpider" + i+".png"));
			normalSpider[i-1] = new Texture(Gdx.files.internal("images/normalSpider" + i+".png"));
		}
		
		for (int i=0; i<=10; i++){
			stopWatch[i] = new Texture(Gdx.files.internal("images/stopwatch/stopwatch_" + i+".jpg"));
		}
		
		
		
		
		
		
		
	}
}
