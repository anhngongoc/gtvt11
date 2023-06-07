package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class main {
	 public static void main(String[] args) {
			// menu
			new main_game(KEY.NAME_GAME, 4,null);
		}
	 public Rectangle playButton = new Rectangle(KEY.WITH/2,120 , 150,100);
	 public Rectangle helpButton = new Rectangle(KEY.WITH/2,120 , 150,100);
	 public Rectangle quitButton = new Rectangle(KEY.WITH/2,120 , 150,100);
	 public void render(Graphics g) {
		 Graphics2D  g2d  =(Graphics2D) g;
		 Font fnt0 = new Font("arial",Font.BOLD,50);
		 
		 g.setFont(fnt0);
		 g.setColor(Color.white);
		 g.drawString(KEY.NAME_GAME, KEY.WITH/2, 100);
		 
		 g2d.draw(playButton);
		 g2d.draw(helpButton);
		 g2d.draw(quitButton);
		 
	 }
}
