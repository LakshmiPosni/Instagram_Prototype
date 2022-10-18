
public class DateLibrary {

	//Checks is date format is valid
	public static boolean isValidDateFormat(String date) {
		if (date.length() == 10) {
			if (date.charAt(4) == '-' && date.charAt(7) == '-') {
				if (digitCheck(date.substring(0, 4)) && digitCheck(date.substring(5, 7))
						&& digitCheck(date.substring(8, date.length()))) {
					return true;
				}

			}

		}
		return false;
	}

	//This method handles exception if the date given is not an integer
	public static boolean digitCheck(String str) {
		boolean ans = true;
		try {
			Integer.parseInt(str);

		} catch (NumberFormatException e) {
			ans = false;
		}
		return ans;
	}

	//If the string given is not numbers then handles exception
	public static Integer numberCheck(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	//returns year
	public static int getYear(String date) {
		String year = date.substring(0, 4);
		if (isValidDateFormat(date) == true) {
			if (numberCheck(year) >= 0001 && numberCheck(year) <= 9999) {
				return (numberCheck(year));
			}
		}
		return (-1);
	}

	//returns month
	public static int getMonth(String date) {
		String month = date.substring(5, 7);
		if (isValidDateFormat(date) == true) {
			if (numberCheck(month) >= 01 && numberCheck(month) <= 12) {
				return (numberCheck(month));
			}
		}
		return (-1);
	}

	//returns day
	public static int getDay(String date) {
		String day = date.substring(8, date.length());
		if (isValidDateFormat(date) == true) {
			if ((numberCheck(day) >= 01) && (numberCheck(day) <= 31)) {
				return (numberCheck(day));
			}
		}
		return (-1);
	}

	//checks is a year is a leap year
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
			return true;

		} else if ((year % 4 == 0) && (year % 100 != 0)) {
			return true;

		}
		return false;
	}

	//checks if the date give is a valid date
	public static boolean isValidDate(String date) {
		if (isValidDateFormat(date) == true) {
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(5, 7));
			int day = Integer.parseInt(date.substring(8, date.length()));

			if (isLeapYear(year) == false) {
				if ((month >= 1) && (month <= 7) && (month % 2 != 0)) {
					if ((day >= 1) && (day <= 31)) {
						return true;
					}
				} else if ((month >= 4) && (month <= 6) && (month % 2 == 0)) {
					if ((day >= 1) && (day <= 30)) {
						return true;
					}
				} else if ((month == 2)) {
					if ((day >= 1) && (day <= 28)) {
						return true;
					}
				} else if ((month >= 8) && (month <= 12) && (month % 2 == 0)) {
					if ((day >= 1) && (day <= 31)) {
						return true;
					}
				} else if ((month >= 9) && (month <= 11) && (month % 2 != 0)) {
					if ((day >= 1) && (day <= 30)) {
						return true;
					}
				}

			} else if (isLeapYear(year) == true) {
				if ((month >= 1) && (month <= 7) && (month % 2 != 0)) {
					if ((day >= 1) && (day <= 31)) {
						return true;
					}
				} else if ((month >= 4) && (month <= 6) && (month % 2 == 0)) {
					if ((day >= 1) && (day <= 30)) {
						return true;
					}
				} else if ((month == 2)) {
					if ((day >= 1) && (day <= 29)) {
						return true;
					}
				} else if ((month >= 8) && (month <= 12) && (month % 2 == 0)) {
					if ((day >= 1) && (day <= 31)) {
						return true;
					}
				} else if ((month >= 9) && (month <= 11) && (month % 2 != 0)) {
					if ((day >= 1) && (day <= 30)) {
						return true;
					}
				}
			} else {
				return false;
			}
		}
		return false;
	}

}
