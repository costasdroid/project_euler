package problem017;

public class Solution017 {

	static String[] units = { "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
			"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	static String[] tenths = { "ten", "twenty", "thirty", "forty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };

	static int count = 0;

	public static void main(String[] args) {
		String[] units = { "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		String[] tenths = { "ten", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety" };

		int count = 0;

		for (int i = 1; i < 1000; i++) {
			if (i % 100 == 0) {
				count = count + units[i / 100 - 1].length()
						+ "hundred".length();
			} else {
				if (i > 100) {
					count = count + units[i / 100 - 1].length()
							+ "hundred".length() + "and".length();
				}
				if (i % 10 == 0) {
					count = count + tenths[(i % 100) / 10 - 1].length();
				} else if (i % 100 < 20) {
					count = count + units[(i % 100) - 1].length();
				} else {
					count = count + units[(i % 10) - 1].length()
							+ tenths[(i % 100) / 10 - 1].length();
				}
			}
		}
		count = count + "onethousand".length();
		System.out.println(count);
	}
}
