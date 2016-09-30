
/***********************************************************
 * Driver for program to count the number of paths in a 2d array
 * By: Eric Helfrich
 * Based of of the code in Object-Oriented Data Structures using Java 3rd edition
 * p. 293-294
 *
 ************************************************************/
package lab4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		int rows = 1;
		int columns = 1;
		int nPrime = 0;
		int paths = 0;
		PrintWriter outFile = new PrintWriter("output.out");

		outFile.println("This is the output file for #23ab using recursion");
		for (nPrime = 1; nPrime <= 15; nPrime++) {
			paths = numPaths(rows, columns, nPrime);
			outFile.println("number of paths " + nPrime + ": " + paths);
		}

		outFile.close();

	}

	static private int numPaths(int row, int col, int n) {
		if (row == n) {
			return 1;
		}
		else if (col == n) {
			return 1;
		}
		else {
			return (numPaths(row + 1, col, n) + numPaths(row, col + 1, n));
		}
	}

}
