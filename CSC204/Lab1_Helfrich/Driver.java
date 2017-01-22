import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String inputNum;
		String outputNum;
		boolean flagBool = true;
		char flagString;

		while (flagBool == true) {

			System.out.println("Enter in the Number you wish to convert");
			inputNum = conIn.nextLine();
			outputNum = BaseConverter.toBase2Java(inputNum);
			System.out.println(outputNum);

			System.out.println("Would you like to enter another number? (y/n)");
			flagString = conIn.nextLine().charAt(0);
			if (flagString == 'y') {
				flagBool = true;
			}
			else if (flagString == 'n') {
				flagBool = false;
			}
			else {
				flagBool = false;
				System.out.println("Invalid Input");
			}
		}

		System.out.println("Terminating Program......Done");
		conIn.close();
	}
}
