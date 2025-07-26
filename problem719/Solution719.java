package problem719;

import helperPackage.Timer;
import java.util.ArrayList;
import java.util.List;

public class Solution719 {
  public static void main(String[] args) {

    Timer timer = new Timer();
    timer.start();

    int N = 6;
    long sum = 0;

    for (long i = 2; i <= Math.pow(10, N) && i <= 1000000; i++) {
      long temp = i * i;
      List<List<Long>> cuts = getCuts(temp);
      for (List<Long> cut : cuts) {
        if (test(cut, temp)) {
          System.out.print(temp + ": ");
          sum += temp;
          System.out.println(cut);
          break;
        }
      }
    }

    System.out.println(sum);

    timer.end();
  }

  public static boolean test(List<Long> cut, long n) {
    long sum = 0;
    for (long num : cut) {
      sum += num;
    }
    return sum * sum == n;
  }

  public static List<List<Long>> getCuts(long number) {
    String str = String.valueOf(number);
    List<List<Long>> result = new ArrayList<>();
    generateCuts(str, new ArrayList<>(), result);
    return result;
  }

  private static void generateCuts(String str, List<Long> current, List<List<Long>> result) {
    if (str.isEmpty()) {
      result.add(new ArrayList<>(current));
      return;
    }
    for (int i = 1; i <= str.length(); i++) {
      String part = str.substring(0, i);
      String remaining = str.substring(i);
      current.add(Long.parseLong(part));
      generateCuts(remaining, current, result);
      current.remove(current.size() - 1);
    }
  }
}
