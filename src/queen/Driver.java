package queen;

public class Driver {

	public static void main(String[] args) {
		int solve = 0;
		for (int i = 0; i < 100; i++) {
			SteepestClimb steepest = new SteepestClimb();
			steepest.generateBoard();
//			steepest.printBoard();
//			steepest.printQueens();
			steepest.checkConflicts();
			steepest.calculateMoves();
			if (steepest.solve())
				solve++;
		}
		double average = solve / 100.0;
		average *= 100;
		System.out.println(solve + " solved");
		System.out.println(average + "% solved");

		int minConflictSuccess = 0;
		for (int i = 0; i < 100; i++) {
			MinConflict minConflict = new MinConflict();
			minConflict.generateBoard();
			minConflict.checkConflicts();
			if (minConflict.solve())
				minConflictSuccess++;
		}
		System.out.println("# Solved: " + minConflictSuccess);
		System.out.println(minConflictSuccess + "% solved");
		
	}

}
