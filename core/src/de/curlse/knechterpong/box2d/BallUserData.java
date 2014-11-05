package de.curlse.knechterpong.box2d;

public class BallUserData extends UserData {

	   public BallUserData(float radius) {
	        super(2*radius, 2*radius);
	        userDataType = UserDataType.BALL;
	    }
	   
}
