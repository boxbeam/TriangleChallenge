package redempt.shapefiller;

public class Location {
	
	double x;
	double y;
	
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Location add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Location add(Location v) {
		this.x += v.x;
		this.y += v.y;
		return this;
	}
	
	public Location add(Vector v) {
		this.x += v.x;
		this.y += v.y;
		return this;
	}
	
	public Location multiply(double x, double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	public Location multiply(double amount) {
		this.x *= amount;
		this.y *= amount;
		return this;
	}
	
	public Location subtract(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public Location subtract(Location v) {
		this.x -= v.x;
		this.y -= v.y;
		return this;
	}
	
	public Location add(double amount) {
		this.x += amount;
		this.y += amount;
		return this;
	}
	
	public Location subtract(double amount) {
		this.x -= amount;
		this.y -= amount;
		return this;
	}
	
	public Vector toVector() {
		return new Vector(x, y);
	}
	
	public Location clone() {
		return new Location(x, y);
	}
	
	public Location divide(double x, double y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	public Location divide(double amount) {
		this.x /= amount;
		this.y /= amount;
		return this;
	}
	
	public double distance(Location loc) {
		double dx = Math.pow(loc.x - this.x, 2);
		double dy = Math.pow(loc.y - this.y, 2);
		return Math.sqrt(dx + dy);
	}
	
}
