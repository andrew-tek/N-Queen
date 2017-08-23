package queen;


public class SteepestClimb extends ChessBoard {
	protected int steepX;
	protected int steepY;
	protected int minConflicts;
	public SteepestClimb() {
		super();
		steepX = 0;
		steepY = 0;
		minConflicts = 0;
	}

	public SteepestClimb(SteepestClimb sc) {
		super(sc);
		steepX = sc.getSteepX();
		steepY = sc.getSteepY();
		minConflicts = sc.minConflicts;
	}
	public int getSteepX() {
		return steepX;
	}
	public void setSteepX(int steepX) {
		this.steepX = steepX;
	}
	public int getSteepY() {
		return steepY;
	}
	public void setSteepY(int steepY) {
		this.steepY = steepY;
	}
	@Override
	public boolean solve() {
		int tempMinConflicts = minConflicts;
		this.calculateMoves();
		while (tempMinConflicts > minConflicts || tempMinConflicts == 0 ) {
			if (tempMinConflicts == 0) {
				printBoard();
				return true;
			}
			
			tempMinConflicts = minConflicts;
			this.calculateMoves();
		}
	
		return false;
	}
	public int calculateMoves() {
		SteepestClimb temp;
		minConflicts = conflictsOnBoard;
		int conflicts = conflictsOnBoard;
		
		for (int i = 0; i < SIZE_OF_BOARD; i++) {
			for (int j = 0; j < SIZE_OF_BOARD; j++) {
				temp = new SteepestClimb(this);
				temp.queensPosition.remove(temp.queens[i].toString());temp.queens[i].setX(j);
				temp.queens[i].setY(i);temp.queensPosition.add(temp.queens[i].toString());
				conflicts = temp.checkConflicts();
				if (conflicts < minConflicts && !temp.queensPosition.equals(queensPosition)) {
					minConflicts = conflicts;
					steepX = j;
					steepY = i;
				}
			}
		}
		queensPosition.remove(queens[steepY].toString());
		queens[steepY].setX(steepX);
		queens[steepY].setY(steepY);
		queensPosition.add(queens[steepY].toString());
		return this.checkConflicts();
		
	}
	
}
