package redempt.shapefiller;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TriangleChallenge challenge = new TriangleChallenge();
		frame.add(challenge);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Triangle challenge");
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					challenge.fill.clear();
					challenge.points = new Point[3];
					challenge.length = 0;
					challenge.repaint();
				}
			}
			
		});
	}
	
}
