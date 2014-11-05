package de.curlse.knechterpong.old;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Arena {

	public Arena(World world, int gameWidth, int gameHeight) {

		// Top
		BodyDef topBodyDef = new BodyDef();
		topBodyDef.position.set(new Vector2(0, gameHeight / 2));
		Body topBody = world.createBody(topBodyDef);
		PolygonShape topBox = new PolygonShape();
		topBox.setAsBox(gameWidth, Math.min(gameWidth, gameHeight) / 75);
		topBody.createFixture(topBox, 0.0f);
		topBox.dispose();

		// Bottom
		BodyDef bottomBodyDef = new BodyDef();
		bottomBodyDef.position.set(new Vector2(0, -gameHeight / 2));
		Body bottomBody = world.createBody(bottomBodyDef);
		PolygonShape bottomBox = new PolygonShape();
		bottomBox.setAsBox(gameWidth, Math.min(gameWidth, gameHeight) / 75);
		bottomBody.createFixture(bottomBox, 0.0f);
		bottomBox.dispose();

		// Left
		BodyDef leftBodyDef = new BodyDef();
		leftBodyDef.position.set(new Vector2(-gameWidth / 2, 0));
		Body leftBody = world.createBody(leftBodyDef);
		PolygonShape leftBox = new PolygonShape();
		leftBox.setAsBox(Math.min(gameWidth, gameHeight) / 75, gameHeight);
		leftBody.createFixture(leftBox, 0.0f);
		leftBody.setUserData("leftWall");
		leftBox.dispose();

		// right
		BodyDef rightBodyDef = new BodyDef();
		rightBodyDef.position.set(new Vector2(gameWidth / 2, 0));
		Body rightBody = world.createBody(rightBodyDef);
		PolygonShape rightBox = new PolygonShape();
		rightBox.setAsBox(Math.min(gameWidth, gameHeight) / 75, gameHeight);
		rightBody.createFixture(rightBox, 0.0f);
		leftBody.setUserData("rightWall");
		rightBox.dispose();

	}

}
