package com.htb.object;

import com.htb.game.Assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class StopWatch  extends MyActor {
	
	float timeWatch;
	public int seconds;
	public Label label;
	public boolean running;
	public String name;
	LabelStyle style = new LabelStyle(Assets.font, Color.RED);
	

	public StopWatch(String name, int sec){
		super();
		animated= true;
		this.name = name;
		setTexture(Assets.stopWatch, true,false);
		sizeX = 100;
		sizeY = 100;
		timeWatch = 0;
		seconds = sec;
		//The animationFPS of the stopwatch is defined by the timeWatch it has in seconds.
		animationFPS = frames.length/sec;
		
		
	}
	
	public void updateStopwatch(float dt){
		if (running){
			timeWatch += dt;
			if (timeWatch>=1){
				seconds -= 1;
				//TO DO: We can play the sound here for the tick tock of stopwatch!!
				//TO DO: A check could be added that if less than two seconds are left then start a high pitched and more frequent sound.
				timeWatch = timeWatch%1;
			}
		}
		else{
			animated = false;
			setTexture(frames[0], true); //keep the size as previous
		}
		
	}
	
	public void reset(int sec){
		seconds = sec;
		timeWatch = 0;
		animationFPS = frames.length/sec;
		running = true;
		animated = true;
		currentFrame = 0;
	}
	

}
