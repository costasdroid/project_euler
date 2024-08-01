package problem125;

import java.util.ArrayList;

public class Solution125 {

	public static void main(String[] args) {
		// For timing
		long t1 = System.currentTimeMillis();
		// Upper bound constrain
		final int N = 100000000;
		// The thing is that some numbers are solutions but can be written with at least two different ways, so keep track of the numbers you find
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		// the usual solution variable
		long sol = 0;
		// brute force from any beggining number (1)
		for (int i = 1; i <= Math.sqrt(N); i++) {
			// keep track of the square sums
			int sum = 0;
			// (1) => to any ending number
			for (int j = i; sum <= N; j++) {
				sum = sum + j * j;
				// test if is palindrome, less than boundery, at least two concecutive and unique
				if (isPalindrome(sum + "") && sum <= N && j > i && numbers.indexOf(sum) < 0) {
					numbers.add(sum);
					// System.out.println("from " + i + " to " + j + " to total " + sum);
					sol += sum;
				}
			}
		}
		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	public static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; ++i) {
			if (str.charAt(i) != str.charAt(n - i - 1)) return false;
		}
		return true;
	}
}
