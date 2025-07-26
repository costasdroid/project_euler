package problem932;

import helperPackage.Timer;

public class Solution932 {
  public static void main(String[] args) {

    Timer timer = new Timer();
    timer.start();

    int N = 8;
    long sum = 0;

    for (long i = 2; i < Math.pow(10, N); i++) {
      long temp = i * i;
      if (test(temp)) {
        sum += temp;
      }
    }
    System.out.println(sum);

    timer.end();
  }

  public static boolean test(long n) {
    String str = String.valueOf(n);
    int len = str.length();
    for (int i = len / 2; i < len / 2 + 1; i++) {
      long part1 = n / (long) Math.pow(10, len - i);
      long part2 = n % (long) Math.pow(10, len - i);
      if (part2 == 0 || String.valueOf(part2).length() < len - i) {
        continue;
      }
      long concatenated = part1 * (long) Math.pow(10, len - i) + part2;
      if ((part1 + part2) * (part1 + part2) == concatenated) {
        System.out.println(n + " = " + part1 + " + " + part2);
        return true;
      }
    }
    return false;
  }
}
