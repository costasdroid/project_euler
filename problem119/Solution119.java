package problem119;
/*
 * Not that I am satisfied of the solution, but it works. The only problem is that
 * there is a need to sort the results in order to get the 30th number.
 */

public class Solution119 {

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		final long MAX = 1000000000000000l;
		final double SQMAX = Math.sqrt(MAX);
		
		long sol = 0;

		//int found = 0;
		for (int n = 2; n <= SQMAX; n++) {
			long pro = 1;
			for (int k = 1; k <= Math.log(MAX) / Math.log(n); k++) {
				pro *= n;
				if (sumOf(pro) == n && pro>9) {
					if (pro>sol) sol=pro;
					//found++;
					//System.out.println(pro + ", " + n + "^"+ k+", " + found);
				}
			}
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static int sumOf(long n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}

}
