package com.htb.object;

import com.htb.game.Assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/*
 * Actor to display the lives left for the tank.
 */
public class Live extends MyActor {	
	public int lives = 5;
	public Label livesLabel, livesAmount;
	public float width = 80;
	public int spacingX = 5;
	LabelStyle style = new LabelStyle(Assets.font, Color.CHARTREUSE);
	int counter;
	public Live(){
		
		super();
		setTexture(Assets.tank); //The texture is same as tank
		setWidth(width);
		float height = getHeight()/getHeight()*width; //Keep aspect ratio
		setHeight(height);
		//LabelStyle style = new LabelStyle(Assets.font, Color.CHARTREUSE);
		livesLabel = new Label("", style);
		
		
		
		
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		livesLabel.setText("x " + lives);//make sure that text updates
		livesLabel.setX(380);
		livesLabel.setY(80);
		
		Color c = getColor();
		batch.setColor(c.r, c.g, c.b, c.a);
		
		
		if (isVisible())
		{
			//System.out.println(lives);
			
			
			if (lives <= 5) {
			for (int i=0; i<lives; i++){
				//Draw the tank as many times as lives are there.
				batch.draw( region, getX() + /**livesLabel.getWidth()**/ + spacingX + i*(getWidth() + spacingX) , //This the total distant of tank from beginning of lives drawing
						getY(), getOriginX(),getOriginY(),getWidth(), getHeight(), getScaleX(),
						getScaleY(), getRotation());
					}
				}else if (lives > 5) {
					//System.out.println(lives);
					//Draw 1 tank
					batch.draw( region, getX() + spacingX + 1*(getWidth() + spacingX), //This the total distant of tank from beginning of lives drawing
							getY(), getOriginX(),getOriginY(),getWidth(), getHeight(), getScaleX(),
							getScaleY(), getRotation());
					//draw label
						livesLabel.draw(batch, parentAlpha);
			}
		}
	}
}
