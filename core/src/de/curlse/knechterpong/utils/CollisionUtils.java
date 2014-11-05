package de.curlse.knechterpong.utils;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

import de.curlse.knechterpong.box2d.UserData;
import de.curlse.knechterpong.box2d.UserDataType;

public class CollisionUtils {

	public static boolean collided(Contact contact, UserDataType typeA, UserDataType typeB) {
		Fixture a = contact.getFixtureA();
		Fixture b = contact.getFixtureB();

		UserData aData = (UserData) a.getUserData();
		UserData bData = (UserData) b.getUserData();

		if ((aData.getUserDataType() == typeA && bData.getUserDataType() == typeB) || (aData.getUserDataType() == typeB && bData.getUserDataType() == typeA))
			return true;

		return false;
	}

}
