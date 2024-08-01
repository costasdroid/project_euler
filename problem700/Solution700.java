package problem700;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution700 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ArrayList<Pair> candidates = new ArrayList<Pair>();

        long start = 1504170715041707l;

        long mod = 4503599627370517l;

        long inv = 3451657199285664l;

        long sum = start;

        long min = start + 1;

        long last = start;

        while (min > 10_000_000) {
            last = (last + start) % mod;
            if (min > last) {
                min = last;
                sum += last;
            }
        }

        for (int i = (int) min - 1; i >= 1; i--) {
            long temp = safeMultiplyAndModulo(i, inv, mod);
            candidates.add(new Pair(i, temp));
        }

        candidates.sort((p1, p2) -> Long.compare(p1.y, p2.y));

        for (Pair candidate : candidates) {
            if (candidate.x < min) {
                min = candidate.x;
                sum += candidate.x;
            }
        }
        System.out.println("sum: " + sum);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Benchmark run time: " + elapsedTime + " milliseconds");
    }

    public static class Pair {
        long x;
        long y;

        public Pair(int x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static long safeMultiplyAndModulo(long a, long b, long modulo) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        BigInteger bigModulo = BigInteger.valueOf(modulo);

        // Perform the multiplication and modulo operation
        BigInteger result = bigA.multiply(bigB).mod(bigModulo);

        // Convert the result back to long
        if (result.longValue() == 111054189) {
            return result.longValue();
        }
        return result.longValue();
    }

}
