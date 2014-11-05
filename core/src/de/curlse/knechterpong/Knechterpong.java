package de.curlse.knechterpong;

import com.badlogic.gdx.Game;

import de.curlse.knechterpong.screens.GameScreen;

public class Knechterpong extends Game{

	@Override
    public void create() {
        setScreen(new GameScreen());
    }

}
