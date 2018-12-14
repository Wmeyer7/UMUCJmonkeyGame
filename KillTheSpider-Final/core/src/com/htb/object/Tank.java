package com.htb.object;

import com.htb.game.Assets;


public class Tank extends MyActor {
	
	public Live lives = new Live();
	public int numLives = 5;
	public int score = 0;
	public int addLiveAtScore  = 500; //A live is added whenever player achieves this many scores
	public boolean alive = true;
	public int size = 225;
	
	public Tank(){
		super();
		this.setTexture(Assets.tank);
		lives.lives = numLives;
		
				
		float width = getWidth();
		float height = getHeight();
		
		//We will change the width keeping aspect ratio same.
		setWidth(size);
		setHeight(size*height/width);
		
	} 
	
	public void addScore(int scored){
		
		score += scored;
		if (score%addLiveAtScore == 0)
		{ 
			//Add a live
			//Note: We can play a sound here when the live is increased.
			addLife();
			System.out.println("added a life");
		}
	}
	
	
	public void removeScore(int remove){
		score -= remove;
	}
	
	
	public void removeLife(){
		lives.lives -=1;
		
		if (lives.lives == 0) alive = false;
	}
	
	public void addLife(){
		lives.lives += 1;
		Assets.newLife.play();
		//TO DO: We can add a sound of 1UP here.
	}
	
	
	/**
	 * Fires the bullet
	 */
	public Bullet fireBullet(){
		float angle = getRotation();
		//The bullet will be fired from the center of the screen for now... 
		Bullet bullet = new Bullet();
		
		//We must fire the bullet from the end of the tank gun.
		float errorX = -10;
		float errorY = -15;
		float bulletX = (float) (getX() + getOriginX() + getWidth()/2 * Math.cos(angle*Math.PI/180)) + errorX;
		float bulletY = (float) (getY()  + getOriginY()+ getWidth()/2 * Math.sin(angle*Math.PI/180) + errorY) ; 
		bullet.setX(bulletX);
		bullet.setY(bulletY);
		bullet.setAngle(angle);
		
		return bullet;
		
	}
}
