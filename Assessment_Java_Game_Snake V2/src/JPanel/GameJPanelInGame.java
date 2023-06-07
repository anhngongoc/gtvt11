package JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Config.Config;
import JFame.GameJFame;
import MouseListener.M_L_Menu_InGame;
import SnakeGame.SnakeGame;

public class GameJPanelInGame extends JPanel implements Config, ActionListener {

	/**
	 * 
	 */
	public Rectangle playButton = new Rectangle(SCREEN_WITH / 3, 100, 0, 0);
	public Rectangle quitButton = new Rectangle(SCREEN_WITH / 3, 200, 0, 0);

	private int x[] = new int[ALL_DOTS];

	private int y[] = new int[ALL_DOTS];

	private int dots = 3;

	private int apple_x;

	private int apple_y;

	char direction = 'R';

	Random random;

	Timer timer;

	private int DELAY = GameJFame.SPEED;
	public static boolean InGame = false;
	public static boolean EndGame = false;
	public static boolean pause = false;

	private static final long serialVersionUID = 1L;
	private TAdapter tAdapter;

	public GameJPanelInGame(Component componentForm) {
		random = new Random();
		this.tAdapter = new TAdapter();
		addKeyListener(this.tAdapter);
		addMouseListener(new M_L_Menu_InGame(jfame, this, (GameJPanelMenu) GameJFame.gameJPanelMenu));//
		setBackground(Color.black);
		setFocusable(true);
		setPreferredSize(new Dimension(SCREEN_WITH, SCREEN_HEIGHT));
		initGame();
	}

	public void initGame() {

		dots = 3;

		for (int z = 0; z < dots; z++) {
			x[z] = 50;
			y[z] = 50;
		}
	
		locateApple();
		System.out.println("DELAY" + DELAY);
		timer = new Timer(DELAY, this);
		timer.start();
	}

	

	private void locateApple() {
		apple_x = random.nextInt(SCREEN_WITH / DOT_SIZE) * DOT_SIZE;
		apple_y = random.nextInt(SCREEN_HEIGHT / DOT_SIZE) * DOT_SIZE;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDraw(g);

	}

	public void doDraw(Graphics g) {
		
		String point = " point :   " + DELAY + " :" + String.valueOf(dots - 3);
		if (InGame) {
			Map(g);
			g.setColor(Color.green);
			g.fillRect(apple_x, apple_y, DOT_SIZE, DOT_SIZE);
			for (int z = 0; z < dots; z++) {
				System.out.println("MAP" +  x[z]);
				int xValue = x[z];
				int yValue = y[z];
				if (z == 0) {
					g.setColor(Color.green);
					g.fillRect(xValue, yValue, DOT_SIZE, DOT_SIZE);
				} else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(xValue, yValue, DOT_SIZE, DOT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 12));
			FontMetrics fontMetrics = getFontMetrics(g.getFont());
			g.drawString(point, (SCREEN_WITH - fontMetrics.stringWidth(point)) / 2, g.getFont().getSize());
			Toolkit.getDefaultToolkit().sync();
		} else {

			String text = "InGame";
			Graphics2D g2d = (Graphics2D) g;
			Font fnt0 = new Font("arial", Font.BOLD, 30);
			g.setFont(fnt0);
			g.setColor(Color.red);
			if (EndGame) {
				text = "EndGame";
			} else {
				text = " Space To Play Game";
			}
			FontMetrics fontMetricss = getFontMetrics(g.getFont());
			g.drawString(text, (SCREEN_WITH - fontMetricss.stringWidth(text)) / 2, 50);
			g.setFont(new Font("Ink Free", Font.BOLD, 75));
			FontMetrics fontMetrics = getFontMetrics(g.getFont());
			g.drawString(BACK_TO_MENU, (SCREEN_WITH - fontMetrics.stringWidth(BACK_TO_MENU)) / 2, playButton.y + 30);
			g2d.draw(playButton);
			g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
			g2d.draw(quitButton);
		}

	}
		private void Map(Graphics g) {
//			for(int z = 0; z < ALL_DOTS; z++) {
//				
//				if(x[z] == 0 || y[z] == 0) {
//					
//					g.setColor(Color.WHITE);
//					g.fillRect(x[z], y[z], DOT_SIZE, DOT_SIZE);
//				}
//				
//			}
//			
				
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (InGame) {
			checkApple();
			checkCollision();
			move();
		}
		repaint();
	}

	private void checkCollision() {
		{
			for (int z = dots; z > 0; z--) {
				if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
					InGame = false;
					EndGame = true;

				}
			}
			if (y[0] >= SCREEN_HEIGHT) {
//			inGame = false;
				y[0] = DOT_SIZE;
			}

			if (y[0] < 0) {
//			inGame = false;
				y[0] = SCREEN_HEIGHT;
			}

			if (x[0] >= SCREEN_WITH) {
				x[0] = DOT_SIZE;
//			inGame = false;
			}

			if (x[0] < 0) {
				x[0] = SCREEN_WITH;
//			inGame = false;
			}

			if (!InGame) {
				timer.stop();
			}
		}
	}

	private void move() {

		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (direction == 'U') {
			y[0] = y[0] - DOT_SIZE;
		} else if (direction == 'D') {
			y[0] = y[0] + DOT_SIZE;
		} else if (direction == 'L') {
			x[0] = x[0] - DOT_SIZE;
		} else if (direction == 'R') {
			x[0] = x[0] + DOT_SIZE;
		}
	}

	private void checkApple() {
		if ((x[0] == apple_x) && (y[0] == apple_y)) {

			dots++;
			locateApple();
		}
	}

	class TAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (direction != 'R' && key == KeyEvent.VK_LEFT)
				direction = 'L';
			if (direction != 'L' && key == KeyEvent.VK_RIGHT)
				direction = 'R';
			if (direction != 'D' && key == KeyEvent.VK_UP)
				direction = 'U';
			if (direction != 'U' && key == KeyEvent.VK_DOWN)
				direction = 'D';
			if (key == KeyEvent.VK_SPACE) {
				// start and pause game
				if (InGame) {
					InGame = false; // in menu
				} else {
					InGame = true; // play game
				}
//				pause = true;
			}

		}

	}
}
