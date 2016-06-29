package redempt.shapefiller;

public enum Side {
	UP_RIGHT,
	UP_LEFT,
	DOWN_RIGHT,
	DOWN_LEFT,
	ON,
	UP,
	DOWN,
	LEFT,
	RIGHT,
	VERTICAL,
	HORIZONTAL,
	IN,
	OUT;
	
	public Side[] getDirections() {
		Side[] sides = new Side[2];
		boolean multiple = false;
		if (this == UP_RIGHT) {
			multiple = true;
			sides[0] = UP;
			sides[1] = RIGHT;
		}
		if (this == UP_LEFT) {
			multiple = true;
			sides[0] = UP;
			sides[1] = LEFT;
		}
		if (this == DOWN_RIGHT) {
			multiple = true;
			sides[0] = DOWN;
			sides[1] = RIGHT;
		}
		if (this == DOWN_LEFT) {
			multiple = true;
			sides[0] = DOWN;
			sides[1] = LEFT;
		}
		if (!multiple) {
			sides[0] = this;
		}
		return sides;
	}
	
}
