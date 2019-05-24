import java.awt.Dimension;

import javax.swing.JFrame;

public class GameRunner {
	JFrame gameFrame;
	GamePanel gamePanel;
	final static int width = 1000;
	final static int height = 800;
	
	public GameRunner(){
		gameFrame = new JFrame();
		gamePanel = new GamePanel();
	}
	//text
	void setup() {
		gameFrame.add(gamePanel);
		gameFrame.addKeyListener(gamePanel);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(width, height);
		gameFrame.getContentPane().setPreferredSize(new Dimension(width, height));
        gameFrame.pack();
        gamePanel.startGame();
	}
	public static void main(String[] args) {
		GameRunner runner = new GameRunner();
		runner.setup();
	}
}
/*
*****Progress for today (23 May)*****
Made P1's inputs work properly.
Collisions now work.
Will see about fixing the problems with the 2-player game.
*/
