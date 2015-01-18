package problem030;

public class Solution030 {

	public static void main(String[] args) {
		int n = 5;
		int sum = 0;
		for (int i = 2; i <= 6 * Math.pow(9, n); i++) {
			if (i == (Math.pow((i % 10), n) + Math.pow((i % 100) / 10, n)
					+ Math.pow((i % 1000) / 100, n)
					+ Math.pow((i % 10000) / 1000, n) + Math.pow((i % 100000) / 10000,n) + Math.pow((i % 1000000) / 100000,n)))
				sum = sum + i;
		}
		System.out.println(sum);
	}

}
