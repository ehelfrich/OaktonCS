
/*
 * Driver for Heap Testing
 * By: Eric Helfrich
 * Lab 5 CSC 255
 */

import java.util.Arrays;
import java.util.Random;

public class Driver {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Integer[] rndmArray = new Integer[100];
		Integer[] sortArray = new Integer[100];
		Integer[] rSortArray = new Integer[100];
		Random randomGenerator = new Random();
		for (int i = 0; i < 100; ++i) {
			rndmArray[i] = randomGenerator.nextInt(1000);
		}
		//Clone and sort array
		sortArray = rndmArray.clone();
		Arrays.sort(sortArray);
		//Clone sort Array and reverse sort it
		rSortArray = sortArray.clone();
		for (int i = 0; i < rSortArray.length / 2; ++i) {
			int temp = rSortArray[i];
			rSortArray[i] = rSortArray[rSortArray.length - (i + 1)];
			rSortArray[rSortArray.length - (i + 1)] = temp;
		}

		System.out.println("This Driver compares the running time of inserting\n"
				+ "and building heaps with sorted, reverse-ordered,\nand random inputs\n\n");

		System.out.println("The testing arrays are size 100. \nCreation and sorting of the arrays\n"
				+ "are not included in the time calculations\n");

		//Insert into heap with sorted numbers
		System.out.print("Insert a sorted array into a heap took: ");
		BinaryHeap<Integer> sortInsert = new BinaryHeap<Integer>(100);
		long sortInsertTime = System.nanoTime();
		for (int i = 0; i < 100; ++i) {
			sortInsert.insert(sortArray[i]);
		}
		System.out.print(sortInsertTime = System.nanoTime() - sortInsertTime);
		System.out.println(" nanoseconds");

		//Insert Reverse Sort into heap
		System.out.print("Insert a reverse sorted array into a heap took: ");
		BinaryHeap<Integer> RevSortInsert = new BinaryHeap<Integer>(100);
		long revSortInsertTime = System.nanoTime();
		for (int i = 0; i < 100; ++i) {
			RevSortInsert.insert(rSortArray[i]);
		}
		System.out.print(revSortInsertTime = System.nanoTime() - revSortInsertTime);
		System.out.println(" nanoseconds");

		//Insert Random Sorted Array into a heap
		System.out.print("Insert a random array into a heap took: ");
		BinaryHeap<Integer> randomSortInsert = new BinaryHeap<Integer>(100);
		long randomSortInsertTime = System.nanoTime();
		for (int i = 0; i < 100; ++i) {
			randomSortInsert.insert(rndmArray[i]);
		}
		System.out.print(randomSortInsertTime = System.nanoTime() - randomSortInsertTime);
		System.out.println(" nanoseconds");

		System.out.println(" ");

		//Build Heap with Sorted array
		System.out.print("Build Heap with a sorted array took: ");
		long sortBuildTime = System.nanoTime();
		BinaryHeap<Integer> sortBuild = new BinaryHeap<Integer>(sortArray);
		System.out.print(sortBuildTime = System.nanoTime() - sortBuildTime);
		System.out.println(" nanoseconds");

		//Build Heap with Reverse Sorted array
		System.out.print("Build Heap with a reverse sorted array took: ");
		long revSortBuildTime = System.nanoTime();
		BinaryHeap<Integer> revSortBuild = new BinaryHeap<Integer>(rSortArray);
		System.out.print(revSortBuildTime = System.nanoTime() - revSortBuildTime);
		System.out.println(" nanoseconds");

		//Build Heap with a random array
		System.out.print("Build Heap with a random array took: ");
		long randomSortBuildTime = System.nanoTime();
		BinaryHeap<Integer> RandomsortBuild = new BinaryHeap<Integer>(rndmArray);
		System.out.print(randomSortBuildTime = System.nanoTime() - randomSortBuildTime);
		System.out.println(" nanoseconds");

		System.out.println("\n...Program Complete...");

	}
}
