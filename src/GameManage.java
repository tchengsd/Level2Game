import java.awt.Graphics;

public class GameManage {
	GamePlayer one;
	GamePlayer2 two;
	GameObject attacker;

	GameManage(GamePlayer a, GamePlayer2 b) {
		this.one = a;
		this.two = b;
	}

	void update() {
		one.update();
		two.update();
	}

	void draw(Graphics g) {
		one.draw(g);
		two.draw(g);
	}

	void checkCollision() {
		if (attacker != null) {
			if (attacker == two && one.CollisionBox.intersects(two.attack.CollisionBox)) {
				one.health -= two.attack.damage;
				one.update();
				System.out.println("oof a");
			} else if (attacker == one && two.CollisionBox.intersects(one.attack.CollisionBox)) {
				two.health -= one.attack.damage;
				two.barX += one.attack.damage;
				two.update();
				System.out.println("filler text b");
			}
		}
	}
}
