import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;

public class GamePlayer2 extends GameFighter {
	int barX;
	public static BufferedImage sword;

	public int getBarX() {
		return barX;
	}

	public void setBarX(int barX) {
		this.barX = barX;
	}

	GamePlayer2(int x, int y, int width, int height) {
		super(x, y, width, height);
		barX = 575;
		// TODO Auto-generated constructor stub
		try {
			sword = ImageIO.read(this.getClass().getResourceAsStream("sword-to-left.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void update() {
		super.update();
		if (isMoving) {
			if (direction == KeyEvent.VK_LEFT) {
				x -= getSpeed();
			}
			if (direction == KeyEvent.VK_RIGHT) {
				x += getSpeed();
			}
		}
		if (getAttack() != null) {
			getAttack().update();
			setAttacking(getAttack().active);
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.blue, x, y, width, height, null);
		g.setColor(Color.WHITE);
		Font regular = new Font("Arial", Font.PLAIN, 24);
		g.setFont(regular);
		g.drawString("Player 2", 880, 40);
		g.setColor(Color.YELLOW);
		g.fillRect(barX, 20, getHealth(), 24);
		if (getAttack() != null) {
			getAttack().draw(g);
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	void attack() {
		setAttack(new GameAttack(x - 150, y + 215));
		setAttacking(true);
		getAttack().attacker = 2;
		playSound("swordSheath.wav");
	}

	void reduceHealth(int damage) {
		super.reduceHealth(damage);
		barX += damage;
	}
}
