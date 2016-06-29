package redempt.shapefiller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class TriangleChallenge extends JPanel {

	private static final long serialVersionUID = -6643068228056036002L;
	Point[] points = new Point[3];
	int length = 0;
	List<Point> fill = new ArrayList<>();
	
	public TriangleChallenge() {
		this.setSize(500, 500);
		this.setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (length < 3) {
					points[length] = e.getPoint();
					length++;
					repaint();
				}
				if (length == 3) {
					fill.clear();
					int maxx = Integer.MIN_VALUE;
					int minx = Integer.MAX_VALUE;
					int maxy = Integer.MIN_VALUE;
					int miny = Integer.MAX_VALUE;
					for (Point point : points) {
						maxx = Math.max(maxx, point.x) + 100;
						maxy = Math.max(maxy, point.y) + 100;
						miny = Math.min(miny, point.y) - 100;
						minx = Math.min(minx, point.y) - 100;
					}
					List<Line> lines = new ArrayList<>();
					lines.add(new Line(points[0], points[1]).setOpposite(points[2]));
					lines.add(new Line(points[1], points[2]).setOpposite(points[0]));
					lines.add(new Line(points[2], points[0]).setOpposite(points[1]));
					for (int x = minx; x <= maxx; x += 4) {
						for (int y = miny; y <= maxy; y += 4) {
							boolean fits = true;
							Point point = new Point(x, y);
							test:
							for (Line line : lines) {
								if (line.getWhichSide(point) == Side.OUT) {
									fits = false;
									break test;
								}
							}
							if (fits) {
								fill.add(point);
							}
						}
					}
				}
			}
			
		});
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Point point : points) {
			if (point != null) {
				g.setColor(Color.RED);
				g.fillOval(point.x - 2, point.y - 2, 4, 4);
			}
		}
		if (length == 3) {
			g.setColor(Color.BLACK);
			g.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);
			g.drawLine(points[1].x, points[1].y, points[2].x, points[2].y);
			g.drawLine(points[2].x, points[2].y, points[0].x, points[0].y);
			g.setColor(Color.GREEN.darker());
			for (Point p : fill) {
				g.fillOval(p.x - 2, p.y - 2, 4, 4);
			}
			g.setColor(Color.CYAN);
		}
	}
	
}
