import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameAttack extends GameObject implements ActionListener {
	private Timer frames = new Timer(30000 / 60, this);
	final int damage = 5;
	boolean active;
	
	GameAttack(int x, int y) {
		super(x, y, 100, 10);
		active = true;
		frames.start();
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
		if (frames.isRunning() == true) {
			g.setColor(Color.GRAY);
			g.fillRect(x, y, width, height);
			g.setColor(Color.RED);
			g.drawRect(CollisionBox.x, CollisionBox.y, CollisionBox.width, CollisionBox.height);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("attackingg");
		// TODO Auto-generated method stub
			frames.stop();
			active = false;
	}
}
