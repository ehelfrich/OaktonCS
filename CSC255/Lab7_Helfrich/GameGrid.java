import java.util.Random;

public class GameGrid {
	Random rand = new Random();
	int[][] grid;
	private int p1score = 0;
	private int p2score = 0;
	private int currRow = -1;
	private int currCol = -1;
	private int tempScore = 0;
	private int tableSize = 0;

	public GameGrid(int n) {
		tableSize = n;
		grid = new int[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				grid[i][j] = rand.nextInt(101);
			}
		}
		currRow = rand.nextInt(n); //0 to n-1
		currCol = rand.nextInt(n);
	}

	public void setScore(int player, int score) {
		//Adds score to player score
		if (player == 1) {
			this.p1score += score;
		}
		else {
			this.p2score += score;
		}
	}

	public int getScore(int player) {
		if (player == 1) {
			return p1score;
		}
		else {
			return p2score;
		}
	}

	public int getCurrentRow() {
		return currRow;
	}

	public int getCurrentCol() {
		return currCol;
	}

	public void useSpace(int row, int col, int player) {
		tempScore = grid[row][col];
		if (player == 1) {
			this.setScore(1, tempScore);
		}
		else {
			this.setScore(2, tempScore);
		}
		grid[row][col] = -1;
		currRow = row;
		currCol = col;
	}

	public boolean gameOver() { // true is game over
		for (int i = 0; i < tableSize; ++i) {
			if (grid[currRow][i] != -1) {
				return false;
			}
			else if (grid[i][currCol] != -1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("row/col ");
		for (int k = 0; k < tableSize; ++k) {
			s.append(String.format("%-4s ", k));
		}
		s.append("\n" + "-------|");
		for (int k = 0; k < tableSize; ++k) {
			s.append("----|");
		}
		s.append("\n");
		for (int i = 0; i < tableSize; ++i) {
			s.append(i + "|      ");
			for (int j = 0; j < tableSize; ++j) {
				s.append(String.format("%-5s", grid[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

}
