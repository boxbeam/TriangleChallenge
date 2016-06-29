package redempt.shapefiller;

public class Vector {
	
	public double x;
	public double y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vector add(Vector v) {
		this.x += v.x;
		this.y += v.y;
		return this;
	}
	
	public Vector invert() {
		this.x *= -1;
		this.y *= -1;
		return this;
	}
	
	public Vector multiply(double x, double y) {
		this.x *= x;
		this.y *= y;
		return this;
	}
	
	public Vector multiply(double amount) {
		this.x *= amount;
		this.y *= amount;
		return this;
	}
	
	public Vector divide(double x, double y) {
		this.x /= x;
		this.y /= y;
		return this;
	}
	
	public Vector divide(double amount) {
		this.x /= amount;
		this.y /= amount;
		return this;
	}
	
	public Vector normalize() {
		double length = Math.abs(getLength());
		x /= length;
		y /= length;
		return this;
	}
	
	public Vector setLength(double length) {
		return normalize().multiply(length);
	}
	
	public Vector subtract(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public Vector subtract(Vector v) {
		this.x -= v.x;
		this.y -= v.y;
		return this;
	}
	
	public Vector add(double amount) {
		this.x += amount;
		this.y += amount;
		return this;
	}
	
	public Vector subtract(double amount) {
		this.x -= amount;
		this.y -= amount;
		return this;
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vector clone() {
		return new Vector(x, y);
	}
	
	
}
