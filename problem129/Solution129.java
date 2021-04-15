public class Solution129 {

  public static void main(String[] args) {
    // For timing
    long t1 = System.currentTimeMillis();

    final long N = 1000000l;

    Numbers n = new Numbers();

    long curN = N + 1;
    do {
      curN = curN + 2;
      if (curN % 5 == 0) curN = curN + 2;
      long sol = curN * 9;
      long totient = n.totient(sol);
      if (totient < N) continue;
      long tot = totient;
      // System.out.println("totient of " + sol + " is " + tot);
      long mod = 1l;
      do {
        mod = (10 * mod) % sol;
        // System.out.println("tot is " + (totient - tot + 1) + " New mod = " + mod);
        tot--;
      } while (tot > 0 && mod != 1);
      // System.out.println(totient - tot);
      if (totient - tot > N) {
        break;
      }
    } while (true);

    System.out.println("The solution is: " + curN);
    System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
  }

}
