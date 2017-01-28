
public class BaseConverter {

	private static String intToBinaryString(int inputInt) {
		int quotient;
		int remainder;
		//int outputInt = 0;
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
	private static String DecIntToBinaryString (float inputFloat) {
		int loopFlag = 0;
		StringBuilder sb = new StringBuilder("");
		while (inputFloat != 0 && loopFlag < 5){
			inputFloat = inputFloat * 2;
				if (inputFloat >= 1) {
					sb.append("1");
					inputFloat -= 1;
				}
				else {
					sb.append("0");
				}
			++loopFlag;
			
		}
		return sb.toString();	
	}

	public static String toBase2Java(String base10S) {
		int baseInt;
		float baseDec;
		String baseIntBinary;
		String baseDecBinary;
		String BinaryCombo;
		String base10DecTemp;
		StringBuilder SbDec = new StringBuilder("");
		if (base10S.contains(".")) {
			String[] base10Temp = base10S.split("\\.");

			try {
				baseInt = Integer.parseInt(base10Temp[0]);
			}
			catch (NumberFormatException e) {
				baseInt = 0;
			}
			SbDec.append(base10Temp[1]);
			SbDec.insert(0, ".");
			base10DecTemp = SbDec.toString();
			baseDec = Float.parseFloat(base10DecTemp);

			baseIntBinary = BaseConverter.intToBinaryString(baseInt);
			baseDecBinary = BaseConverter.DecIntToBinaryString(baseDec);

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
