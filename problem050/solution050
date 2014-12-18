import java.util.ArrayList;

public class Solution050 {

	public static void main(String[] args) {

		int prime = 0;

		ArrayList<Integer> primes = new ArrayList<Integer>();

		for (int i = 2; i <= 1000000; i++) {
			if (isPrime(i))
				primes.add(i);
		}

		int max = 0;
		while (primes.size() > 1) {
			int sum = 0;
			int ns = 0;
			for (int i : primes) {
				if (sum + i > 1000000)
					break;
				sum = sum + i;
				ns++;
			}
			if (ns > max && isPrime(sum)) {
				max = ns;
				prime = sum;
			}
			primes.remove(0);
		}

		System.out.println(prime);
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
