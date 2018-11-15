package htb.object;

import htb.game.Assets;

public class Bullet extends MyActor {
	
	boolean alive;
	int speed  = 1000;
	float angle;
	float vx, vy;
	
	public Bullet(){
		super();
		setTexture(Assets.bullet);
		angle = 0;
		setX(0);
		setY(0);
		setWidth(25);
		setHeight(25);
		
	}
	public Bullet(float x, float y, float angle){
		super();
		setTexture(Assets.bullet);
		setX(x);
		setY(y);
		setWidth(20);
		setHeight(20);
		setAngle(angle);
		
	}
	
	public void setAngle(float angle){
		this.angle = angle;
		vx = (float) Math.cos(angle*Math.PI/180.0)*speed;
		vy = (float) Math.sin(angle*Math.PI/180.0)*speed;
	}

	public void destroy(){
		setVisible(false);
		alive = false;
	}
	
	/**
	 * Updates the position of bullet on the basis of its speed.
	 * @param dt
	 */
	public void act(float dt){
		
		//We need to calculate the change in x and y depending upon the value of dt and the angle.
		float dx = (float) vx*dt;
		float dy = (float) vy*dt;
		setX(getX() + dx);
		setY(getY() + dy);
		
	}
	
	
	
	
}
