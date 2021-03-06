package problem014;

public class Solution014 {
	
	public static void main(String[] args) {
		
		Long t1 = System.currentTimeMillis();

		int iterations = 0;
		int number = 1;
		int greater = 0;
		
		for (int i = 2; i <= 1000000; i++) {
			iterations = chainOf(i);
			if (iterations > greater) {
				greater = iterations;
				number = i;
			}
		}
		
		System.out.println(number);
		
		System.out.println("Time: " + (System.currentTimeMillis() - t1) + "ms");
	}

	static int chainOf(long n) {
		
		int count = 0;
		while (n > 1) {
			count++;
			if (n % 2 == 0) n = n / 2; else n = 3 * n + 1;
		}
		return count;
	}
	
}
