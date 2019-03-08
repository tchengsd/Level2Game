import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		x++;
		y++;
	}
	
	void draw(Graphics g) {
		g.fillOval(x, y, 100, 100);
	}
}
