package Config;

import java.util.ArrayList;
import java.util.List;

import JFame.GameJFame;

public interface Config {
	static String NAME_GAME = "Snake  -- 001";
	static String BACK_TO_MENU = "Back To Menu";
	public static GameJFame jfame = new GameJFame();
	public static int SCREEN_WITH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int DOT_SIZE = 10;
	static final int ALL_DOTS = (SCREEN_WITH * SCREEN_HEIGHT) / DOT_SIZE;
	static final int SPEED = 75;
	List<Integer> lstSpeed = data();

	public static List<Integer> data() {
		List<Integer> lstSpeed1 = new ArrayList<>();
		lstSpeed1.add(10);
		lstSpeed1.add(55);
		lstSpeed1.add(65);
		lstSpeed1.add(75);
		lstSpeed1.add(100);
		return lstSpeed1;

	}
}
