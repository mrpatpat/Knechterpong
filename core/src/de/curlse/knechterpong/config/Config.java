package de.curlse.knechterpong.config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Config {

	public static final String TITLE = "Ein Pong sie alle zu knechten";

	public static final int RESOLUTION_WIDTH = Gdx.graphics.getDesktopDisplayMode().width;
	public static final int RESOLUTION_HEIGHT = Gdx.graphics.getDesktopDisplayMode().height;
	public static final boolean FULLSCREEN = false;
	public static final boolean RESIZABLE = false;
	public static final boolean DEBUG = false;
	public static final boolean RENDER = true;

	public static final int VIEWPORT_WIDTH = 16;
	public static final int VIEWPORT_HEIGHT = 9;

	public static final float TIME_STEP = 1 / 300f;

	public static final float WORLD_TO_SCREEN = 1;

	public static final String WALL_TEXTURE_PATH = "wall.jpg";

	public static final float TOPWALL_X = VIEWPORT_WIDTH / 2f;
	public static final float TOPWALL_Y = VIEWPORT_HEIGHT -0.25f;
	public static final float TOPWALL_WIDTH = VIEWPORT_WIDTH+1;
	public static final float TOPWALL_HEIGHT = 0.5f;

	public static final float BOTTOMWALL_X = VIEWPORT_WIDTH / 2f;
	public static final float BOTTOMWALL_Y = 0.25f;
	public static final float BOTTOMWALL_WIDTH = VIEWPORT_WIDTH+1;
	public static final float BOTTOMWALL_HEIGHT = 0.5f;

	public static final float BALL_X = VIEWPORT_WIDTH / 2f;
	public static final float BALL_Y = VIEWPORT_HEIGHT / 2f;
	public static final float BALL_RADIUS = 0.2f;
	public static final float BALL_MAX_SPEED = 20.0f; 
	public static final float BALL_MIN_SPEED = 3.0f;
	public static final float BALL_ACCELERATION = 0.3f;
	public static final String BALL_TEXTURE_PATH = "plasmaBall.jpg";

	public static final float LEFTPADDLE_X = 1;
	public static final float RIGHTPADDLE_X = VIEWPORT_WIDTH - 1;
	public static final float PADDLE_WIDTH = 0.25f;
	public static final float PADDLE_HEIGHT = 2;
	public static final float PADDLE_SPEED = 20f;
	public static final float PADDLE_MIN_Y = PADDLE_HEIGHT / 2 + BOTTOMWALL_HEIGHT / 2 +0.25f;
	public static final float PADDLE_MAX_Y = VIEWPORT_HEIGHT - PADDLE_HEIGHT / 2 - TOPWALL_HEIGHT / 2 -0.25f;
	public static final String PADDLE_TEXTURE_PATH = "metalPlate.jpg";
	
	public static final float PADDLE_Y = VIEWPORT_HEIGHT / 2f;

	public static final int DEFAULT_CONTROL_LEFT_UP = Keys.W;
	public static final int DEFAULT_CONTROL_LEFT_DOWN = Keys.S;
	public static final int DEFAULT_CONTROL_LEFT_MENU = Keys.ESCAPE;

	public static final int DEFAULT_CONTROL_RIGHT_UP = Keys.UP;
	public static final int DEFAULT_CONTROL_RIGHT_DOWN = Keys.DOWN;
	public static final int DEFAULT_CONTROL_RIGHT_MENU = Keys.ESCAPE;

	public static final int PAINBOX_COUNT = 5;
	public static final float PAINBOX_HEIGHT = 1.5f;
	public static final float PAINBOX_WIDTH = 0.1f;
	public static final float PAINBOX_LEFT_X = 0.25f;
	public static final float PAINBOX_RIGHT_X = VIEWPORT_WIDTH - 0.25f;
	public static final float[] PAINBOX_Y = { 0, 1.6f, 3.2f, 4.8f, 6.4f };

	public static final String FLOOR_TEXTURE_PATH = "floor.jpg";
	public static final float FLOOR_SCALE = 0.003f;

	public static final float PADDLE_INFLUENCE_ON_BALL = 0.01f;

	public static final float BALL_MAX_ANGLE = 40;

	public static final int BALL_MIN_ANGLE = 10;

	
}
