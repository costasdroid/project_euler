package problem146;

public class Solution146 {

    private static boolean isPrime(long n) {
        for (int i = 0; i < sieve.primes.size(); i++) {
            if (sieve.primes.get(i) == n)
                return true;
            if (n % sieve.primes.get(i) == 0)
                return false;
        }
        return true;
    }

    private static Sieve sieve;

    public static void main(String[] args) {
        int MAX = 150_000_000;
        int count = 0;

        sieve = new Sieve(MAX);

        for (long n = 2; n <= MAX; n += 2) {
            long n2 = n * n;

            if (isPrime(n2 + 1) && isPrime(n2 + 3) && !isPrime(n2 + 5) && isPrime(n2 + 7) && isPrime(n2 + 9)
                    && !isPrime(n2 + 11) && isPrime(n2 + 13) && !isPrime(n2 + 15) && !isPrime(n2 + 17)
                    && !isPrime(n2 + 19) && !isPrime(n2 + 21) && !isPrime(n2 + 23) && !isPrime(n2 + 25)
                    && isPrime(n2 + 27)) {
                System.out.println(n);
            }

        }

        System.out.println(count);
    }

}
