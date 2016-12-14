/*
 * Author: Eric Helfrich
 * Driver Class for checking the amount of swaps in a sorting algorithm
 */
public class Driver {
	public static void main(String[] args) {

		Sorts.initValues();
		Sorts.printValues();
		System.out.println("values is sorted: " + Sorts.isSorted());
		System.out.println();

		// make call to sorting method here (just remove //)
		Sorts.selectionSort();

		// shortBubble();
		// insertionSort();
		// mergeSort(0, SIZE - 1);
		// quickSort(0, SIZE - 1);
		// heapSort();

		Sorts.printValues();
		System.out.println("values is sorted: " + Sorts.isSorted());
		System.out.println("Number of swaps: " + Sorts.numSwaps);
		System.out.println();

		//		System.out.println("\n\nBubbleSort\n");
		//
		//		Sorts.initValues();
		//		Sorts.printValues();
		//		System.out.println("values is sorted: " + Sorts.isSorted());
		//		System.out.println();
		//
		//		Sorts.resetSwapCount();
		//		Sorts.bubbleSort();
		//
		//		Sorts.printValues();
		//		System.out.println("values is sorted: " + Sorts.isSorted());
		//		System.out.println("Number of swaps: " + Sorts.numSwaps);
		//		System.out.println();
	}
}
