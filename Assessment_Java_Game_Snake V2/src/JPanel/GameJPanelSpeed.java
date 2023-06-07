package JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Config.Config;
import Config.ModelListText;
import MouseListener.M_L_Menu_Speed;

public class GameJPanelSpeed extends JPanel implements Config {

	/**
	 * 
	 */
	public static int start_list = 0;
	public static int count_show_item = 3;
	public static int khoang_cach = 40;
	public static List<ModelListText> lstViewSpeed = new ArrayList<>();
//	public static  int  y = 80;
	public Rectangle Value = new Rectangle(SCREEN_WITH / 3, 200, 0, 0);
	public Rectangle BackButton = new Rectangle(SCREEN_WITH / 3, 100, 0, 0);
//	public Rectangle UpButton = new Rectangle(SCREEN_WITH / 3, 100, 0, 0);
//	public Rectangle DownButton = new Rectangle(SCREEN_WITH / 3, 100, 0, 0);

	private static final long serialVersionUID = 1L;

	public GameJPanelSpeed() {
		setPreferredSize(new Dimension(SCREEN_WITH, SCREEN_HEIGHT));

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.addMouseListener(new M_L_Menu_Speed());
		doDraw(g);

	}

	public void doDraw(Graphics g) {
		String text = "GameJPanelSpeed";
//		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 30);

		g.setFont(fnt0);
		g.setColor(Color.red);
		g.drawString(text, SCREEN_WITH / 4, 50);
		g.setFont(new Font("Ink Free", Font.BOLD, 30));
		int y = 50;
		for (int i = 0; i <= lstSpeed.size() - 1; i++) {
			int addy = y + khoang_cach;
			g.drawString(lstSpeed.get(i).toString(), SCREEN_WITH / 4, addy);
			lstViewSpeed.add(new ModelListText(SCREEN_WITH / 4, addy, (Object) lstSpeed.get(i)));
			y = addy;
		}
		start_list = 3;
		g.drawString("Back", BackButton.x + 19, SCREEN_HEIGHT - 30);
		lstViewSpeed.add(new ModelListText(BackButton.x + 19, SCREEN_HEIGHT - 30, (Object) "Back"));
//		g2d.draw(BackButton);
//		Toolkit.getDefaultToolkit().sync();
	}
}
