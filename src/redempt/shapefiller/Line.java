package redempt.shapefiller;

import java.awt.Point;

public class Line {
	
	Point start;
	Point end;
	Point opposite = null;
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line setOpposite(Point p) {
		opposite = p;
		return this;
	}
	
	public Side getMajorDirection() {
		double xdiff = Math.abs(end.x - start.x);
		double ydiff = Math.abs(end.y - start.y);
		if (xdiff > ydiff) {
			return Side.HORIZONTAL;
		} else {
			return Side.VERTICAL;
		}
	}
	
	public Side getWhichSide(Point p) {
		if (opposite == null) {
			return null;
		}
		Point midpoint = getMidpoint();
		Vector vec = new Vector(end.y - start.y, (end.x - start.x)  * -1);
		vec.setLength(50);
		Point inside = null;
		Point outside = null;
		Point p1 = midpoint.getLocation();
		Point p2 = midpoint.getLocation();
		p1.x = (int) ((double) p1.x + vec.x);
		p1.y = (int) ((double) p1.y + vec.y);
		p2.x = (int) ((double) p2.x - vec.x);
		p2.y = (int) ((double) p2.y - vec.y);
		if (opposite.distance(p1) < opposite.distance(p2)) {
			inside = p1;
			outside = p2;
		} else {
			inside = p2;
			outside = p1;
		}
		if (p.distance(inside) <= p.distance(outside)) {
			return Side.IN;
		} else {
			return Side.OUT;
		}
	}
	
	public Point getMidpoint() {
		double maxx = Math.max(start.x, end.x);
		double minx = Math.min(start.x, end.x);
		double maxy = Math.max(start.y, end.y);
		double miny = Math.min(start.y, end.y);
		double diffx = (maxx - minx) / 2;
		double diffy = (maxy - miny) / 2;
		minx += diffx;
		miny += diffy;
		return new Point((int) minx, (int) miny);
	}
	
	public double getSlope() {
		return ((double) end.y - (double) start.y) / ((double) end.x - (double) start.x);
	}
	
	public double getInvertedSlope() {
		return (end.x - start.x) / (end.y - start.y);
	}
	
	public double getY(double x) {
		return (x * getSlope()) + getYIntercept();
	}
	
	public double getX(double y) {
		return ((double) start.y - getYIntercept()) / getSlope();
	}
	
	public double getXIntercept() {
		return (getYIntercept() * -1) / getSlope();
	}
	
	public double getYIntercept() {
		return start.y - (start.x * getSlope());
	}
	
	public Side getSide(Point p) {
		Boolean up = null;
		Boolean right = null;
		if (p.x > getX(p.y)) {
			right = true;
		}
		if (p.x < getX(p.y)) {
			right = false;
		}
		if (p.y > getY(p.x)) {
			up = true;
		}
		if (p.y < getY(p.x)) {
			up = false;
		}
		if (up == null && right == null) {
			return Side.ON;
		}
		if (right == null && up) {
			return Side.UP;
		}
		if (right == null && !up) {
			return Side.DOWN;
		}
		if (up == null && right) {
			return Side.RIGHT;
		}
		if (up == null && !right) {
			return Side.LEFT;
		}
		if (up && right) {
			return Side.UP_RIGHT;
		}
		if (!up && right) {
			return Side.DOWN_RIGHT;
		}
		if (up && !right) {
			return Side.UP_LEFT;
		}
		if (!up && !right) {
			return Side.DOWN_LEFT;
		}
		return null;
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
	}
	
}
