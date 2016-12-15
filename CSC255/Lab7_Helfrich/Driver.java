import java.util.Scanner;

public class Driver {
	public static void main(String args[]) {
		int gridSize = 0;
		Scanner conIn = new Scanner(System.in);
		boolean osBool = false;
		boolean loopFlag = true;
		String programInput = "";
		int choiceRow = -1;
		int choiceCol = -1;

		/*
		 * Checks to see if user wants to use the clear screen function
		 */
		System.out.println("Would you like this program to clear the prompt? (y/n)");
		System.out.println("***note this method uses ANSI Escape Codes and does not work in IDEs***");
		while (loopFlag) {

			programInput = conIn.nextLine();
			if (programInput.contains("y")) {
				osBool = true;
				loopFlag = false;
			}
			else if (programInput.contains("n")) {
				osBool = false;
				loopFlag = false;
			}
			else {
				System.out.println("Please enter a valid input");
			}
		}

		System.out.println("Welcome to the MAXIT game!!!!");
		System.out.println("Rules:\nA player must chose a cell in the same row or column as the last picked cell"
				+ "\nThe game ends when there are no more choices in the current row or column");
		System.out.println("Enter the table size for the game: ");
		gridSize = conIn.nextInt();
		GameGrid game = new GameGrid(gridSize);
		System.out.println("Your game board is:");
		System.out.println(game);
		/*
		 * While statement for the turns of the two players. Ends if the game is
		 * seen to be over
		 */
		while (!game.gameOver()) {
			/*
			 * Clear Screen Option
			 */
			if (osBool) {
				Clear.clearScreen();
			}
			System.out.println("The scores are:\nPlayer 1: " + game.getScore(1) + "\nPlayer2: " + game.getScore(2));
			System.out.println("Player 1's Turn");
			System.out.println(game);
			System.out.println("The current Row is " + game.getCurrentRow() + "\nand the current Column is "
					+ game.getCurrentCol());

			System.out.println("Enter your choice");
			System.out.print("Row: ");
			choiceRow = conIn.nextInt();
			System.out.print("Col: ");
			choiceCol = conIn.nextInt();
			System.out.println("");
			if (choiceRow == game.getCurrentRow() || choiceCol == game.getCurrentCol()) {
				loopFlag = false;
			}
			else {
				loopFlag = true;
			}
			while (loopFlag) {
				System.out.println("Please enter a valid cell choice");
				System.out.print("Row: ");
				choiceRow = conIn.nextInt();
				System.out.print("Col: ");
				choiceCol = conIn.nextInt();
				System.out.println("");
				if (choiceRow == game.getCurrentRow() || choiceCol == game.getCurrentCol()) {
					loopFlag = false;
				}
				else {
					loopFlag = true;
				}
			}
			game.useSpace(choiceRow, choiceCol, 1);
			//Check after Player 1 for game over
			if (game.gameOver()) {
				break;
			}
			/*
			 * Player 2's Turn
			 */
			if (osBool) {
				Clear.clearScreen();
			}

			System.out.println("The scores are:\nPlayer 1: " + game.getScore(1) + "\nPlayer2: " + game.getScore(2));
			System.out.println("\nPlayer 2's Turn");
			System.out.println(game);
			System.out.println("The current Row is " + game.getCurrentRow() + "\nand the current Column is "
					+ game.getCurrentCol());

			System.out.println("Enter your choice");
			System.out.print("Row: ");
			choiceRow = conIn.nextInt();
			System.out.print("Col: ");
			choiceCol = conIn.nextInt();
			System.out.println("");
			if (choiceRow == game.getCurrentRow() || choiceCol == game.getCurrentCol()) {
				loopFlag = false;
			}
			else {
				loopFlag = true;
			}
			while (loopFlag) {
				System.out.println("Please enter a valid cell choice");
				System.out.print("Row: ");
				choiceRow = conIn.nextInt();
				System.out.print("Col: ");
				choiceCol = conIn.nextInt();
				System.out.println("");
				if (choiceRow == game.getCurrentRow() || choiceCol == game.getCurrentCol()) {
					loopFlag = false;
				}
				else {
					loopFlag = true;
				}
			}
			game.useSpace(choiceRow, choiceCol, 2);
			System.out.println("The scores are:\nPlayer 1: " + game.getScore(1) + "\nPlayer2: " + game.getScore(2));
		}
		if (osBool) {
			Clear.clearScreen();
		}
		System.out.println("\n\nGame Over!!!\n");
		System.out.println("The scores are:\nPlayer 1: " + game.getScore(1) + "\nPlayer2: " + game.getScore(2));
		if (game.getScore(1) > game.getScore(2)) {
			System.out.println("The Winner is Player 1!!!");
		}
		else if (game.getScore(1) < game.getScore(2)) {
			System.out.println("The Winner is Player 2!!!");
		}
		else {
			System.out.println("It's a tie...That must have been difficult");
		}

	}
}
