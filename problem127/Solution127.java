import java.util.Arrays;

public class Solution127 {

	public static void main(String[] args) {
		// For timing
		long t1 = System.currentTimeMillis();

		final int N = 120000;

		long[] rads = new long[N + 1];

		// there is a need for all radicals precomputed
		for (int i = 1; i <= N; i++) {
			rads[i] = rad(i);
		}

		// System.out.println(Arrays.toString(rads));

		long sol = 0;

		// Does not work (high complexity)

		// for (int a = 1; a < N / 2; a++) {
		//  for (int b = a + 1; b < N - a; b++) {
		//    if (rads[a + b] < a + b) {
		//      if (GCD(rads[a], rads[b]) == 1 && GCD(rads[a], rads[a + b]) == 1 && GCD(rads[b], rads[a + b]) == 1) {
		//        if (rads[a] * rads[b] * rads[(a + b)] < a + b) {
		//          sol += a + b;
		//          // if (a % 100 == 0)
		//          // System.out.println(a + ", " + b + ", " + (a + b));
		//        }
		//      }
		//    }
		//  }
		// }

		// I iterate over c
		for (int c = 1; c < N; c++) {
			// if rads[c]=c (it holds rads[a]rads[b]>1) so no abc-hit
			if (rads[c] < c / 2) {
				// iterate over all a
				for (int a = 1; a < c / 2; a++) {
					// conditions
					if (rads[a] * rads[c - a] * rads[c] < c && GCD(rads[a], rads[c - a]) == 1 && GCD(rads[a], rads[c]) == 1 && GCD(rads[c - a], rads[c]) == 1) {
						sol += c;
					}
				}
			}
		}

		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	public static long rad(long n) {
		long rad = 1;
		for (int i = 2; i <= n / i; i++) {
			if (n % i == 0) {
				rad *= i;
				while (n % i == 0) {
					n /= i;
				}
			}
		}
		rad *= n;
		return rad;
	}

	public static long GCD(long a, long b) {
		if (b == 0) return a;
		return GCD(b, a % b);
	}

}
