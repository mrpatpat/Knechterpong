package de.curlse.knechterpong.actors;

import com.badlogic.gdx.Gdx;


public class PaddleKeyBoardControlActor extends PaddleControlActor {
	
	private final int up;
	private final int down;
	private final int menu;
	

	public PaddleKeyBoardControlActor(PaddleActor paddle, int up, int down, int menu) {
		super(paddle);
		this.up = up;
		this.down = down;
		this.menu = menu;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		if(Gdx.input.isKeyPressed(up)){
			this.startMovingUp();
		} else this.stopMovingUp();
		
		if(Gdx.input.isKeyPressed(down)){
			this.startMovingDown();
		} else this.stopMovingDown();
		
		if(Gdx.input.isKeyPressed(menu)){
			this.menu();
		}
		
	}

}
