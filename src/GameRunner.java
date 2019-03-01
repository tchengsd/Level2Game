import javax.swing.JFrame;

public class GameRunner {
	JFrame gameFrame;
	final int width = 1000;
	final int height = 800;
	GameRunner(){
		gameFrame = new JFrame();
	}
	void setup() {
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(width, height);
	}
	public static void main(String[] args) {
		new GameRunner().setup();
	}
}
