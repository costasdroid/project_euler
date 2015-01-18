public class Solution036 {

	public static void main(String[] args) {

		long sum = 0;

		for (int i = 0; i < 999; i++) {
			int number;
			if (i < 100) {
				for (int j = 0; j < 10; j++) {
					number = mirror(i * 10 + j, 2);
					if (isPalindromic(number)) {
						sum = sum + number;
					}
				}
			}
			number = mirror(i, 1);
			if (isPalindromic(number)) {
				sum = sum + number;
			}

		}
		System.out.println(sum);
	}

	static int mirror(int i, int b) {
		String s = i + "";

		int length = s.length();

		for (int k = length - b; k >= 0; k--) {
			s = s + s.charAt(k);
		}
		return Integer.valueOf(s);
	}

	static boolean isPalindromic(int n) {

		String s = toBinary(n);

		for (int i = 0; i <= (s.length() - 1) / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

	static String toBinary(int n) {
		String s = "";
		do {
			s = (n % 2) + s;
			n = n / 2;
		} while (n > 0);
		return s;
	}
}
