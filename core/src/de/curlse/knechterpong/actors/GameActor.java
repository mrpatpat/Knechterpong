package de.curlse.knechterpong.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import de.curlse.knechterpong.box2d.UserData;
import de.curlse.knechterpong.config.Config;
import de.curlse.knechterpong.utils.WorldUtils;

public abstract class GameActor extends Actor {

	public Body body;
	protected UserData userData;
	protected Rectangle screenRectangle;

	public GameActor() {

	}

	public GameActor(Body body) {
		this.body = body;
		this.userData = (UserData) body.getUserData();
		screenRectangle = new Rectangle();
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		updateRectangle();

	}

	public abstract UserData getUserData();

	private void updateRectangle() {

		Vector3 pos = new Vector3(body.getPosition().x, body.getPosition().y, 0);
		Vector3 size = new Vector3(userData.getWidth(), userData.getHeight(), 0);
		
		screenRectangle.x = pos.x -size.x/2;
		screenRectangle.y = pos.y -size.y/2;
		screenRectangle.width = size.x;
		screenRectangle.height = size.y;

	}

}
