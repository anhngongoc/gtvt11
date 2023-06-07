package MouseListener;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import Config.Config;
import Config.SwithJPaneUtils;
import JFame.GameJFame;
import JPanel.GameJPanelInGame;
import JPanel.GameJPanelMenu;

public class M_L_Menu_InGame implements MouseListener, Config {
	JFrame frame;
	GameJPanelMenu gameJPanelMenu;
	GameJPanelInGame gameJPanelInGame;

	public M_L_Menu_InGame(JFrame frame, GameJPanelInGame gameJPanelInGame, GameJPanelMenu gameJPanelMenu) {

		this.frame = frame;
		this.gameJPanelInGame = gameJPanelInGame;
		this.gameJPanelMenu = gameJPanelMenu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(GameJPanelInGame.pause);
		if (!GameJPanelInGame.InGame) {
			int x = e.getX();
			int y = e.getY();
			// if( x >=SCREEN_WITH / 3 && x <= SCREEN_WITH / 3 + 19) {
			if (y >= 100 && y <= 100 + 30) {
				// play
				GameJFame.SPEED = SPEED;
				SwithJPaneUtils.WithScreenToScrennV2(jfame, (Component) gameJPanelInGame, (Component) gameJPanelMenu);

			}
			if (y >= 200 && y <= 200 + 30) {
				// play
				System.out.println("Quit");
				System.exit(0);
			}
		}

		// }

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
