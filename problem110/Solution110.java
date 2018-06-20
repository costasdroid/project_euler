package problem110;

import java.util.ArrayList;

public class Solution110 {

	static final long TARGET = 4000000;

	static ArrayList<Integer> primes;
	static ArrayList<Integer> pow;

	static ArrayList<Integer> best;
	static long minimum;

	// keep removing until smallest reached
	static boolean loop = true;

	public static void main(String[] args) {

		// We know that the solution is the number of the dividers of n^2

		// Also if a=p1^a1*p2^a2*... ans=((2a1+1)(2a2+1)...+1)/2

		// We need a maximum number, which is 2*3*4*... so that
		// (2*1+1)(2*1+1)...>7999999=> 3^n>7999999 => n>14

		primes = new ArrayList<Integer>();

		// needed at most primes
		int n = (int) (Math.log(TARGET * 2 - 1) / Math.log(3)) + 1;

		// set minimum
		minimum = (long) Math.pow(3, n);

		// find that primes
		int found = 1;
		primes.add(2);
		int number = 3;
		while (found < n) {
			if (isPrime(number)) {
				found++;
				primes.add(number);
			}
			number += 2;
		}

		// powers of primes
		pow = new ArrayList<Integer>();
		for (int i : primes) {
			pow.add(1);
		}

		findBestPows(primes, 0, 1);

		System.out.println(pow);
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if (n % 3 == 0 || n % 2 == 0)
			return false;
		int i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
			i += 6;
		}
		return true;
	}

	static void findBestPows(ArrayList<Integer> primes, int pos, int prod) {
		if (pos >= primes.size()) return;

		System.out.println("Inside pos = " + pos);		
		for (int i =0; prod < 2 * TARGET - 1; i++) {
			System.out.println("Prime at " + pos + " on power " + i);
			findBestPows(primes, pos - 1, prod * (2*i + 1));
		}
		if (prod > 2 * TARGET - 1 && prod < minimum) {
			System.out.println(minimum + " at " + pow);
		}
		
	}

}
