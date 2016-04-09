package problem114;

public class Solution114 {

	/*
	 * One of the most difficult so far (made it to excel to understand the
	 * pattern) :) For each repetition you either add a black to the previous
	 * result add a red only if the previous result ended in red add a black red
	 * red to a row 3 results before
	 */
	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		// create array with totals
		long[] total = new long[51];

		// create array with blacks
		long[] blacks = new long[51];

		for (int i = 0; i <= 2; i++) {
			total[i] = 1;
			blacks[i] = 1;
		}

		for (int i = 3; i <= 50; i++) {
			blacks[i] = total[i - 1];
			total[i] = blacks[i] + (total[i - 1] - blacks[i - 1]) + (i - 4 < 0 ? 1 : total[i - 4]);
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + total[50]);
	}

}
