package JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import Config.Config;

public class GameJPanelMap extends JPanel implements Config {

	/**
	 * 
	 */
	public Rectangle playButton = new Rectangle(SCREEN_WITH / 3, 100, 0, 0);
	public Rectangle mapButton = new Rectangle(SCREEN_WITH / 3, 200, 0, 0);
	public Rectangle quitButton = new Rectangle(SCREEN_WITH / 3, 300, 0, 0);

	private static final long serialVersionUID = 1L;

	public GameJPanelMap() {
		setPreferredSize(new Dimension(SCREEN_WITH, SCREEN_HEIGHT));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDraw(g);

	}

	public void doDraw(Graphics g) {
		String text = "GameJPanelmapp";
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 30);

		g.setFont(fnt0);
		g.setColor(Color.red);
		g.drawString(text, SCREEN_WITH / 4, 50);

		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		g.drawString("Play", playButton.x + 19, playButton.y + 30);
		g2d.draw(playButton);
		g.drawString("Map", mapButton.x + 19, mapButton.y + 30);
		g2d.draw(mapButton);

		g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
		g2d.draw(quitButton);
	}
}
