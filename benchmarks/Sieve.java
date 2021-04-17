public class Sieve {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    int N = 100000000;

    for (int i = 1; i <= N; i *= 10) {
      sieve(i);
      System.out.println("For " + i + " numbers it took: " + (System.currentTimeMillis() - t1) + "ms");
      t1 = System.currentTimeMillis();
    }

  }

  static void sieve(int n) {
    boolean[] comp = new boolean[n];
    int last = (int) n / 2;
    for (int i = 2; i < last + 1; i++) {
      if (comp[i]) continue;
      for (int j = 2 * i; j < n; j += i) {
        comp[j] = true;
      }
    }


    if (n== 100) {
      for (int i = 0; i <n; i++)
      if (!comp[i]) System.out.println(i);
    }

    return;
  }

}
