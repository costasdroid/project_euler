package problem129;

public class Solution129 {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    // the question
    final long N = 1000000l;

    // for help functions
    new Numbers();

    // given than a^x=1 mod n it is certain that x<=φ(n)<=n
    long number = N + (N-1) % 2;

    do {
      // for every odd
      number = number + 2;

      // it must be GCD(n, 10)=1 mod 10 so it cannot be multiple of 5
      if (number % 5 == 0) number = number + 2;

      // R(k)=(10^k - 1)/9 so 10^k = 9k + 1
      long n9 = number * 9;

      // we want > N
      if (Numbers.totient(n9) <= N) continue;

      // count k until 10^k = 1 mod 9n
      long k = 0;

      long mod = 1l;
      do {
        mod = (10 * mod) % n9;
        k++;
      } while (mod != 1);

      if (k > N) {
        break;
      }
    } while (true);

    System.out.println("The solution is: " + number);
    System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
  }

}
