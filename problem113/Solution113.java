package problem113;

public class Solution113 {

	/*
	 * The idea is simple: Create a "increasing" matrix 100x9 that each row
	 * represent the digits, each column the leading digit ex. 1 2 3 4 5 6 7 8 9
	 * 1 1 1 1 1 1 1 1 1 1 2 9 8 7 6 5 4 3 2 1 3 45 36 48 21 15 10 6 3 1 ...
	 * 
	 * and a "decreasing" one ex. 9 8 7 6 5 4 3 2 1 1 1 1 1 1 1 1 1 1 1 2 10 9 8
	 * 7 6 5 4 3 2 3 55 45 36 28 21 15 10 6 3 ...
	 * 
	 * and simply add each row to a total. Beware the 111, 222, 333, ..., 1111,
	 * 2222, ... (there are 9 in each row)
	 */

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		long[] inc = new long[9];
		long[] dec = new long[9];

		for (int i = 0; i < 9; i++) {
			inc[i] = 1;
			dec[i] = 1;
		}

		long sum = 9;

		for (int digits = 1; digits <= 99; digits++) {

			sum += inc[8];
			dec[8] = dec[8] + 1;
			sum += dec[8];
			for (int j = 7; j >= 0; j--) {
				inc[j] = inc[j + 1] + inc[j];
				sum += inc[j];
				dec[j] = dec[j + 1] + dec[j];
				sum += dec[j];
			}
			sum -= 9;
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sum + "");
	}

}
