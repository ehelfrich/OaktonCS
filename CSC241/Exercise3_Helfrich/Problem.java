/*
*Eric Helfrich Exercise 3
*CSC 241
*This class contains 3 methods for the three parts of question 22
*
*
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Problem {
	public static String nextPalindromeYear(int startYear) {
		startYear++; // Moves the start Year to the next year to check
		String yearStr = String.valueOf(startYear);

		while (!Palindrome.test(yearStr)) {
			++startYear;
			yearStr = String.valueOf(startYear);
		}

		return yearStr;
	}

	/*
	 * May 2, 2050 is a Palindromic Date 05022050
	 */
	public static String nextPalindromicDate(int Startyear, int Startmonth, int Startdate) {
		String currDateStr = " ";
		SimpleDateFormat sdf = new SimpleDateFormat("MMddYYYY");
		Calendar calendar = new GregorianCalendar(Startyear, Startmonth, Startdate);
		currDateStr = sdf.format(calendar.getTime());

		while (!Palindrome.test(currDateStr)) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			currDateStr = sdf.format(calendar.getTime());
		}
		return currDateStr;
	}

	public static String palindromicDates(int year) {
		String currDateStr = " ";
		String palinDates = "";

		SimpleDateFormat sdf = new SimpleDateFormat("MMddYYYY");
		Calendar calendar = new GregorianCalendar(year, 0, 1);
		Calendar endDate = new GregorianCalendar(year + 1, 1, 0);

		while (calendar.before(endDate)) {
			currDateStr = sdf.format(calendar.getTime());
			if (Palindrome.test(currDateStr)) {
				palinDates += currDateStr + " ";
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		if (palinDates == "") {
			return "No palindromic dates in " + year;
		}
		else {
			return palinDates;
		}

	}
}
