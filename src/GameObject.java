import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	boolean isMoving = false;
	int direction;
	Rectangle CollisionBox;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		CollisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		CollisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {

	}

	void move(int direction) {
		if (!isMoving) {
			isMoving = true;
			this.direction = direction;
		}

	}
	void attack() {
		
	}
}
