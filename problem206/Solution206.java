public class Solution206 {

	static long sol;

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		construct(0, 1);
		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	static void construct(long n, int depth) {
		if (depth == 10) {
			//System.out.println(n);
			long s = (long) Math.sqrt(n);
			if (s * s == n) sol = s;
			return;
		};
		for (int i = 0; i < 10; i++) {

			construct(10 * (10 * (n + depth) + i), depth + 1);
			// System.out.println("construct " + i + ", " + (depth + 1));

		}
		return;
	}
}
