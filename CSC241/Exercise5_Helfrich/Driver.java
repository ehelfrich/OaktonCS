/*
 * Author: Eric Helfrich
 * Driver Class for checking the amount of swaps and comparisons in a sorting algorithm
 */
public class Driver {
	public static void main(String[] args) {

		System.out.println("Selection Sort");
		Sorts.initValues();
		Sorts.selectionSort();
		System.out.println("Values are sorted: " + Sorts.isSorted());
		System.out.println("Swaps: " + Sorts.numSwaps + "   Comparisons: " + Sorts.numComps);
		System.out.println("");

		System.out.println("Bubble Sort");
		Sorts.initValues();
		Sorts.bubbleSort();
		System.out.println("Values are sorted: " + Sorts.isSorted());
		System.out.println("Swaps: " + Sorts.numSwaps + "   Comparisons: " + Sorts.numComps);
		System.out.println("");

		System.out.println("Short Bubble Sort");
		Sorts.initValues();
		Sorts.shortBubble();
		System.out.println("Values are sorted: " + Sorts.isSorted());
		System.out.println("Swaps: " + Sorts.numSwaps + "   Comparisons: " + Sorts.numComps);
		System.out.println("");

		System.out.println("Insertion Sort");
		Sorts.initValues();
		Sorts.insertionSort();
		System.out.println("Values are sorted: " + Sorts.isSorted());
		System.out.println("Swaps: " + Sorts.numSwaps + "   Comparisons: " + Sorts.numComps);
	}
}
