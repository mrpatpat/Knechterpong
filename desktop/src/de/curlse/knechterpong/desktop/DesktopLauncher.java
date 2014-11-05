package de.curlse.knechterpong.desktop;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.curlse.knechterpong.Knechterpong;
import de.curlse.knechterpong.config.Config;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

	
		new LwjglApplication(new Knechterpong(), config);
	}
}
