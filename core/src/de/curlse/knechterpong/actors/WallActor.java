package de.curlse.knechterpong.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

import de.curlse.knechterpong.box2d.WallUserData;
import de.curlse.knechterpong.config.Config;

public class WallActor extends GameActor {

	private final TextureRegion textureRegion;

	public WallActor(Body body) {
		super(body);
		textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Config.WALL_TEXTURE_PATH)));
	}

	@Override
	public WallUserData getUserData() {
		return (WallUserData) userData;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
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

}
