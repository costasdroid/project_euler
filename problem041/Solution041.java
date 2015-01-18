public class Solution041 {

	static String digits = "7654321";

	public static void main(String[] args) {
		perm(digits);
	}

	static void perm(String s) {
		perm("", s);
	}

	static void perm(String prefix, String s) {
		int N = s.length();
		if (N == 0) {
			if (isPrime(prefix)) {
				System.out.println(prefix);
				System.exit(0);
			}
		} else {
			for (int i = 0; i < N; i++)
				perm(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, N));
		}

	}

	static boolean isPrime(String s) {

		int number = Integer.valueOf(s);

		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}
}
