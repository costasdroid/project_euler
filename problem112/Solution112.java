package problem112;

public class Solution112 {

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		final double P = 0.99;

		int count = 0;
		int sol = 99;
		while (((double) count) / sol < P) {
			sol++;
			if (isBounce(sol))
				count++;
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static boolean isBounce(int n) {

		char[] c = (n + "").toCharArray();

		char c0 = c[0];
		// for up - down
		int i = 1;
		while (i < c.length && c[i] <= c0) {
			c0 = c[i];
			i++;
		}
		while (i < c.length && c[i] >= c0) {
			c0 = c[i];
			i++;
		}
		if (i < c.length)
			return true;

		// for down - up
		c0 = c[0];
		i = 1;
		while (i < c.length && c[i] >= c0) {
			c0 = c[i];
			i++;
		}
		while (i < c.length && c[i] <= c0) {
			c0 = c[i];
			i++;
		}
		if (i < c.length)
			return true;

		return false;
	}
}
