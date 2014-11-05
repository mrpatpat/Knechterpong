package de.curlse.knechterpong.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Box2DBuild;

import de.curlse.knechterpong.box2d.BallUserData;
import de.curlse.knechterpong.box2d.PaddleUserData;
import de.curlse.knechterpong.box2d.UserDataType;
import de.curlse.knechterpong.box2d.WallUserData;
import de.curlse.knechterpong.config.Config;

public class WorldUtils {

	public static OrthographicCamera camera;

	public static World createWorld() {
		return new World(new Vector2(0, 0), true);
	}

	public static Body createPaddle(World world, UserDataType type) {

		float x = 0;
		float y = 0;
		float w = 0;
		float h = 0;

		if (type == UserDataType.LEFTPADDLE) {
			x = Config.LEFTPADDLE_X;
			y = Config.PADDLE_Y;
			w = Config.PADDLE_WIDTH;
			h = Config.PADDLE_HEIGHT;
		} else if (type == UserDataType.RIGHTPADDLE) {
			x = Config.RIGHTPADDLE_X;
			y = Config.PADDLE_Y;
			w = Config.PADDLE_WIDTH;
			h = Config.PADDLE_HEIGHT;
		}

		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(new Vector2(x, y));
		Body body = world.createBody(bodyDef);
		body.setType(BodyType.KinematicBody);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(w / 2, h / 2);
		body.createFixture(shape, 1);
		PaddleUserData ud = new PaddleUserData(w, h, type);
		body.setUserData(ud);
		body.getFixtureList().get(0).setUserData(ud);
		shape.dispose();
		return body;

	}

	public static Body createBall(World world) {

		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(new Vector2(Config.BALL_X, Config.BALL_Y));
		Body body = world.createBody(bodyDef);
		body.setType(BodyType.DynamicBody);
		CircleShape shape = new CircleShape();
		shape.setRadius(Config.BALL_RADIUS);
		body.createFixture(shape, 1);
		body.getFixtureList().get(0).setFriction(0.0f);
		body.setAngularDamping(10);
		body.getFixtureList().get(0).setRestitution(1);
		BallUserData ud = new BallUserData(Config.BALL_RADIUS);
		body.setUserData(ud);
		body.getFixtureList().get(0).setUserData(ud);
		shape.dispose();
		return body;

	}

	public static Body createWall(World world, UserDataType type) {

		float x = 0;
		float y = 0;
		float w = 0;
		float h = 0;

		if (type == UserDataType.TOPWALL) {
			x = Config.TOPWALL_X;
			y = Config.TOPWALL_Y;
			w = Config.TOPWALL_WIDTH;
			h = Config.TOPWALL_HEIGHT;
		} else if (type == UserDataType.BOTTOMWALL) {
			x = Config.BOTTOMWALL_X;
			y = Config.BOTTOMWALL_Y;
			w = Config.BOTTOMWALL_WIDTH;
			h = Config.BOTTOMWALL_HEIGHT;
		}

		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(new Vector2(x, y));
		Body body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(w / 2, h / 2);
		body.createFixture(shape, 1);
		WallUserData ud = new WallUserData(w, h, type);
		body.setUserData(ud);
		body.getFixtureList().get(0).setUserData(ud);
		body.setUserData(new WallUserData(w, h, type));
		shape.dispose();
		return body;

	}

	public static void setCamera(OrthographicCamera camera) {
		WorldUtils.camera = camera;
	}
}
