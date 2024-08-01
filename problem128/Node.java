package problem128;

public class Node {

  private long row = 2;
  static long n = 7;
  private int threes = 2;

  public Node(int N) {

    // There are only 2 cells on each row that can have 3 prime differences. The first and the last one.
    do {
      n = n + 1;
      // at position 1 lies +6(row+1) + 1
      // at position 5 lies +6(2row + 3) - 1
      // at position 4 lies +6(row+1) - 1
      if (isPrime(6* row + 1) && isPrime(12*row + 5) && isPrime(6* row - 1)) {
        // System.out.print(n + " has neighbours ");
        // System.out.print((n + 6* row + 1) + "(" + (6* row + 1) + "), ");
        // System.out.print((n + 12*row + 5) + "(" + (12*row + 5) + "), ");
        // System.out.print((n + 6* row - 1) + "(" + (6* row - 1) + ")\n");
        threes++;
      }
      if (threes >= N) return;
      n = n + 6 * row - 1;
      // at position 1 lies +1 - 6* row
      // at position 2 lies +1 - 6*(2*row -1)
      // at position 5 lies 6*(row+1) - 1
      if (isPrime(12*(row - 1) +5) && isPrime(6 * row - 1) && isPrime( 6*(row+1) - 1)) {
        // System.out.print(n + " has neighbours ");
        // System.out.print((n - 12*(row - 1) -5) + "(" + (12*(row - 1) +5) + "), ");
        // System.out.print((n - 6 * row + 1) + "(" + (6 * row - 1) + "), ");
        // System.out.print((n + 6*(row+1) - 1) + "(" + (6*(row+1) - 1) + ")\n");
        threes++;
      }
      if (threes >= N) return;
      row++;

    } while (true);
  }

  static boolean isPrime(long n) {
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
