package de.curlse.knechterpong.box2d;

public class PaddleUserData extends UserData {

	private final boolean isLeft;

	public PaddleUserData(float width, float height, UserDataType ud) {
		super(width, height);
		userDataType = ud;
		
		if (ud == UserDataType.LEFTPADDLE)
			isLeft = true;
		else
			isLeft = false;
	}
	
	public boolean isLeft(){
		return isLeft;
	}

}
