package problem088;

import java.util.ArrayList;

public class Solution088 {

	// I guess there would be primes till 1000;
	static final int GUESS = 13000;

	public static void main(String[] args) {
		long t = System.currentTimeMillis();

		final int K = 12000;

		Number[] number = new Number[GUESS];

		// create number objects
		for (int n = 2; n < GUESS; n++) {
			number[n] = new Number(number, n);
		}

		// for (String n : number[12].product)
		// System.out.println(n);
		int[] kss = new int[12001];
		int count = 0;

		for (int num = 4; num <= GUESS; num++) {
			for (String pro : number[num].product) {
				String[] factors = pro.split(" ");
				int sum = 0;
				for (String f : factors) {
					sum += Integer.valueOf(f);
				}
				if (factors.length + (num - sum) <= K
						&& kss[factors.length + (num - sum)] == 0) {
					kss[factors.length + (num - sum)] = num;
					count++;
				}
			}
			if (count == K)
				break;
		}
		
		ArrayList<Integer> ks = new ArrayList<Integer>();
		
		int sol = 0;
		for (int n = 2; n<=K; n++) {
			if (!ks.contains(kss[n])) {
				ks.add(kss[n]);
				sol += kss[n];
			}
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}
}
