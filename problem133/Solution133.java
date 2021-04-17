public class Solution133 {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    // composite numbers found
    int found = 0;
    // keep track of sum (note that 2+3+5 is initial as they break the rule of modulo 1)
    int sum = 10;

    // create the first PRS primes using sieve
    int PRS = 100000;
    boolean[] primes = sieve(PRS);

    for (int p = 2; p <= PRS; p++) {
      // if is composite continue
      if (primes[p]) continue;

      // find the order of p on 10 (i.e. 10^ord = 1 mod p)
      int mod = 1;
      int k = 0;

      do {
        k++;
        mod = (mod * 10) % p;
      } while(mod > 1);

      // if the order divides 10^n (i.e. is of form 2^k * 2^m) a wanted prime is found
      if (!reduced(k)) {
        // System.out.println(p + " took " + k + " ->> " + (System.currentTimeMillis() - t1) + "ms");
        sum = sum + p;
        found++;
      }
    }

    System.out.println("The solution is: " + sum);
    System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
  }

  static boolean[] sieve(int n) {
    boolean[] comp = new boolean[n + 1];
    int last = (int) n / 2;
    for (int i = 2; i < last + 1; i++) {
      if (comp[i]) continue;
      for (int j = 2 * i; j < n; j += i) {
        comp[j] = true;
      }
    }

    return comp;
  }

  static boolean reduced(int n) {
    while (n % 2 == 0) {
      n = n / 2;
    };

    while (n % 5 == 0) {
      n = n / 5;
    };

    return (n == 1);
  }

}
