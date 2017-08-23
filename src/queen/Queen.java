package queen;


public class Queen {
	protected int x;
	protected int y;
	protected int queensAttacking;
	public Queen() {
		x = 0;
		y = 0;
		queensAttacking = 0;
	}
	public Queen (Queen q) {
		this.x = q.x;
		this.y = q.y;
		this.queensAttacking = q.queensAttacking;
	}
	public boolean equals(Queen q) {
		return (this.x == q.getX() && this.y == q.getY());		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getQueensAttacking() {
		return queensAttacking;
	}
	public void setQueensAttacking(int queensAttacking) {
		this.queensAttacking = queensAttacking;
	}
	@Override
	public String toString() {
		String x = "";
		String y = "";
		if (this.x < 10) {
			 x = "0" + String.valueOf(this.x);
		}
		else
			x = String.valueOf(this.x);
			
		if (this.y < 10) {
			 y = "0" + String.valueOf(this.y);
		}
		else
			y = String.valueOf(this.y);
			
		String s = x + y;
		return s;
	}

}
