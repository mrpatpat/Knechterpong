package de.curlse.knechterpong.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import de.curlse.knechterpong.config.Config;
import de.curlse.knechterpong.utils.WorldUtils;

public class FloorActor extends GhostActor {

	private Texture texture;

	public FloorActor() {
		super();
		texture = new TextureRegion(new Texture(Gdx.files.internal(Config.FLOOR_TEXTURE_PATH))).getTexture();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		int i = 0;
		int j = 0;
		int s = (int) (texture.getWidth() * Config.FLOOR_SCALE);

		while (i * s <= Config.VIEWPORT_WIDTH) {
			while (j * s <= Config.VIEWPORT_HEIGHT) {
				batch.draw(texture, i * s, j * s, s, s);
				j++;
			}
			j=0;
			i++;
		}
		

	}
}
