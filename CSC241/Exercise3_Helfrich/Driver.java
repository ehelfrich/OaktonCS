/*
*Eric Helfrich Exercise 3
*CSC 241
*This is the driver for exercise 3
*
*
*/

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		// 22.A)
		System.out.println("Now conducting test of 22.A)");
		System.out.println("What is the next Palindromic year after 2002?");
		System.out.println(Problem.nextPalindromeYear(2002));

		// 22.B)
		System.out.println("\nNow conducting test of 22.B)");
		System.out.println("What is the first palindromic date of the 21st Century");
		System.out.println(Problem.nextPalindromicDate(2000, 0, 1));

		// 22.C)
		System.out.println("\nNow conducting test of 22.C)");
		System.out.print(
				"Enter in a year in format YYYY to determine the Palindromic date(s) \nin MMDDYYYY format in that year: ");
		@SuppressWarnings("resource")
		Scanner conIn = new Scanner(System.in);
		int testYear = conIn.nextInt();
		System.out.println("\n" + Problem.palindromicDates(testYear));

	}

}
