package Config;

import java.awt.Component;

import javax.swing.JFrame;

import JFame.GameJFame;
import JPanel.GameJPanelInGame;

public class SwithJPaneUtils implements Config {

	public static void WithScreenToScreen(JFrame frame, Component componentForm, Component componentTo) {
		componentForm.setVisible(false);
		frame.remove(componentForm);
		GameJFame.gameJPanelInGame = new GameJPanelInGame(componentForm);
		GameJFame.gameJPanelInGame.setVisible(true);
		GameJFame.gameJPanelInGame.requestFocus();
		GameJFame.gameJPanelInGame.setFocusable(true);

		frame.add(GameJFame.gameJPanelInGame);
		frame.invalidate();
		frame.validate();
		frame.repaint();
		GameJFame.gameJPanelInGame.setVisible(true);
		GameJFame.gameJPanelInGame.requestFocus();
		GameJFame.gameJPanelInGame.setFocusable(true);

	}

	public static void WithScreenToScrennV2(JFrame frame, Component componentForm, Component componentTo) {
		componentForm.setVisible(false);
		frame.remove(componentForm);
		componentTo.setVisible(true);
		componentTo.requestFocus();
		componentTo.setFocusable(true);
		frame.add(componentTo);
		frame.invalidate();
		frame.validate();
		frame.repaint();
		componentTo.setVisible(true);
		componentTo.requestFocus();
		componentTo.setFocusable(true);
//		componentTo.addMouseListener(new M_L_Menu(null,GameJFame.gameJPanelMenu,null,null));

	}

}
