package problem131;

public class Solution131 {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    // composite numbers found
    int found = 0;

    // create the first PRS primes using sieve
    int PRS = 100000;
    boolean[] primes = sieve(PRS);

    // n^3 + p n^2 = m^3 => n^3(n+p)/n=m^3 so (n+p)/n must be perfect cube
    // clearly m > n, thus p = (m/n)^2m+n>m, so p>n
    // Thus n + p = a^3 and n = (a-k)^3
    // so p = a^3 -a^3 + 3a^2k - 3ak^2 + k^3
    // p = k(3a^2 - 3ak + k^2) <=> k=1
    // so p = a^3 - (a-1)^3
    int i = 2;
    int temp;
    do {
      temp = 3 * i * i - 3 * i + 1;
      if (temp > PRS) break;
      if (!primes[temp]) {
        found++;
      }
      i++;
    } while (true);

    System.out.println("The solution is: " + found);
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

}
