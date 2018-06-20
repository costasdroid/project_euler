package problem120;

public class Solution120 {

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		int sol = 0;
		int r = 0;

		for (int a = 3; a <= 1000; a++) {
			r = 0;
			int aSquare = a * a;
			for (int n = 0; n <= a; n++) {
				if ((2 * n * a) % aSquare > r)
					r = (2 * n * a) % aSquare;
			}
			sol += r;
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

}
