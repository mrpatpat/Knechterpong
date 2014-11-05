package de.curlse.knechterpong.utils;

import de.curlse.knechterpong.actors.PaddleActor;
import de.curlse.knechterpong.actors.PaddleKeyBoardControlActor;
import de.curlse.knechterpong.config.Config;

public class ControlUtils {

	public static PaddleKeyBoardControlActor getDefaultKeyBoardController(PaddleActor p, boolean isLeft) {

		if (isLeft) {
			return new PaddleKeyBoardControlActor(p, Config.DEFAULT_CONTROL_LEFT_UP, Config.DEFAULT_CONTROL_LEFT_DOWN, Config.DEFAULT_CONTROL_LEFT_MENU);
		} else
			return new PaddleKeyBoardControlActor(p, Config.DEFAULT_CONTROL_RIGHT_UP, Config.DEFAULT_CONTROL_RIGHT_DOWN, Config.DEFAULT_CONTROL_RIGHT_MENU);

	}
}
