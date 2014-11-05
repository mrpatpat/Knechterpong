package de.curlse.knechterpong.old;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Ball implements Renderable {

	private BodyDef bodyDef;
	private Body body;
	private World world;
	private Fixture fixture;

	public Ball(World world, int gameWidth, int gameHeight) {

		this.world = world;

		bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(0, 0);

		body = this.world.createBody(bodyDef);

		CircleShape circle = new CircleShape();
		circle.setRadius(Math.min(gameWidth, gameHeight) / 75);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 1.0f;

		fixture = body.createFixture(fixtureDef);
		body.setUserData("ball");
		circle.dispose();

		body.setLinearVelocity(120, 0);

	}

	@Override
	public void render(SpriteBatch batch) {

	}

}
