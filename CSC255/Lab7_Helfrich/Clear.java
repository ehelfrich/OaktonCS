public class Clear {
	static String os = System.getProperty("os.name");

	public static void clearScreen() {
		System.out.print("\033[2J\033[;H");
		//System.out.flush();
	}

}
