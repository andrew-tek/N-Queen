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
				System.out.println("GOT IT");
				return true;
			}
			
			tempMinConflicts = minConflicts;
			this.calculateMoves();
//			System.out.println("HERE" + tempMinConflicts + "   " + minConflicts);
		}
	
		
//		printBoard();
//		System.out.println("STUCK" + this.getConflictsOnBoard());
		return false;
	}
	public int calculateMoves() {
		SteepestClimb temp;
		minConflicts = conflictsOnBoard;
		SteepestClimb copy = new SteepestClimb(this);
		int conflicts = conflictsOnBoard;
		
		for (int i = 0; i < SIZE_OF_BOARD; i++) {
//			System.out.println();
			for (int j = 0; j < SIZE_OF_BOARD; j++) {
				temp = new SteepestClimb(copy);
//				System.out.println("SET BEFORE ANY REMOVE: " + temp.queensPosition.toString());
//				System.out.println("PRINT QUEEN:");
//				temp.printQueens();
//				System.out.println("ATTEMPTING TO REMOVE: " + temp.queens[i].toString());
				temp.queensPosition.remove(temp.queens[i].toString());
//				System.out.println("SET AFTER REMOVE: " + temp.queensPosition.toString());
//				System.out.println("BEFORE: " + temp.queens[i].toString());
//				System.out.println("BEFORE");
//				printQueens();
				temp.queens[i].setX(j);
				temp.queens[i].setY(i);
//				System.out.println("NEW QUEEN: " + temp.queens[i].toString());
//				System.out.println("AFTER");
//				printQueens();
//				System.out.println("AFTER: " + temp.queens[i].toString());
				temp.queensPosition.add(temp.queens[i].toString());
//				System.out.println("LAST ADD: " + temp.queensPosition.toString());
//				temp.printBoard();
//				System.out.println("# of conflicts " + conflicts + " ");
				conflicts = temp.checkConflicts();
//				System.out.println("# of Conflicts: " + conflicts );
				if (conflicts < minConflicts && !temp.queensPosition.equals(queensPosition)) {
					minConflicts = conflicts;
					steepX = j;
					steepY = i;
				}
//				System.out.println();
			}
//			System.out.println();
		}
//		System.out.println("Min conflict: " + minConflicts + " " + steepX + " " + steepY + "\n\n");
		queensPosition.remove(queens[steepY].toString());
		queens[steepY].setX(steepX);
		queens[steepY].setY(steepY);
		queensPosition.add(queens[steepY].toString());
//		this.printBoard();
		return this.checkConflicts();
		
	}
	
}
