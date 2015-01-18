import java.util.ArrayList;

public class Solution046 {

	public static void main(String[] args) {
		final int MAX = 10000;

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 9; i <= MAX; i += 2) {
			if (!isPrime(i))
				numbers.add(i);
		}

		for (int i = 1; i <= MAX; i++) {
			if (isPrime(i)) {
				for (int j = 1; j * j <= (MAX - i) / 2; j++) {
					if (numbers.contains(i + 2 * j * j)) {
						numbers.remove(new Integer(i + 2 * j * j));
					}
				}
			}
		}
		System.out.println(numbers.get(0));

	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
