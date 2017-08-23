package queen;

public class Driver {

	public static void main(String[] args) {
		int solve = 0;
		for (int i = 0; i < 100; i++) {
			SteepestClimb test = new SteepestClimb();
			test.generateBoard();
//			test.printBoard();
//			test.printQueens();
			test.checkConflicts();
			test.calculateMoves();
			if (test.solve())
				solve++;
		}
		double average = solve / 1000.0;
		average *= 100;
		System.out.println(solve + " solved");
		System.out.println(average + "% solved");

	}

}
