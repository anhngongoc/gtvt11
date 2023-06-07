package JFame;

import javax.swing.JFrame;

import Config.Config;
import Config.SwithJPaneUtils;
import JPanel.GameJPanelInGame;
import JPanel.GameJPanelMap;
import JPanel.GameJPanelMenu;
import JPanel.GameJPanelSpeed;
import MouseListener.M_L_Menu;

public class GameJFame extends JFrame implements Config {

	/**
	 * anhnn
	 */
	private static final long serialVersionUID = 1L;
	public static GameJPanelMenu gameJPanelMenu = new GameJPanelMenu();

	public static GameJPanelSpeed gameJPanelSpeed = new GameJPanelSpeed();

	public static GameJPanelInGame gameJPanelInGame;

	public static GameJPanelMap gameJPanelMap = new GameJPanelMap();
	public static int SPEED = 75;
	private static int mapIndex = 0;
	public GameJFame() {
		gameJPanelMenu.addMouseListener(new M_L_Menu());// this,gameJPanelMenu,null,gameJPanelSpeed
		// show menu
		this.add(gameJPanelMenu);
		this.setTitle(NAME_GAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.pack();
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}
}
 