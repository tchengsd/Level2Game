import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GamePlayer extends Player {

	GamePlayer(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
		if (isMoving) {
			if (direction == KeyEvent.VK_A) {
				x -= getSpeed();
			}
			if (direction == KeyEvent.VK_D) {
				x += getSpeed();
			}
		}
		if (getAttack() != null) {
			getAttack().update();
			setAttacking(getAttack().active);
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.orange, x, y, width, height, null);
		g.setColor(Color.WHITE);
		Font regular = new Font("Arial", Font.PLAIN, 24);
		g.setFont(regular);
		g.drawString("Player 1", 30, 40);
		g.setColor(Color.YELLOW);
		g.fillRect(120, 20, getHealth(), 24);
		g.setColor(Color.RED);
		g.drawRect(CollisionBox.x, CollisionBox.y, CollisionBox.width, CollisionBox.height);
		if (getAttack() != null) {
			getAttack().draw(g);
		}
	}

	

	void attack() {
		setAttack(new GameAttack(x + width, y + 250));
		setAttacking(true);
	}
}
