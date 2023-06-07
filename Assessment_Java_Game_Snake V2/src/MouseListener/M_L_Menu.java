package MouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Config.Config;
import Config.SwithJPaneUtils;
import JFame.GameJFame;
import JPanel.GameJPanelInGame;
import JPanel.GameJPanelMenu;
import JPanel.GameJPanelSpeed;

public class M_L_Menu implements MouseListener, Config {
//	JFrame frame;
//	GameJPanelMenu gameJPanelMenu;
//	GameJPanelInGame gameJPanelInGame;
//	GameJPanelSpeed gameJPanelSpeed;
//
//	public M_L_Menu(JFrame frame, GameJPanelMenu gameJPanelMenu, GameJPanelInGame gameJPanelInGame,
//			GameJPanelSpeed gameJPanelSpeed) {
//
//		this.frame = frame;
//		this.gameJPanelMenu = gameJPanelMenu;
//		this.gameJPanelInGame = gameJPanelInGame;
//		this.gameJPanelSpeed = gameJPanelSpeed;
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		int x = e.getX();
		int y = e.getY();

		// if( x >=SCREEN_WITH / 3 && x <= SCREEN_WITH / 3 + 19) {
		if (y >= 100 && y <= 100 + 30) {
			// play
			System.out.println("play");
			SwithJPaneUtils.WithScreenToScreen(jfame, GameJFame.gameJPanelMenu, GameJFame.gameJPanelInGame);
			GameJPanelInGame.InGame = false;
			GameJPanelInGame.EndGame = false;
			GameJPanelInGame.pause = false;
		}
		if (y >= 200 && y <= 200 + 30) {
			// play
			System.out.println("speed");
			SwithJPaneUtils.WithScreenToScrennV2(jfame, GameJFame.gameJPanelMenu, GameJFame.gameJPanelSpeed);
		}
		if (y >= 300 && y <= 300 + 30) {
			// play
			System.out.println("map");
			SwithJPaneUtils.WithScreenToScrennV2(jfame, GameJFame.gameJPanelMenu, GameJFame.gameJPanelMap);
		}
		if (y >= 400 && y <= 400 + 30) {
			// play
			System.out.println("Quit");
			System.exit(0);
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
