package bonus;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DriverBonus {
	public static void main(String[] args) throws FileNotFoundException {
		int rows = 1;
		int columns = 1;
		int nPrime = 0;
		int paths = 0;
		PrintWriter outFile = new PrintWriter("output.out");

		outFile.println("This is the output file for #23c BONUS using a 2d array");
		for (nPrime = 1; nPrime <= 15; nPrime++) {
			paths = numPaths(rows, columns, nPrime);
			outFile.println("number of paths " + nPrime + ": " + paths);
		}

		outFile.close();

	}

	static private int numPaths(int row, int col, int n) {
		int[][] grid = new int[n][n];

		for (int i = 0; i < row; ++i) { // initialize grid to 0
			for (int j = 0; j < col; ++j) {
				grid[i][j] = 0;
			}
		}

		for (int i = 0; i < n; ++i) { // initialize outer row and column to 1;
			grid[i][n - 1] = 1;
			grid[n - 1][i] = 1;
		}

		for (int i = n - 2; i >= 0; --i) { // i = row and j = col
			for (int j = n - 2; j >= 0; --j) {
				grid[i][j] = grid[i][j + 1] + grid[i + 1][j];
			}
		}
		return grid[0][0];
	}
}
