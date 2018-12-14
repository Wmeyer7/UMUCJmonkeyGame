package com.htb.object;

import java.util.Random;

import com.htb.game.Assets;
import com.htb.stage.PlayScreen;


public class Spider extends MyActor{
	
	boolean redSpider;
	float x, y;
	public boolean alive = true;
	
	/**
	 * Create Spider at position x, y of size sizeX , sizeY
	 * @param x
	 * @param y
	 * @param sizeX
	 * @param sizeY
	 */
	public Spider(float x, float y, float sizeX, float sizeY){
		super();
		animated = true;
		animationFPS = new Random().nextInt(2) + 3;
		this.x = x;
		this.y = y;
		super.sizeX = sizeX;
		super.sizeY = sizeY;
		setBounds(x, y, sizeX, sizeY);
		setWidth(sizeX);
		setHeight(sizeY);
		setTexture(Assets.normalSpider, true,true);

	}
	
	public void changeSpiderCharacter(){
		if (redSpider){
			setTexture(Assets.normalSpider, true, true);
		}
		else{
			setTexture(Assets.redSpider, true, true);
		}
		redSpider = !redSpider;
	}
	
	public boolean collisionWithBullet(){
		if (redSpider) {
			//Successfully killed
			alive = false;
			setVisible(false);
			return true;
		}
		else {
			return false;
		}
	}
	

	
}