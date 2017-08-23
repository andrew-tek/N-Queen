package queen;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

abstract  class ChessBoard {
	public static int SIZE_OF_BOARD = 22;
	protected Queen [] queens;
	protected int conflictsOnBoard;
	protected Set <String> queensPosition;
	
	public ChessBoard() {
		queens = new Queen [SIZE_OF_BOARD];
		queensPosition = new HashSet<String>();
		for (int i = 0; i < SIZE_OF_BOARD; i++) 
			queens[i] = new Queen();
		conflictsOnBoard = 0;
	}
	public ChessBoard (ChessBoard chessBoard) {
			queens = new Queen [SIZE_OF_BOARD];
			 for (int i = 0; i < queens.length; i++) {
				 this.queens[i] = new Queen(chessBoard.queens[i]);
			 }
			 this.queensPosition = new HashSet<String> (chessBoard.queensPosition);
			 this.conflictsOnBoard = chessBoard.getConflictsOnBoard();
	}
	abstract boolean solve();

	public int getConflictsOnBoard() {
		return conflictsOnBoard;
	}

	public void setConflictsOnBoard(int conflictsOnBoard) {
		this.conflictsOnBoard = conflictsOnBoard;
	}
	//Will check all conflicts on board and update the individual queen on how many they are attacking
	public int checkConflicts() {
		int conflicts = 0;
		for (int i = 0; i < SIZE_OF_BOARD; i++) {
			for (int j = 0; j < SIZE_OF_BOARD; j++) {
				if (queens[i].equals(queens[j])) {
					continue;
				}
				else if (queens[i].getX() == queens[j].getX() || queens[i].getY() == queens[j].getY()
						|| (queens[i].getX() + queens[i].getY()) == (queens[j].getX() + queens[j].getY())
						|| (queens[i].getX() - queens[i].getY()) == (queens[j].getX() - queens[j].getY())) {
					conflicts++;
					queens[i].setQueensAttacking(queens[i].getQueensAttacking() + 1);
				}
			}
		}
		conflictsOnBoard = conflicts;
		return conflicts;
	}
	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < SIZE_OF_BOARD; i++) {
			queens[i].setY(i);
			queens[i].setX(random.nextInt(SIZE_OF_BOARD));
			queensPosition.add(queens[i].toString());	
		}
	}
	public void printBoard() {
		int qString = 0;
		StringBuilder position;
		for (int i = 0; i < SIZE_OF_BOARD; i++) {
			for (int j = 0; j < SIZE_OF_BOARD; j++) {
				position = new StringBuilder();
				if (i < 10)
					position.append("0" + String.valueOf(i));
				else
					position.append(String.valueOf(i));
				if (j < 10) 
					position.append("0" + String.valueOf(j));
				else
					position.append(String.valueOf(j));
				if (queensPosition.contains(position.toString())) {
					qString++;
					System.out.print(" Q ");
				}
				else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
	}
	public void printQueens() {
		for (int i = 0; i < queens.length; i++) {
			System.out.print(" " + queens[i].toString() + " ");
		}
		System.out.println();
	}
	
	
	
	

}
