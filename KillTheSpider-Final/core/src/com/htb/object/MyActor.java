package com.htb.object;



import java.util.Random;

import com.htb.game.Assets;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;

public class MyActor extends Actor
{
	
	public Texture[] frames;
	public float animationFPS;
	public float time; 			//A timer for animation
	public int currentFrame = new Random().nextInt(5);
	public boolean animated = false;
	public TextureRegion region;
	public Rectangle bound;
	public float velX;
	public float velY;
	float sizeX, sizeY;
	
	public MyActor()
	{
		super();
		region = new TextureRegion();
		bound = new Rectangle();
		velX = 0;
		velY = 0;
	}
	
	public void setTexture(Texture t)
	{
		int w = t.getWidth();
		int h = t.getHeight();
		setWidth( w);
		setHeight( h );
		region.setRegion(t);
	}
	
	public void setTexture(Texture t, boolean keepSize)
	{	if (!keepSize){
			int w = t.getWidth();
			int h = t.getHeight();
			setWidth( w);
			setHeight( h );
		}
		setWidth(sizeX);
		setHeight(sizeY);
		region.setRegion(t);
	}
	
	
	public void setTexture(Texture frames[], boolean keepSize, boolean startAtRandomFrame){
		if (!startAtRandomFrame) currentFrame = 0;
		this.frames = frames;
		setTexture(frames[currentFrame], keepSize);
	}
	
	public Rectangle getBoundingRectangle()
	{
		bound.set( getX(), getY(), getWidth(), getHeight()
		);
		return bound;
	}
	

	
	public void act(float dt){
		super.act( dt );
		moveBy( velX * dt, velY * dt );
		
		if (animated){
			time += dt;
			if (time>1f/animationFPS){
				time = 0;
				currentFrame++;
				if (currentFrame == frames.length) currentFrame = 0;
				setTexture(frames[currentFrame], true);
			}
		}
	}
	
	public void draw(Batch batch, float parentAlpha)
	{
		Color c = getColor();
		batch.setColor(c.r, c.g, c.b, c.a);
		
		if (isVisible())
		batch.draw( region, getX(), getY(), getOriginX(),getOriginY(),getWidth(), getHeight(), getScaleX(),
				getScaleY(), getRotation());
	}
	}