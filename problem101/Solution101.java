package problem101;

import java.math.BigInteger;

public class Solution101 {

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		int degree = 10;

		long[] data = new long[degree + 1];

		for (int n = 1; n <= data.length; n++)
			data[n - 1] = (long) (Math.pow(n, 11) + 1) / (n + 1);

		long sol = 0;
		for (int n = 1; n <= degree; n++)
			sol += fit(data, n, n + 1);

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static long fit(long[] data, int degree, int on) {
		long res = 0;

		BigInteger nom;
		BigInteger den;

		for (int n = 0; n < degree; n++) {
			nom = BigInteger.valueOf(1);
			den = BigInteger.valueOf(1);
			for (int i = 0; i < degree; i++) {
				if (n != i) {
					nom = nom.multiply(BigInteger.valueOf(on - 1 - i));
					den = den.multiply(BigInteger.valueOf(n - i));
				}
			}
			res += Long.valueOf(nom.divide(den).multiply(
					BigInteger.valueOf(data[n]))
					+ "");
		}

		return res;
	}
}
