package de.curlse.knechterpong.old;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Knechterpong extends ApplicationAdapter {

	public static boolean DEBUG = true;

	private World world;
	private SpriteBatch batch;
	private List<Renderable> objects;
	private OrthographicCamera camera;
	private Box2DDebugRenderer debugRenderer;
	private int width = (int) (128 * 1.2);
	private int height = (int) (72 * 1.2);
	private boolean running = true;
	private Ball ball;
	private Paddle leftPad;
	private Paddle rightPad;
	private PainManager painManager;

	@Override
	public void create() {

		// inits
		world = new World(new Vector2(0, 0), true);
		batch = new SpriteBatch();
		objects = new ArrayList<Renderable>();
		camera = new OrthographicCamera(width, height);
		painManager = new PainManager(5);
		world.setContactListener(painManager);

		// objects
		ball = new Ball(world, width, height);
		Arena arena = new Arena(world, width, height);
		leftPad = new Paddle(world, width, height, true);
		rightPad = new Paddle(world, width, height, false);

		objects.add(ball);
		objects.add(leftPad);
		objects.add(rightPad);

		// debug
		debugRenderer = new Box2DDebugRenderer();

	}

	@Override
	public void render() {

		// Clear
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Game
		if (running) {

			// Input
			pollInput();

			// Render
			batch.begin();
			objects.forEach(o -> o.render(batch));
			batch.end();

			// Box2d
			world.step(1 / 60f, 6, 2);
			if (Knechterpong.DEBUG)
				debugRenderer.render(world, camera.combined);

		}

	}

	public void pollInput() {

		// Escape
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}

	}
}
