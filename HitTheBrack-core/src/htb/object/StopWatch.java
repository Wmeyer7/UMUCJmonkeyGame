package htb.object;

import htb.game.Assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class StopWatch {
	
	float time;
	public int seconds;
	public Label label;
	public boolean running;
	public String name;
	LabelStyle style = new LabelStyle(Assets.font, Color.WHITE);
	
	public StopWatch(String name, int sec){
		this.name = name;
		time = 0;
		seconds = sec;
		label = new Label("Time: "+ sec, style);
	}
	
	public void update(float dt){
		if (running){
			time += dt;
			if (time>=1){
				seconds -= 1;
				label.setText(name+ seconds);
				time = time%1;
			}
		}
		
		
	}
	
	public void reset(int sec){
		seconds = sec;
		time = 0;
		running = true;
	}
	
	
}
