
public class GameFighter extends GameObject {
	private int speed;
	private int health;
	private boolean attacking;
	private GameAttack attack;

	GameFighter(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		health = 300;
		attacking = false;
		// TODO Auto-generated constructor stub
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public GameAttack getAttack() {
		return attack;
	}

	public void setAttack(GameAttack attack) {
		this.attack = attack;
	}
	void reduceHealth(int damage) {
		health -= damage;
	}
}
