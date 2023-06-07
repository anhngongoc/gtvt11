package SnakeGame;

import java.awt.EventQueue;

import Config.Config;

public class SnakeGame implements Config {

	public static void main(String[] args) {
		System.out.println(lstSpeed.get(0));
		EventQueue.invokeLater(() -> {
			jfame.setVisible(true);
		});
	}

}
//status = newGame
//
//
//
//when space  continuet : show menu 
//	-ctn game 
//	-Back menu.
//
//start == > view  ( Space to Play Game  //done
//
//InGame ==> space view ( space To continue Game // New Game // Quit ) 
//
//EndGame ==> view ( end game  // New Game  // Quit ) 
//
//
//Speed (  select the speed you want  up // value /down ).
//
//====
//map ( select the map you Want up // value // down ). show 1 2 3 
//
//load map ==> inGame.
//check==map ==>inGame.

//class all Jpanel. in main done
// main set value .

// conti done
// menu show speed.
