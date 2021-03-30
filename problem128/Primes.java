public class Primes {
  static boolean[] primesArray;

  public Primes (int n) {
    primesArray = new boolean[n];
    primesArray[1] = false;

    int m = (int) n/2 + 1;

    for (int i = 2; i < n; i++) {
      primesArray[i] = true;
    }
    for (int i = 2; i < m; i++) {
      if (primesArray[i]) {
        for (int k = 2*i; k < n; k = k + i) {
          primesArray[k] = false;
        }
      }
    }
    // for (int i = 0; i<N; i++ ) {
    //   if (primesArray[i]) System.out.println(i);
    // }
  }
}
