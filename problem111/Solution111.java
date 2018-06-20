package problem111;

public class Solution111 {

	// The sum
	static long s = 0;

	// The length
	static int length = 10;

	// the array for each digit determining if max digits found
	static boolean[] ms = new boolean[10];

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		// The digits
		String digits = "0123456789";

		// The a's to be replaced by 1s, 2s, 3s...
		String num = "aaaaaaaaaa";

		// for every m (m = how many digits to be replaced)
		for (int m = 1; m <= length; m++) {

			// for every digit
			for (char d : digits.toCharArray()) {
				// if found for same digit and other m continue
				if (ms[Integer.valueOf(d + "")]) {
					continue;
				}
				// find positions to replace with length of m
				findPos(digits.substring(0, length), "", m, num.substring(0, length).replaceAll("a", d + ""), d);
			}
		}
				
		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + s);
	}

	// primality testing
	static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if (n % 3 == 0 || n % 2 == 0)
			return false;
		long i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
			i += 6;
		}
		return true;
	}

	// find all positions to replace the digits
	// positions = allowed positions
	// pos = current positions
	// length = digits to be replaced
	// num = 111..., 2222..., ...
	// d = digit that num is created of
	static void findPos(String positions, String pos, int length, String num, char d) {
		if (pos.length() == length) {
			testFor(num, pos);
			return;
		}
		for (int n = 0; n < positions.length(); n++) {
			char temp = positions.charAt(n);
			findPos(positions.substring(n + 1), pos + temp, length, num, d);
		}
	}

	// create a number for each position
	// say pos = 156, we must create numbers from 000 to 999 to replace
	// positions 1, 5 and 6
	static void testFor(String num, String pos) {

		for (int i = 0; i < Math.pow(10, pos.length()); i++) {
			String st = i + "";
			// fill 0s (1 = 001, ..., 34 = 034, ...)
			if ((i + "").length() < pos.length()) {
				while (st.length() != pos.length())
					st = '0' + st;
			}

			char[] temp = num.toCharArray();
			for (int j = 0; j < pos.length(); j++) {
				temp[pos.charAt(j) - '0'] = st.charAt(j);
			}
			long n = Long.valueOf(String.valueOf(temp));

			// not to start with 0
			if (isPrime(n) && temp[0] != '0') {
				s += n;
				ms[num.charAt(0) - '0'] = true;
				//System.out.println(n);
			}
		}
	}
}
