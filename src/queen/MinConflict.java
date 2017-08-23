package queen;

import java.util.Random;


public class MinConflict extends ChessBoard{
	protected int steepX;
	protected int steepY;
	protected int minConflicts;
	public MinConflict() {
		super();
		steepX = 0;
		steepY = 0;
		minConflicts = 0;
	}
	public MinConflict(MinConflict mc) {
		super(mc);
		steepX = mc.getSteepX();
		steepY = mc.getSteepY();
		minConflicts = mc.minConflicts;
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

	public int getMinConflicts() {
		return minConflicts;
	}

	public void setMinConflicts(int minConflicts) {
		this.minConflicts = minConflicts;
	}
	
	public int calculateMoves(int selction) {
		MinConflict temp;
		minConflicts = conflictsOnBoard;
		int conflicts = conflictsOnBoard;
			for (int j = 0; j < SIZE_OF_BOARD; j++) {
			temp = new MinConflict(this);
			temp.queensPosition.remove(temp.queens[selction].toString());
			temp.queens[selction].setX(j);
			temp.queens[selction].setY(selction);
			temp.queensPosition.add(temp.queens[selction].toString());
			conflicts = temp.checkConflicts();
			if (conflicts < minConflicts && !temp.queensPosition.equals(queensPosition)) {
				minConflicts = conflicts;
				steepX = j;
				steepY = selction;
			}
		}
		queensPosition.remove(queens[steepY].toString());
		queens[steepY].setX(steepX);
		queens[steepY].setY(steepY);
		queensPosition.add(queens[steepY].toString());
//		this.printBoard();
		return this.checkConflicts();
		
	}

	@Override
	boolean solve() {
		minConflicts = conflictsOnBoard;
//		System.out.println("CHECK HERE: " + conflictsOnBoard);
		int maxAttempt = 100;
		for (int i = 0; i < maxAttempt; i++) {
			if (conflictsOnBoard == 0) {
//				System.out.println("SUCCESS");
//				printBoard();
				return true;
			}
			Random random = new Random();
			int selection = random.nextInt(SIZE_OF_BOARD);
			while (queens[selection].getQueensAttacking() == 0)
				selection = random.nextInt(SIZE_OF_BOARD);
			calculateMoves(selection);
		}
//		System.out.println("FAILURE");
		return false;
		
		
	
	}
	

}
