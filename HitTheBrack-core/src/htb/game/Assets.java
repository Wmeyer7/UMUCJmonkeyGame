package htb.game;

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
	public static Music winMusic;					//To be played when the game is won
	public static Sound bulletFired;				//To be played when a bullet is fired.
	public static Sound bulletHitsWeakBrick;	    //To be played when a weak brick hit and player gains score!!
	public static Sound bulletHitsStrongBrick;		//To be played when a strong brick is hit, and player loses score.
	
	//Declare the Texture to be used in the game.
	public static Texture tank;
	public static Texture damagedTank;
	public static Texture strongBrick;
	public static Texture weakBrick;
	public static Texture bullet;
	public static Texture background;
	
	//Declare the texture lists
	public static Texture[] redSpider;
	public static Texture[] normalSpider;
	
	
	
	
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
		
		//Initialize the textures list
		redSpider = new Texture[6];
		normalSpider = new Texture[6];
		
		//Initialize Music
		startScreenBGMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/MusicPlaceholder2.mp3"));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/MusicPlaceholder3.mp3"));
		winMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/CrowdCheer.mp3"));
		
		//Initialize SFX
		buttonPressedSound = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/BlockDeathPH.wav"));
		bulletFired = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/PlayerDeathPH.wav"));
		bulletHitsWeakBrick = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/WrongBlockPH.wav"));
		bulletHitsStrongBrick = Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/PewPewPH.wav"));
		
		
		for (int i=1; i<=6; i++){
			redSpider[i-1] = new Texture(Gdx.files.internal("images/redSpider" + i+".png"));
			normalSpider[i-1] = new Texture(Gdx.files.internal("images/normalSpider" + i+".png"));
		}
		
		
		
	}
}
