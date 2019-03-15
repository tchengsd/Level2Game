import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer fps;
	GameObject obj;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font regular;
	GamePlayer one = new GamePlayer(50, 250, 100, 500);
	GamePlayer2 two = new GamePlayer2(850, 250, 100, 500);

	GamePanel() {
		fps = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		regular = new Font("Arial", Font.PLAIN, 24);
	}

	void startGame() {
		fps.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		one.update();
		two.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, GameRunner.width, GameRunner.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Fighting Game", 350, 250);
		g.setFont(regular);
		g.drawString("Press SPACE to start", 385, 500);
		g.drawString("Press ENTER for controls", 370, 530);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameRunner.width, GameRunner.height);
		one.draw(g);
		two.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.width, GameRunner.height);
		g.setFont(titleFont);
		g.setColor(Color.MAGENTA);
		g.drawString("Player 0 wins!", 100, 150);
	}

	@Override

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
		int k = e.getKeyChar();
		if (k == 97 || k == 100) {
			one.move(k);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_LEFT || k == KeyEvent.VK_RIGHT) {
			two.move(k);
		} else if (k == KeyEvent.VK_SPACE) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		one.isMoving = false;
		two.isMoving = false;
	}

}
