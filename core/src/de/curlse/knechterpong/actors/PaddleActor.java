package de.curlse.knechterpong.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

import de.curlse.knechterpong.box2d.PaddleUserData;
import de.curlse.knechterpong.config.Config;

public class PaddleActor extends GameActor {

	private final TextureRegion textureRegion;

	private boolean movingUp = false;
	private boolean movingDown = false;
	private int movementY = 0;


	public PaddleActor(Body body) {
		super(body);
		textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Config.PADDLE_TEXTURE_PATH)));
	
	}

	@Override
	public PaddleUserData getUserData() {
		return (PaddleUserData) userData;
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		if(body.getPosition().y >= Config.PADDLE_MAX_Y) movingUp = false;
		if(body.getPosition().y <= Config.PADDLE_MIN_Y) movingDown = false;
		if(body.getPosition().y > Config.PADDLE_MAX_Y) body.setTransform(body.getPosition().x, Config.PADDLE_MAX_Y, body.getAngle());
		if(body.getPosition().y < Config.PADDLE_MIN_Y) body.setTransform(body.getPosition().x, Config.PADDLE_MIN_Y, body.getAngle());
		movementY = (movingUp ? 1 : 0) + (movingDown ? -1 : 0);
		body.setLinearVelocity(0, movementY * Config.PADDLE_SPEED);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		float min = Math.min(screenRectangle.width, screenRectangle.height);
		float max = Math.max(screenRectangle.width, screenRectangle.height);

		int i = 0;
		boolean horizontal = screenRectangle.width > screenRectangle.height;

		while (i * min <= max - min) {
			batch.draw(textureRegion, screenRectangle.x + (horizontal ? i * min : 0), screenRectangle.y + (horizontal ? 0 : i * min), min, min);
			i++;
		}
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

}
