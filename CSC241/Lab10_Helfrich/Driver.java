import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner conIn = new Scanner(System.in);
		int tableNum = 0;
		int searchNum;
		int searchLoopCount = 1;
		boolean contains = false;
		int i151 = 0;

		System.out.println("Testing hash table searches with linear probing\n\n");

		List<Integer> numPool = new ArrayList<>(); //num 1-100
		for (int i = 1; i <= 100; ++i) {
			numPool.add(i);
		}

		Collections.shuffle(numPool);

		//Integer[] numArray = new Integer[numPool.size()];
		Integer[] numArray = numPool.toArray(new Integer[numPool.size()]);

		//First table of size 7
		LinearProbingHash t7 = new LinearProbingHash(7);
		for (int i = 0; i < 7; ++i) { //0-6
			t7.add(numArray[i]);
		}
		System.out.println("1. Hash Table of Size 7:");
		System.out.println(t7.toString());
		System.out.println("");

		//Second table of size 51
		LinearProbingHash t51 = new LinearProbingHash(51);
		for (int i = 7; i < 58; ++i) { //7-58
			t51.add(numArray[i]);
		}
		System.out.println("2. Hash Table of Size 51:");
		System.out.println(t51.toString());
		System.out.println("");

		//Third table of size 151
		LinearProbingHash t151 = new LinearProbingHash(151);
		for (int i = 58; i < 100; ++i) {
			t151.add(numArray[i]);
		}
		System.out.println("3. Hash Table of Size 151:");
		System.out.println(t151.toString());
		System.out.println("\n\n");

		System.out.println("====================================================================");
		System.out.println("Search for a value in a hash table to get its location");
		do {
			System.out.println("________________________________________________________________");
			System.out.println("\n(Search " + searchLoopCount + " of 10)");
			System.out.println("Enter which Hash table you would like to search: ");
			tableNum = conIn.nextInt();
			while (!(tableNum == 1 || tableNum == 2 || tableNum == 3)) {
				System.out.println("Please choose a valid table number!! (1, 2, 3)");
				tableNum = conIn.nextInt();
			}
			contains = false;
			switch (tableNum) {
			case 1:
				System.out.println("Which number would you like to search for?");
				searchNum = conIn.nextInt();
				while (!contains) {
					for (int i = 0; i < t7.array.length; ++i) {
						if (t7.array[i] == searchNum) {
							contains = true;
							break;
						}
						else {
							contains = false;
						}
					}
					if (contains == false) {
						System.out.println("Please enter a number that is located in the Hash Table!!: ");
						searchNum = conIn.nextInt();
					}
				}
				System.out.println("The number is located at index: " + t7.get(searchNum) + " in the table\n" + "with "
						+ t7.collisions + " collisions");
				searchLoopCount++;
				break;
			case 2:
				System.out.println("Which number would you like to search for?");
				searchNum = conIn.nextInt();
				while (!contains) {
					for (int i = 0; i < t51.array.length; ++i) {
						if (t51.array[i] == searchNum) {
							contains = true;
							break;
						}
						else {
							contains = false;
						}
					}
					if (contains == false) {
						System.out.println("Please enter a number that is located in the Hash Table!!: ");
						searchNum = conIn.nextInt();
					}
				}
				System.out.println("The number is located at index: " + t51.get(searchNum) + " in the table\n" + "with "
						+ t51.collisions + " collisions");
				searchLoopCount++;
				break;
			case 3:
				System.out.println("Which number would you like to search for?");
				searchNum = conIn.nextInt();
				while (!contains) {
					try {
						search: while (i151 < t151.array.length) {
							if (t151.array[i151] == searchNum) {
								contains = true;
								break search;
							}
							else {
								contains = false;
								i151++;
							}
						}
						if (contains == false) {
							System.out.println("Please enter a number that is located in the Hash Table!!: ");
							searchNum = conIn.nextInt();
							i151 = 0;
						}
					}
					catch (NullPointerException e) {
						i151++;
					}
				}
				System.out.println("The number is located at index: " + t151.get(searchNum) + " in the table\n"
						+ "with " + t151.collisions + " collisions");
				searchLoopCount++;
				break;

			}
		} while (searchLoopCount != 11);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\nThis ends the testing driver!!!!!!!!!!!");
	}
}
