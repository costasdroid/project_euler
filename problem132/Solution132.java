package problem132;

public class Solution132 {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    // the question
    final int N = 40;
    final int M = 1000000000;
    // composite numbers found
    int found = 0;
    // keep track of sum
    int sum = 0;

    // create the first PRS primes using sieve
    int PRS = 500000;
    boolean[] primes = sieve(PRS);

    for (int p = 7; p < PRS; p++) {
      // if is composite continue
      if (primes[p]) continue;

      // find the order of p on 10 (i.e. 10^ord = 1 mod p)
      int mod = 1;
      int k = 0;

      do {
        k++;
        mod = (mod * 10) % p;
      } while(mod > 1);

      // if the order divides M a wanted prime is found
      if (M % k == 0) {
        // System.out.println(p + " took ->> " + (System.currentTimeMillis() - t1) + "ms");
        sum = sum + p;
        found++;
      }

      if (found == N) {
        break;
      }
    }

    System.out.println("The solution is: " + sum);
    System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
  }

  static boolean[] sieve(int n) {
    boolean[] comp = new boolean[n];
    int last = (int) n / 2;
    for (int i = 2; i < last + 1; i++) {
      if (comp[i]) continue;
      for (int j = 2 * i; j < n; j += i) {
        comp[j] = true;
      }
    }

    return comp;
  }

}
