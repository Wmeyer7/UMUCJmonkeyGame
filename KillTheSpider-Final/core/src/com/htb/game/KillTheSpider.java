package com.htb.game;

import com.htb.stage.*;

import com.badlogic.gdx.Game;



/**
 * The class is the most important class of the game and its used to run the game.
 * @author Mandy
 *
 */
public class KillTheSpider extends Game {	
	
	public GameScreen titleScreen;
	public GameScreen infoScreen;
	public GameScreen playScreen;
	public GameScreen pauseScreen;
	public GameScreen gameoverScreen;
	public GameScreen winScreen;
	public GameScreen lastScreen; //It stores the last screen that game had. Useful to switch back to last state on exiting a state.
	
	public void create () {
		Assets asset = new Assets();
		titleScreen = new TitleScreen(this);
		infoScreen = new InfoScreen(this);
		playScreen = new PlayScreen(this);
		pauseScreen = new PauseScreen(this);
		gameoverScreen = new GameoverScreen(this);
		winScreen = new WinScreen(this);
		setScreen(titleScreen);	
		lastScreen = titleScreen;
	}
	
	public void restart(){
		playScreen = new PlayScreen(this);
		setScreen(titleScreen);	
	}

}
