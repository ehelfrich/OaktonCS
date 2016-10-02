import java.util.Scanner;

public class Drive {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner conIn = new Scanner(System.in);
		// SumOfK k;
		// boolean result = false;
		int[] kList;
		Integer[] newKList;
		int size;
		int sum;

		System.out.println("This program inputs an array and determines if the \n"
				+ "sum of any of the elements is equal to a value you input\n");

		System.out.println("Enter in the size of the number of elements in the array");
		size = conIn.nextInt();
		kList = new int[size];

		// k = new SumOfK(size); //Construct object to hold array values
		System.out.println("Enter in the elements of the array");
		for (int i = 0; i < size; ++i) {
			System.out.println("Enter a number: ");
			kList[i] = conIn.nextInt();
		}

		System.out.println("Enter the number to compare the sum of the values to");
		sum = conIn.nextInt();

		System.out.println("Please select which algorithm you wish to run: \n" + "1) O(N2) Algorithm\n"
				+ "2) O(N Log N) Algorigthm");
		int choice = conIn.nextInt();
		// Switch for the choices
		switch (choice) {
		case 1:
			System.out.println(SumOfK.On2K(kList, sum));
			break;
		case 2:
			// System.out.println("MergeSort Generic Test");
			newKList = SumOfK.toObject(kList); // Wrapper for int[] in order to
												// sort with generic algorithm
			SumOfK.<Integer>mergeSort(newKList);
			// for testing the outcome of the sort
			/*
			 * for (int i = 0; i < size; ++i) { System.out.println(newKList[i] +
			 * " "); }
			 */
			kList = SumOfK.toPrimitive(newKList);// unwrap Integer[] to pass to
													// the Nlog(n) method
			System.out.println(SumOfK.ONLogN(kList, sum));

		}
	}
}
