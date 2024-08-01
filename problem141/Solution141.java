package problem141;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {
    static long MAX = 1_000_000_000_000l;
    private static long sum = 0;

    private static Set<Long> progresiveSquare = new HashSet<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int MAXZ = (int) Math.pow(MAX, 1 / 3.0) + 1;

        for (int a = 1; a <= MAXZ; a++) {
            for (int y = 1; y < a; y++) {
                int MAXX = (int) Math.sqrt(MAX / (a * a * a - y)) + 1;
                for (int x = 1; x <= MAXX; x++) {
                    double m = (double) x * x * y * a * a * a + x * y * y;
                    if (m > MAX)
                        break;
                    if (Math.sqrt(m) % 1 == 0) {
                        // System.out
                        // .println("r: " + (long) x * y * y + ", q:" + x * z * z + ", p:" + x * y * z +
                        // ", m: " +
                        // (long) Math.sqrt(m));
                        progresiveSquare.add((long) m);
                    }
                }
            }
        }
        // System.out.println("Size: " + progresiveSquare.size());
        for (long number : progresiveSquare) {
            // System.out.println("Number: " + number);
            sum += number;
        }
        System.out.println("Sum: " + sum);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        double executionTimeInSeconds = executionTime / 1_000_000_000.0;
        System.out.println("Execution time: " + executionTimeInSeconds + " seconds");
    }
}
