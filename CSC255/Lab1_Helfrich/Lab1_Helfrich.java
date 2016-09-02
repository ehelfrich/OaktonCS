/* Eric Helfrich
 * Lab 1
 * Number of 1's question with recursion
 * 9/2/16
 * CSC 255 0C1
 * */

import java.util.Scanner;

public class Lab1_Helfrich {
	public static int count = 0;

	static public int oneCount(int binNum) {


		if (binNum == 0) { //base case for recursion
			return count;
		}
		else if (binNum % 2 == 0){
			count = oneCount( binNum / 2 ); //will keep going until its odd
			return count;
		}
		else {
			count = oneCount( (binNum - 1) / 2 ) + 1; //Increments count up 1 if number is odd
			return count;
		}


	}

	static public void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int decNum = 0;
		int numOnes = 0;

		System.out.println("Enter a integer to count the number of 1's in the binary representation");
		System.out.print("Enter a integer: ");
		decNum = scan.nextInt();

		numOnes = oneCount(decNum);
		System.out.println("The number of Ones is: " + numOnes);
	}

}
