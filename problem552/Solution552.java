package problem552;

import java.math.BigInteger;

public class Solution552 {

	public static void main(String[] args) {

		long t = System.currentTimeMillis();
		
		BigInteger sol = BigInteger.valueOf(1);
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				sol = sol.add(BigInteger.valueOf(1));
			}	
		}
		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

}
