package kodomosoft.net.mygdxgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CrazyBalls";
		cfg.width = 400;
		cfg.height = 800;
		cfg.resizable = false;
		
		new LwjglApplication(new CrazyBallsMain(), cfg);
	}
}
