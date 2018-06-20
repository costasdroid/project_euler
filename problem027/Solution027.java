import java.util.ArrayList;
import java.util.List;

public class Solution027 {

	static List<Integer> primes;

	public static void main(String[] args) {

		createPrimeNumbersTo(1000);

		int maxFound = 0;
		int pro = 0;

		for (int b : primes) {
			for (int a = -999; a < 1000; a++) {
				int n = 0;
				while (primes.contains((int) n * n + a * n + b)) {
					n++;
				}
				if (n > maxFound) {
					maxFound=n;
					pro = a*b;
				}
			}
		}
		
		System.out.println(pro);

	}

	static void createPrimeNumbersTo(int n) {

		primes = new ArrayList<Integer>();

		for (int i = 2; i <= n; i++) {
			primes.add(i);
		}

		int index = 0;
		int num = primes.get(0);

		while (num * num < n || index < primes.size() - 1) {
			int j = 2;
			while (j < n) {
				primes.remove(Integer.valueOf(j * num));
				j++;
			}
			num = primes.get(index++);
		}

	}
}
