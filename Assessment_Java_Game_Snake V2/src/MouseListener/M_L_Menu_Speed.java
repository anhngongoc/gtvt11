package MouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;

import Config.Config;
import Config.ModelListText;
import Config.SwithJPaneUtils;
import JFame.GameJFame;
import JPanel.GameJPanelInGame;
import JPanel.GameJPanelMenu;
import JPanel.GameJPanelSpeed;
import SnakeGame.SnakeGame;

public class M_L_Menu_Speed implements MouseListener, Config {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(GameJPanelInGame.pause);
		int x = e.getX();
		int y = e.getY();
		int khoangcach = GameJPanelSpeed.khoang_cach;
//		System.out.println(y);
		List<ModelListText> lstViewSpeed_InMouse = GameJPanelSpeed.lstViewSpeed;
//		System.out.println("size " + lstViewSpeed_InMouse.size());
		for (int i = 0; i < lstViewSpeed_InMouse.size() - 1; i++) {
//			System.out.println("Vao "+String.valueOf(lstViewSpeed_InMouse.get(i).getY()));
			if (y >= lstViewSpeed_InMouse.get(i).getY() - khoangcach && y <= lstViewSpeed_InMouse.get(i).getY()
					&& i < lstViewSpeed_InMouse.size() - 2) {
				System.out.println("value " + lstViewSpeed_InMouse.get(i).getValue());
				GameJFame.SPEED = (Integer) lstViewSpeed_InMouse.get(i).getValue();
				SwithJPaneUtils.WithScreenToScrennV2(jfame, GameJFame.gameJPanelSpeed, GameJFame.gameJPanelMenu);
				break;
			} else {
				SwithJPaneUtils.WithScreenToScrennV2(jfame, GameJFame.gameJPanelSpeed, GameJFame.gameJPanelMenu);
			}
		}

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
