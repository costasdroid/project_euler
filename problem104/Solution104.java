package problem104;

import java.math.BigInteger;

public class Solution104 {

	public static void main(String[] args) {

		/*
		 * mod 10^9 for the last digits
		 * keep the first 15 digits for the top
		 */
		System.out.println("With method 1:");
		method1();

		/*
		 * Brute force with BigInteger
		 */
		System.out.println("With method 2:");
		method2();

	}

	static void method1() {

		long t = System.currentTimeMillis();

		long b1 = 1, t1 = 1;
		long b2 = 1, t2 = 1;

		int sol = 2;

		do {
			long temp = b1;
			b1 = (b1 + b2) % 1000000000;
			b2 = temp;

			temp = t1;
			t1 += t2;
			t2 = temp;
			while (t1 >= 1000000000000000l) {
				t1 /= 10;
				t2 /= 10;
			}
			sol++;
		} while (!isPandigital(b1 + "")
				|| !isPandigital((t1 + "").substring(0, 9)));

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static void method2() {

		long t = System.currentTimeMillis();

		BigInteger n1 = BigInteger.valueOf(1);
		BigInteger n2 = BigInteger.valueOf(1);
		int sol = 2;
		do {
			BigInteger temp = n1;
			n1 = n1.add(n2);
			n2 = temp;
			sol++;
		} while (!isPandigital(n1.mod(BigInteger.valueOf(1000000000)) + "")
				|| (!isPandigital((n1 + "").substring(0, 9))));

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static boolean isPandigital(String s) {
		for (int i = 1; i <= 9; i++)
			if (!s.contains(i + ""))
				return false;
		return true;
	}
}
