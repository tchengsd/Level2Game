import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer fps;
	GameObject obj;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	int winner;
	Font titleFont;
	Font regular;
	GamePlayer one = new GamePlayer(50, 250, 150, 500);
	GamePlayer2 two = new GamePlayer2(800, 250, 150, 500);
	GameManage manage = new GameManage(one, two);
	public static BufferedImage orange;
	public static BufferedImage blue;


	GamePanel() {
		fps = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		regular = new Font("Arial", Font.PLAIN, 24);
	    try {
            orange = ImageIO.read(this.getClass().getResourceAsStream("stick-figure-orange-hi.png"));
            blue = ImageIO.read(this.getClass().getResourceAsStream("blue.png"));
            
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
	}

	void startGame() {
		fps.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manage.update();
		if (two.getHealth() == 0) {
			winner = 1;
			currentState = END_STATE;
		} else if (one.getHealth() == 0) {
			winner = 2;
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, GameRunner.width, GameRunner.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Fighting Basics", 350, 250);
		g.setFont(regular);
		g.drawString("Press SPACE to start", 385, 500);
		g.drawString("Press ENTER for controls", 370, 530);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.width, GameRunner.height);
		manage.draw(g);
		g.setFont(regular);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.width, GameRunner.height);
		g.setFont(titleFont);
		g.setColor(Color.MAGENTA);
		g.drawString("Player " + winner + " wins!", 100, 150);
		if (winner == 1) {
			g.drawImage(orange, 500, 200, 300, 700, null);
		} else if (winner == 2) {
			g.drawImage(blue, 500, 200, 300, 700, null);
		}
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// p2
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_LEFT || k == KeyEvent.VK_RIGHT) {
			two.move(k);
		} else if (k == KeyEvent.VK_COMMA) {
			manage.setAttacker(two);
		}
		// p1
		else if (k == KeyEvent.VK_A || k == KeyEvent.VK_D) {
			one.move(k);
		} else if (k == KeyEvent.VK_C) {
			manage.setAttacker(one);
		} else if (k == KeyEvent.VK_SPACE) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
			if (currentState == MENU_STATE) {
				one = new GamePlayer(50, 250, 150, 500);
				two = new GamePlayer2(800, 250, 150, 500);
				manage = new GameManage(one, two);
			}
		} else if (k == KeyEvent.VK_ENTER && currentState == 0) {
			JOptionPane.showMessageDialog(null, "Player 1: Use A and D to move left and right. Press C to attack.\n"
					+ "Player 2: Use arrow keys to move left and right. Press COMMA to attack.\n" + "DO NOT HOLD ATTACK BUTTONS");
		}
			manage.checkCollision();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		one.isMoving = false;
		two.isMoving = false;
		manage.setAttacker(null);
	}
}
