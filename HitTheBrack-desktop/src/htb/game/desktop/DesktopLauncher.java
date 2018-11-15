package htb.game.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import htb.game.KillTheSpider;

public class DesktopLauncher  {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.width = 480;
		config.height = 640;
		new LwjglApplication(new KillTheSpider(), config);
		}
}
