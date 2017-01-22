
public class BaseConverter {

	private static String intToBinaryString(int inputInt) {
		int quotient;
		int remainder;
		int outputInt = 0;
		String outputIntR;
		String outputIntString = "";
		;

		while (inputInt != 0) {
			quotient = inputInt / 2;
			remainder = inputInt % 2;

			outputIntString += String.valueOf(remainder);
			inputInt = quotient;
		}
		outputIntR = new StringBuilder(outputIntString).reverse().toString();

		return outputIntR;

	}

	public static String toBase2Java(String base10S) {
		int baseInt;
		int baseDec;
		String baseIntBinary;
		String baseDecBinary;
		String BinaryCombo;

		if (base10S.contains(".")) {
			String[] base10Temp = base10S.split("\\.");

			try {
				baseInt = Integer.parseInt(base10Temp[0]);
			}
			catch (NumberFormatException e) {
				baseInt = 0;
			}
			baseDec = Integer.parseInt(base10Temp[1]);

			baseIntBinary = BaseConverter.intToBinaryString(baseInt);
			baseDecBinary = BaseConverter.intToBinaryString(baseDec);

			BinaryCombo = baseIntBinary + "." + baseDecBinary;

			return BinaryCombo;
		}
		else {
			baseInt = Integer.parseInt(base10S);
			baseIntBinary = BaseConverter.intToBinaryString(baseInt);

			return baseIntBinary;
		}
	}

}
