package de.curlse.knechterpong.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import de.curlse.knechterpong.box2d.BallUserData;
import de.curlse.knechterpong.box2d.UserData;
import de.curlse.knechterpong.box2d.UserDataType;
import de.curlse.knechterpong.config.Config;
import de.curlse.knechterpong.utils.CollisionUtils;

public class BallActor extends GameActor implements ContactListener {

	private final TextureRegion textureRegion;
	private float speed = 0.0f;

	private boolean contactsWithPaddleEnabled = true;

	public BallActor(Body body) {
		super(body);
		textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Config.BALL_TEXTURE_PATH)));
		speed = Config.BALL_MIN_SPEED;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setDirection(float x, float y) {
		body.setLinearVelocity(x, y);
	}

	@Override
	public BallUserData getUserData() {
		return (BallUserData) userData;
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		if (body.getPosition().x < 0 - Config.BALL_RADIUS * 2) {
			body.setTransform(Config.VIEWPORT_WIDTH - Config.BALL_RADIUS * 2, body.getPosition().y, body.getAngle());
		}

		if (body.getPosition().x > Config.VIEWPORT_WIDTH + Config.BALL_RADIUS * 2) {
			body.setTransform(-Config.BALL_RADIUS * 2, body.getPosition().y, body.getAngle());
		}

		if (body.getPosition().x > Config.LEFTPADDLE_X + Config.PADDLE_WIDTH / 2 - 2 * Config.BALL_RADIUS
				&& body.getPosition().x < Config.RIGHTPADDLE_X - Config.PADDLE_WIDTH / 2 + 2 * Config.BALL_RADIUS) {
			this.contactsWithPaddleEnabled = true;
		}

		body.setLinearVelocity(new Vector2(body.getLinearVelocity().nor().x * speed, body.getLinearVelocity().nor().y * speed).clamp(Config.BALL_MIN_SPEED,
				Config.BALL_MAX_SPEED));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(textureRegion, screenRectangle.x, screenRectangle.y, screenRectangle.width, screenRectangle.width);
	}

	@Override
	public void beginContact(Contact contact) {

		float angle = this.body.getLinearVelocity().angle(new Vector2(1, 0));

		if (CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.TOPWALL)
				|| CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.BOTTOMWALL)
				|| CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.RIGHTPADDLE)) {
			if (angle >= 0) {
				if (angle >= 0 && angle <= Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(Config.BALL_MIN_ANGLE));

				if (angle <= 180 && angle >= 180 - Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(180 - Config.BALL_MIN_ANGLE));

				if (angle <= 90 && angle >= Config.BALL_MAX_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(Config.BALL_MAX_ANGLE));

				if (angle <= 180 - Config.BALL_MAX_ANGLE && angle > 90)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(180 - Config.BALL_MAX_ANGLE));
			} else

			if (angle < 0) {
				if (angle >= -180 && angle <= -180 + Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-180 + Config.BALL_MIN_ANGLE));

				if (angle <= 0 && angle >= -Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-Config.BALL_MAX_ANGLE));

				if (angle < -90 && angle >= -180 + Config.BALL_MAX_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-180 + Config.BALL_MAX_ANGLE));

				if (angle <= -Config.BALL_MAX_ANGLE && angle >= -90)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-Config.BALL_MAX_ANGLE));
			}
		}
		else
		//HOTFIX
		if (CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.LEFTPADDLE)) {
			if (angle >= 0) {
				if (angle >= 0 && angle <= Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(Config.BALL_MIN_ANGLE));

				if (angle <= 180 && angle >= 180 - Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(180 - Config.BALL_MIN_ANGLE));

				if (angle <= 90 && angle >= Config.BALL_MAX_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(Config.BALL_MAX_ANGLE));

//				if (angle <= 180 - Config.BALL_MAX_ANGLE && angle > 90)
					//this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(180 - Config.BALL_MAX_ANGLE));
			} else

			if (angle < 0) {
				if (angle >= -180 && angle <= -180 + Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-180 + Config.BALL_MIN_ANGLE));

				if (angle <= 0 && angle >= -Config.BALL_MIN_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-Config.BALL_MAX_ANGLE));

				if (angle < -90 && angle >= -180 + Config.BALL_MAX_ANGLE)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-180 + Config.BALL_MAX_ANGLE));

				if (angle <= -Config.BALL_MAX_ANGLE && angle >= -90)
					this.body.setLinearVelocity(this.body.getLinearVelocity().setAngle(-Config.BALL_MAX_ANGLE));
			}
		}

	}

	

	@Override
	public void endContact(Contact contact) {

		if (speed < Config.BALL_MAX_SPEED)
			speed += Config.BALL_ACCELERATION;

		// TODO: setBall to Paddle x coordinates after collision
		Fixture a = contact.getFixtureA();
		Fixture b = contact.getFixtureB();
		UserData aData = (UserData) a.getUserData();
		UserData bData = (UserData) b.getUserData();

		Body paddle = null;
		if ((aData.getUserDataType() == UserDataType.BALL) || (bData.getUserDataType() == UserDataType.BALL)) {
			if ((aData.getUserDataType() == UserDataType.LEFTPADDLE) || (aData.getUserDataType() == UserDataType.RIGHTPADDLE)) {
				paddle = a.getBody();
			} else if ((bData.getUserDataType() == UserDataType.RIGHTPADDLE) || (bData.getUserDataType() == UserDataType.LEFTPADDLE)) {
				paddle = b.getBody();
			}
		}
		if (paddle != null) {

			this.body.applyLinearImpulse(0, paddle.getLinearVelocity().y * Config.PADDLE_INFLUENCE_ON_BALL, contact.getWorldManifold().getPoints()[0].x,
					contact.getWorldManifold().getPoints()[0].x, true);

		}

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {

		Fixture a = contact.getFixtureA();
		Fixture b = contact.getFixtureB();

		if (this.contactsWithPaddleEnabled) {

			if (CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.LEFTPADDLE)) {

				if (a.getBody().getPosition().x > b.getBody().getPosition().x) {
					contact.setEnabled(false);
					this.contactsWithPaddleEnabled = false;
				}

			} else

			if (CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.RIGHTPADDLE)) {

				if (a.getBody().getPosition().x < b.getBody().getPosition().x) {
					contact.setEnabled(false);
					this.contactsWithPaddleEnabled = false;
				}

			} else {
				contact.setEnabled(true);
			}

		} else {

			if (CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.LEFTPADDLE)) {
				contact.setEnabled(false);
			} else

			if (CollisionUtils.collided(contact, UserDataType.BALL, UserDataType.RIGHTPADDLE)) {
				contact.setEnabled(false);
			} else {
				contact.setEnabled(true);
			}

		}

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {

	}

}
