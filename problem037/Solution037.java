public class Solution037 {

	static int digs;
	static int sum = 0;
	
	public static void main(String[] args) {
		
		String digits = "123579";
		
		for (digs = 2; digs<=7; digs++) {
			combi(digits);	
		}
		System.out.println(sum);
	}

	static void combi(String s) {
		combi("", s);
	}

	static void combi(String prefix, String s) {
		int length = digs;
		if (prefix.length() == length) {
			if (isPrime(prefix)) {
				boolean b = true;
				for (int i = 1; i < length; i++) {
					if (!isPrime(prefix.subSequence(0, i)+"")) {
						b = false;
					}
				}
				for (int i = 1; i < length; i++) {
					if (!isPrime("" + prefix.subSequence(i, length))) {
						b = false;
					}
				}
				if (b)
					sum = sum + Integer.valueOf(prefix);
			}
		} else {
			for (int i = 1; i <= s.length(); i++) {
				combi(prefix + s.charAt(i - 1), s);
			}
		}
	}

	static boolean isPrime(String s) {
		if (Integer.valueOf(s) == 1)
			return false;
		for (int n = 2; n * n <= Integer.valueOf(s); n++) {
			if (Integer.valueOf(s) % n == 0)
				return false;
		}
		return true;
	}
}
