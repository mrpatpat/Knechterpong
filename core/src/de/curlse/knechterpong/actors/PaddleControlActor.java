package de.curlse.knechterpong.actors;

import com.badlogic.gdx.Gdx;

public abstract class PaddleControlActor extends GhostActor {
	
	private PaddleActor paddle;
	private boolean connected = true;

	public PaddleControlActor(PaddleActor paddle) {
		this.paddle = paddle;
	}
	
	public void startMovingUp(){
		if(connected) paddle.setMovingUp(true);
	}
	
	public void stopMovingUp(){
		if(connected) paddle.setMovingUp(false);
	}
	
	public void startMovingDown(){
		if(connected) paddle.setMovingDown(true);
	}
	
	public void stopMovingDown(){
		if(connected) paddle.setMovingDown(false);
	}
	
	public void menu(){
		if(connected) Gdx.app.exit(); //TODO
	}

	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	public void connect(){
		connected = true;
	}
	
	public void disconnect(){
		connected = false;
	}

	public boolean isConnected(){
		return connected;
	}
}
