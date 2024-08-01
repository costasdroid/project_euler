package problem146;

import java.util.ArrayList;

public class Sieve {

    public ArrayList<Long> primes = new ArrayList<Long>();

    static int backetSize = 150_000_000;

    static boolean[] backet = new boolean[backetSize];

    public Sieve(long n) {

        int backets = (int) n / backetSize;

        for (int i = 0; i <= backets; i++) {
            initArray();
            firstBacket();
        }
    }

    private void initArray() {
        for (int i = 0; i < backetSize; i++) {
            backet[i] = true;
        }
    }

    private void firstBacket() {
        backet[0] = false;
        backet[1] = false;
        for (int i = 2; i < backetSize; i++) {
            if (!backet[i])
                continue;
            for (int j = i + i; j < backetSize; j += i) {
                backet[j] = false;
            }
        }
        for (int i = 2; i < backetSize; i++) {
            if (backet[i]) {
                primes.add((long) i);
            }
        }
    }

    private void restBackets(int backetIndex) {
        for (long prime : primes) {
            long first = ((long) backetIndex * backetSize / prime) * prime;
            for (int i = (int) (first + prime) % backetSize; i < backetSize;) {
                backet[i] = false;
            }
        }
    }
}
