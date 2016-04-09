package problem115;

public class Solution115 {

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		final int M = 50;
		final int TARGET = 1000000;

		int length = 0;

		// create array with totals
		long[] total = new long[M + 1];

		// create array with blacks
		long[] blacks = new long[M + 1];

		for (int i = 0; i <= M; i++) {
			blacks[i] = 1;
			total[i] = 1;
		}

		length = M;
		while (total[M] < TARGET) {
			long newBlack = total[M];
			long newTotal = newBlack + (total[M] - blacks[M]) + total[0];
			for (int i = 0; i < M; i++) {
				total[i] = total[i + 1];
				blacks[i] = blacks[i + 1];
			}
			total[M] = newTotal;
			blacks[M] = newBlack;
			length++;
			//System.out.println("Length: " + length + " total: " + newTotal);
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + (length - 1));

	}

}
