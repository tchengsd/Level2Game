import java.awt.Graphics;

public class GameManage {
	private GamePlayer one;
	private GamePlayer2 two;
	private GameObject attacker;

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
			if (attacker == two && one.CollisionBox.intersects(two.getAttack().CollisionBox)) {
				one.reduceHealth(two.getAttack().damage);
				one.update();
			} else if (attacker == one && two.CollisionBox.intersects(one.getAttack().CollisionBox)) {
				two.reduceHealth(one.getAttack().damage);
				two.update();
			}
		}
	}

	public GamePlayer getOne() {
		return one;
	}

	public void setOne(GamePlayer one) {
		this.one = one;
	}

	public GamePlayer2 getTwo() {
		return two;
	}

	public void setTwo(GamePlayer2 two) {
		this.two = two;
	}

	public GameObject getAttacker() {
		return attacker;
	}

	public void setAttacker(GameObject attacker) {
		this.attacker = attacker;
		if (attacker != null) {
			attacker.attack();
		}
	}
}
