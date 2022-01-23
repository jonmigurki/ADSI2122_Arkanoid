package eus.ehu.adsi.arkanoid.view;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.sql.SQLException;

import eus.ehu.adsi.arkanoid.Controlador;

public class ScoreBoard {

	public int score = 0;
	public int lives = Config.PLAYER_LIVES;
	public boolean win = false;
	public boolean gameOver = false;
	String text = "";

	Font font;

	public ScoreBoard() {
		font = new Font(Config.FONT, Font.PLAIN, 12);
		text = "Welcome to Arkanoid";
	}
	
	public int getScore() {
		return this.score;
	}

	public void increaseScore() throws SQLException {
		score++;
		if (score == (Config.COUNT_BLOCKS_X * Config.COUNT_BLOCKS_Y)) {
			Controlador.getControlador().insertarPuntuacion();
			win = true;
			text = "You have won! \nYour score was: " + score
					+ "\n\nPress Enter to restart";
		} else {
			updateScoreboard();
		}
	}

	void die() throws SQLException {
		lives--;
		if (lives == 0) {
			Controlador.getControlador().insertarPuntuacion();
			gameOver = true;
			text = "You have lost! \nYour score was: " + score
					+ "\n\nPress Enter to restart";
		} else {
		}
	}

	public void updateScoreboard() {
		text = "Score: " + score + "  Lives: " + lives;
	}

	public void draw(Graphics g) {
		if (win || gameOver) {
			font = font.deriveFont(50f);
			FontMetrics fontMetrics = g.getFontMetrics(font);
			g.setColor(Config.FONT_COLOR);
			g.setFont(font);
			int titleHeight = fontMetrics.getHeight();
			int lineNumber = 1;
			for (String line : text.split("\n")) {
				int titleLen = fontMetrics.stringWidth(line);
				g.drawString(line, (Config.SCREEN_WIDTH / 2) - (titleLen / 2),
						(Config.SCREEN_HEIGHT / 4) + (titleHeight * lineNumber));
				lineNumber++;

			}
		} else {
			font = font.deriveFont(34f);
			FontMetrics fontMetrics = g.getFontMetrics(font);
			g.setColor(Config.FONT_COLOR);
			g.setFont(font);
			int titleLen = fontMetrics.stringWidth(text);
			int titleHeight = fontMetrics.getHeight();
			g.drawString(text, (Config.SCREEN_WIDTH / 2) - (titleLen / 2),
					titleHeight + 35);
		}
	}
}
