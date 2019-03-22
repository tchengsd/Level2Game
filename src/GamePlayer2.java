import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GamePlayer2 extends GameObject {
	int speed = 10;
	int direction;
	int health = 300;
	boolean isMoving = false;

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
	}
}
