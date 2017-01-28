
public class BCDConverter {
	public static String toBCDJava (String inputStr) {
		int baseInt;
		int baseDec;
		StringBuilder sbDec = new StringBuilder("");
		StringBuilder sbTemp = new StringBuilder("");
		StringBuilder sbInt = new StringBuilder("");
		int a;
		
		
		if (inputStr.contains(".")) {
			String[] base10Temp = inputStr.split("\\.");//Split on the Decimal Point

			try {
				baseInt = Integer.parseInt(base10Temp[0]);
			}
			catch (NumberFormatException e) {
				baseInt = 0;
			}
			baseDec = Integer.parseInt(base10Temp[1]);
			
			while (baseInt > 0) { //left of decimal point
				a = baseInt % 10;
				sbTemp.append(BCDConverter.intToBinaryString(a));
				while (sbTemp.length() < 4) {
					sbTemp.insert(0, "0");
				}
				sbTemp.insert(0, " ");
				sbInt.insert(0, sbTemp.toString());
				baseInt /= 10;
				sbTemp.setLength(0);
			}
			
			while (baseDec > 0) { //left of decimal point
				a = baseDec % 10;
				sbTemp.append(BCDConverter.intToBinaryString(a));
				while (sbTemp.length() < 4) {
					sbTemp.insert(0, "0");
				}
				sbTemp.insert(0, " ");
				sbDec.insert(0, sbTemp.toString());
				baseDec /= 10;
				sbTemp.setLength(0);
			}
			
			sbInt.append(" .");
			sbInt.append(sbDec.toString());
			
			//formatting
			sbInt.delete(0, 1);

			return sbInt.toString();
		}
		else {
			baseInt = Integer.parseInt(inputStr);
			while (baseInt > 0) { //left of decimal point
				a = baseInt % 10;
				sbTemp.append(BCDConverter.intToBinaryString(a));
				while (sbTemp.length() < 4) {
					sbTemp.insert(0, "0");
				}
				sbTemp.insert(0, " ");
				sbInt.insert(0, sbTemp.toString());
				baseInt /= 10;
				sbTemp.setLength(0);
			}
			//formatting
			sbInt.delete(0, 1);
			return sbInt.toString();
		}
	}
	
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
}
