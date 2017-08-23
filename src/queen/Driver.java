package queen;

public class Driver {

	public static void main(String[] args) {
		int testCases = 500;
		double averageTimeSteep = 0, averageTimeMinConflict = 0, timeBefore = 0, duration = 0;
		int solve = 0;
		for (int i = 0; i < testCases; i++) {
			SteepestClimb steepest = new SteepestClimb();
			steepest.generateBoard();
			steepest.checkConflicts();
			steepest.calculateMoves();
			timeBefore = System.nanoTime();
			if (steepest.solve())
				solve++;
			duration = System.nanoTime() - timeBefore;
			averageTimeSteep += duration;
		}
		averageTimeSteep /= testCases;
		averageTimeSteep *= 1000000000;
		
		double average = (double)solve /  (double) testCases;
		average *= 100;
		System.out.println("Generating Steepest Hill Climb");
		System.out.println(solve + " solved out of " + testCases);
		System.out.println(average + "% solved");
		System.out.println("Average Time Taken: " + averageTimeSteep + " s");

		int minConflictSuccess = 0;
		for (int i = 0; i < testCases; i++) {
			MinConflict minConflict = new MinConflict();
			minConflict.generateBoard();
			minConflict.checkConflicts();
			timeBefore = System.nanoTime();
			if (minConflict.solve())
				minConflictSuccess++;
			duration = System.nanoTime() - timeBefore;
			averageTimeMinConflict += duration;
		}
		averageTimeMinConflict /= testCases;
		averageTimeMinConflict *= 1000000000;
		System.out.println("Generating Min Conflict Cases");
		System.out.println(minConflictSuccess + " solved out of " + testCases);
		average = (double)minConflictSuccess /  (double) testCases;
		average *= 100;
		System.out.println( average  + "% solved");
		System.out.println("Average Time Taken: " + averageTimeMinConflict + " s");
		
	}

}
