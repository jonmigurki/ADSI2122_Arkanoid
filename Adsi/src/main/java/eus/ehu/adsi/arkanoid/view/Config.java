package eus.ehu.adsi.arkanoid.view;

import java.awt.Color;

import javax.swing.text.AttributeSet.ColorAttribute;

public abstract class Config {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	public static final double BALL_RADIUS = 10.0;
	public static final double BALL_VELOCITY = 0.2;

	public static final double PADDLE_WIDTH = 60.0;
	public static final double PADDLE_HEIGHT = 20.0;
	public static final double PADDLE_VELOCITY = 0.4;

	public static final double BLOCK_WIDTH = 60.0;
	public static final double BLOCK_HEIGHT = 20.0;

	public static final int COUNT_BLOCKS_X = 11;
	public static final int COUNT_BLOCKS_Y = 4;

	public static final int PLAYER_LIVES = 5;

	public static final double FT_SLICE = 1.0;
	public static final double FT_STEP = 1.0;

	public static final String FONT = "Courier New";
	public static final Color FONT_COLOR = Color.lightGray;
	
	
	public static Color BACKGROUND_COLOR;
	public static Color BALL_COLOR;
	public static Color PADDLE_COLOR;
	public static Color BRICK_COLOR;
	
	/*
	public static Color BLACK = Color.black;
	public static Color WHITE = Color.white;
	public static Color CYAN = Color.cyan;
	public static Color GREEN = Color.green;
	public static Color RED = Color.red;
	public static Color PINK = Color.pink;
	public static Color ORANGE = Color.orange;
*/
}
