package de.curlse.knechterpong.old;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Paddle implements Renderable {

	private BodyDef bodyDef;
	private Body body;
	private World world;
	private Fixture fixture;

	public Paddle(World world, int gameWidth, int gameHeight, boolean isLeft) {

		this.world = world;

		bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;

		if (isLeft)
			bodyDef.position.set(new Vector2(-gameWidth / 2 + gameWidth / 15, 0));
		else
			bodyDef.position.set(new Vector2(gameWidth / 2 - gameWidth / 15, 0));;
		body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(Math.min(gameWidth, gameHeight) / 75, gameHeight / 10);
		body.createFixture(shape, 0.0f);
		shape.dispose();

	}

	@Override
	public void render(SpriteBatch batch) {

	}

}
