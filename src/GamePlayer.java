import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GamePlayer extends GameObject {
	int speed = 10;
	int direction;
	int health = 300;
	boolean isMoving = false;
	boolean attacking = false;
	GameAttack attack;

	GamePlayer(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (isMoving) {
			if (direction == 97) {
				x -= speed;
			}
			if (direction == 100) {
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
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		Font regular = new Font("Arial", Font.PLAIN, 24);
		g.setFont(regular);
		g.drawString("Player 1", 30, 40);
		g.setColor(Color.YELLOW);
		g.fillRect(120, 20, health, 24);
		g.setColor(Color.RED);
		g.drawRect(CollisionBox.x, CollisionBox.y, CollisionBox.width, CollisionBox.height);
		if (attack != null) {
			attack.draw(g);
		}
	}

	void attack() {
		attack = new GameAttack(x + 100, y + 250);
		attacking = true;
	}
}
