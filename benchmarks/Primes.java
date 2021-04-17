public class Primes {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    int N = 10000000;

    for (int i = 1; i <= N; i *= 10) {
      for (int j = 1; j <= i; j++) {
        isPrime(j);
      }
      System.out.println("For " + i + " numbers it took: " + (System.currentTimeMillis() - t1) + "ms");
      t1 = System.currentTimeMillis();
    }

  }

  static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if (n % 3 == 0 || n % 2 == 0)
			return false;
		long i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
			i += 6;
		}
		return true;
  }
}
