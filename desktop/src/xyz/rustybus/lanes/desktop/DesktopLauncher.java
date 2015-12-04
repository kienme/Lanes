package xyz.rustybus.lanes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import xyz.rustybus.lanes.Lanes;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=(int)(800/1.5);
		config.width=(int)(480/1.5);
		new LwjglApplication(new Lanes(), config);
	}
}
