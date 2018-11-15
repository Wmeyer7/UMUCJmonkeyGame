package htb.object;

import htb.game.Assets;

public class Brick extends MyActor {
	
	boolean weakBrick;
	
	/**
	 * Brick at position x, y and size sizeX , sizeY
	 * @param x
	 * @param y
	 * @param sizeX
	 * @param sizeY
	 */
	public Brick(float x, float y, float sizeX, float sizeY){
		super();
		setBounds(x, y, sizeX, sizeY);
		setTexture(Assets.strongBrick);
		setWidth(sizeX);
		setHeight(sizeY);
	}
	
	public void changeBrickCharacter(){
		if (weakBrick){
			setTexture(Assets.strongBrick);
		}
		else{
			setTexture(Assets.weakBrick);
		}
		weakBrick = !weakBrick;
	}
	
	public boolean collisionWithBullet(){
		if (weakBrick) {
			setVisible(false);
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public void explodeBrick(){
	
	}
	
}
