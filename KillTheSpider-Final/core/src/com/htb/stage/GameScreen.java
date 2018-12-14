package com.htb.stage;

import com.htb.game.KillTheSpider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * The abstract class is implemented by any Screen in the HTB game.
 * @author hit
 *
 */
public abstract class GameScreen implements Screen, InputProcessor {

	protected Stage mainStage;
	protected Stage uiStage;
	protected KillTheSpider game;
	public final int viewWidth = 960;
	public final int viewHeight = 1280;
	private boolean paused;
	
	public GameScreen(KillTheSpider g) 
	{
	game = g;
	
	mainStage = new Stage( new FitViewport(viewWidth,
	viewHeight) );
	uiStage = new Stage( new FitViewport(viewWidth,
			viewHeight) );

	InputMultiplexer im = new InputMultiplexer(this, mainStage, uiStage); //Create a input multiplexer which forward the input events to all the stages and screen
	Gdx.input.setInputProcessor(im);

	this.create();
	}

	private void create() {
				
	}

	
	public void render(float dt) {
		uiStage.act(dt);
		if ( !paused )
		{
		mainStage.act(dt);
		update(dt);
		}
		
		//Render the screen
		Gdx.gl.glClearColor(1F,1F,1F,1F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mainStage.getViewport().apply();
		mainStage.draw();
		
		
		uiStage.getViewport().apply();
		uiStage.draw();
	}

	public void update(float dt){
	}
	
	public void resize(int width, int height) {
		
	}
	
	public void pause() {
	}
	
	public void resume() {
	}

	public void show() {
	}
	
	public void hide() {
	}
	
	public void dispose() {
	}
	
	public boolean keyDown(int keycode) {
		return false;
	}

	
	public boolean keyUp(int keycode) {
		return false;
	}

	
	public boolean keyTyped(char character) {
		return false;
	}

	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	
	public boolean scrolled(int amount) {
		return false;
	}


	

}
