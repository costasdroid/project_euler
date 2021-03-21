public class Solution128 {

	public static void main(String[] args) {
		// For timing
		long t1 = System.currentTimeMillis();

		Node node1 = new Node();

		int sol = 1;
		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	static boolean isPrime(long n) {
		if(n < 2) return false;
		if(n == 2 || n == 3) return true;
		if(n % 2 == 0 || n % 3 == 0) return false;
		long sqrtN = (long)Math.sqrt(n) + 1;
		for(long i = 6L; i <= sqrtN; i += 6) {
			if(n % (i - 1) == 0 || n % (i + 1) == 0) return false;
		}
		return true;
	}

}
