package htb.object;

import htb.game.Assets;


public class Tank extends MyActor {
	
	public int lives = 5;
	public int score = 0;
	
	boolean alive = true;
	
	public Tank(){
		super();
		this.setTexture(Assets.tank);
		float width = getWidth();
		float height = getHeight();
		
		//We will change the width keeping aspect ratio same.
		setWidth(200);
		setHeight(200*height/width);
		
	} 
	
	public void addScore(int scored){
		score += scored;
	}
	
	
	public void removeScore(int remove){
		score -= remove;
	}
	
	
	public void removeLife(){
		lives -= 1;
		if (lives == 0) alive = false;
	}
	
	public void addLife(){
		lives += 1;
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
