import java.awt.Graphics;

public class GameManage {
	GamePlayer a;
	GamePlayer2 b;

	GameManage(GamePlayer a, GamePlayer2 b) {
		this.a = a;
		this.b = b;
	}

	void update() {
		a.update();
		b.update();
	}

	void draw(Graphics g) {
		a.draw(g);
		b.draw(g);
	}
}
