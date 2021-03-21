import java.util.Arrays;

public class Solution110 {

	static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 37};
	static int[] times = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	static long minimum = 614889782588491410l;
	final static int N = 4000000;

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		least(1, 0);
		System.out.println("The solution is: " + minimum);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	private static void least(long n, int p) {
		int exp = 1;
		for (int i = 0; i < times.length && times[i] > 0; i++) {
			exp = exp * (2 * times[i] + 1);
		}
		if (n < minimum && n > 0) {
			if (exp > 2 * N - 1) {
				if(n < minimum) minimum = n;
				//System.out.println((exp + 1) / 2);
			} else {
				for (int i = p; i < primes.length; i++) {
					if (i > 0 && (times[i - 1] <= times[i])) continue;
					times[i]++;
					least(n * primes[i], i);
					times[i]--;
				}
			}
		}
		return;
	}
}
