import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GamePlayer2 extends GameObject {
	int speed = 10;
	int direction;
	int health = 300;
	int barX = 575;
	boolean isMoving = false;
	boolean attacking = false;
	GameAttack attack;

	GamePlayer2(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (isMoving) {
			if (direction == KeyEvent.VK_LEFT) {
				x -= speed;
			}
			if (direction == KeyEvent.VK_RIGHT) {
				x += speed;
			}
		}
		if (attack != null) {
			attack.update();
			attacking = attack.active;
		}
	}

	void move(int direction) {
		if (!isMoving) {
			isMoving = true;
			this.direction = direction;
		}

	}

	void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		Font regular = new Font("Arial", Font.PLAIN, 24);
		g.setFont(regular);
		g.drawString("Player 2", 880, 40);
		g.setColor(Color.YELLOW);
		g.fillRect(barX, 20, health, 24);
		g.setColor(Color.GREEN);
		g.drawRect(CollisionBox.x, CollisionBox.y, CollisionBox.width, CollisionBox.height);
		if (attack != null) {
			attack.draw(g);
		}
	}

	void attack() {
		attack = new GameAttack(x - 100, y + 250);
		attacking = true;
	}
}
