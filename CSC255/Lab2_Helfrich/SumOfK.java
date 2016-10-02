public class SumOfK {

	// O(n^2) algorithm
	public static boolean On2K(int inputA[], int sumK) {

		for (int i = 0; i <= inputA.length - 2; ++i) {
			for (int j = 1; j <= inputA.length - 1; ++j) {
				if (inputA[i] + inputA[j] == sumK) {
					return true;
				}
			}
		}

		return false;
	}

	// @SuppressWarnings("unused")
	public static boolean ONLogN(int a[], int sumK) {
		int leftCount = 0;
		int rightCount = a.length - 1;

		while (leftCount < rightCount) {
			if (a[leftCount] + a[rightCount] == sumK) {
				return true;
			}
			else if (a[leftCount] + a[rightCount] <= sumK) {
				++leftCount;
			}
			else {
				--rightCount;
			}
		}
		return false;

	}

	/*
	 * Method to wrap and unwrap the primitive int type based on
	 * org.apache.commons.lang3.ArrayUtils Built for reusable code and since I
	 * did not want to package the API just for an assignment (I hope this is
	 * OK)
	 */

	public static Integer[] toObject(int[] intArray) {
		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; ++i) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}

	public static int[] toPrimitive(Integer[] IntegerArray) {
		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; ++i) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}

	/*
	 * MergeSort Algorithm Source Code from Data Structures and Algorithm
	 * Analysis in Java 3rd Edition by: Mark Allen Weiss
	 */

	private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a, AnyType[] tmpArray,
			int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}
	}

	// Public Method that you call
	@SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a) {
		AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length - 1);
	}

	private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray,
			int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos].compareTo(a[rightPos]) <= 0) {
				tmpArray[tmpPos++] = a[leftPos++];
			}
			else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}

		while (leftPos <= leftEnd) { // Copy rest of the first half
			tmpArray[tmpPos++] = a[leftPos++];
		}

		while (rightPos <= rightEnd) { // Copy rest of right half
			tmpArray[tmpPos++] = a[rightPos++];
		}

		// Copy TmpArray back
		for (int i = 0; i < numElements; i++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];
		}
	}

}
