package de.curlse.knechterpong.stages;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import de.curlse.knechterpong.actors.BallActor;
import de.curlse.knechterpong.actors.FloorActor;
import de.curlse.knechterpong.actors.PaddleActor;
import de.curlse.knechterpong.actors.WallActor;
import de.curlse.knechterpong.box2d.UserDataType;
import de.curlse.knechterpong.config.Config;
import de.curlse.knechterpong.utils.ControlUtils;
import de.curlse.knechterpong.utils.WorldUtils;

public class GameStage extends Stage implements ContactListener {

	private World world;
	private OrthographicCamera camera;
	private float accumulator = 0f;
	private Box2DDebugRenderer renderer;

	private BallActor ball;
	private PaddleActor leftPaddle;
	private PaddleActor rightPaddle;

	List<ContactListener> contactListener;

	public GameStage() {
		super(new ScalingViewport(Scaling.stretch, Config.VIEWPORT_WIDTH, Config.VIEWPORT_HEIGHT, new OrthographicCamera(Config.VIEWPORT_WIDTH,
				Config.VIEWPORT_HEIGHT)));
		renderer = new Box2DDebugRenderer();
		contactListener = new ArrayList<ContactListener>();
		setUpCamera();
		setUpWorld();
		setUpPaddle(UserDataType.LEFTPADDLE);
		setUpPaddle(UserDataType.RIGHTPADDLE);
		setUpWall(UserDataType.TOPWALL);
		setUpWall(UserDataType.BOTTOMWALL);
		setUpBall();
		setUpControls();

		Gdx.graphics.setDisplayMode(Config.RESOLUTION_WIDTH, Config.RESOLUTION_HEIGHT, Config.FULLSCREEN);

	}

	private void setUpControls() {
		addActor(ControlUtils.getDefaultKeyBoardController(leftPaddle, true));
		addActor(ControlUtils.getDefaultKeyBoardController(rightPaddle, false));
	}

	private void setUpBall() {
		ball = new BallActor(WorldUtils.createBall(world));
		contactListener.add(ball);
		ball.setDirection(Math.random() >= 0.5f ? -1 : 1, (float) ((Math.random() >= 0.5f ? -1 : 1) * Math.random() * 2f));
		addActor(ball);
	}

	private void setUpPaddle(UserDataType type) {
		PaddleActor p = new PaddleActor(WorldUtils.createPaddle(world, type));

		if (p.getUserData().isLeft())
			leftPaddle = p;
		else
			rightPaddle = p;

		addActor(p);
	}

	private void setUpWall(UserDataType type) {
		WallActor w = new WallActor(WorldUtils.createWall(world, type));
		addActor(w);
	}

	private void setUpWorld() {
		world = WorldUtils.createWorld();
		WorldUtils.setCamera(camera);
		world.setContactListener(this);
	}

	private void setUpCamera() {
		this.camera = (OrthographicCamera) this.getCamera();
		camera.update();
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		accumulator += delta;
		while (accumulator >= delta) {
			world.step(Config.TIME_STEP, 6, 2);
			accumulator -= Config.TIME_STEP;
		}
	}

	@Override
	public void draw() {
		if(Config.RENDER)super.draw();
		if (Config.DEBUG)
			renderer.render(world, camera.combined);
	}

	@Override
	public void beginContact(Contact contact) {
		contactListener.forEach(o -> o.beginContact(contact));
	}

	@Override
	public void endContact(Contact contact) {
		contactListener.forEach(o -> o.endContact(contact));
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		contactListener.forEach(o -> o.preSolve(contact, oldManifold));
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		contactListener.forEach(o -> o.postSolve(contact, impulse));
	}

}
