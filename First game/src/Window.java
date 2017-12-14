/*Darren Lim
 * This class should create the window for my game
 */

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9034494958129720942L;
	//I think long is just longer int
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//so when you click close it terminates
		frame.setResizable(false);
		//so that it cannot be resized(cuz that would cause problems)
		frame.setLocationRelativeTo(null);
		//so it shows up in middle of screen
		
		frame.add(game);
		frame.setVisible(true);
		//duh
		game.start();

		
	}

}
