//there cannot be 2,4,5,6,8,0 because when ending on one of them it will be composite
//make all combination with digits 1,3,7,9 of up to 6 numbers
//and test each rotation for primality

public class Solution035 {
	static String digits = "1379";
	static int n = 0;

	public static void main(String[] args) {
		for (int i = 2; i <= 6; i++) {
			combi(digits, i);
		}

		System.out.println(n + 4);
	}

	static void combi(String s, int digits) {
		combi("", s, digits);
	}

	static void combi(String prefix, String s, int digits) {
		int N = prefix.length();
		if (N == digits) {
			if (testAllPerm(prefix)) {
				n++;
			}
		} else {
			for (int i = 0; i < s.length(); i++)
				combi(prefix + s.charAt(i), s, digits);
		}

	}

	static boolean testAllPerm(String s) {
		for (int i = 1; i <= s.length(); i++) {
			s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
			if (!isPrime(s))
				return false;
		}
		return true;
	}

	static boolean isPrime(String n) {

		int i = 2;
		do {
			if (Integer.valueOf(n) % i == 0)
				return false;
			i++;
		} while (i * i <= Integer.valueOf(n));

		return true;
	}
}
