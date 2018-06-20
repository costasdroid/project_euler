public class Solution052 {

	public static void main(String[] args) {
		long number = 10l;

		while (!test(number)) {
			if (String.valueOf(number).length() > String.valueOf(6 * number)
					.length())
				number = (long) Math.pow(10, String.valueOf(6 * number)
						.length());
			else
				number++;
		}
		System.out.println(number);
	}

	static boolean test(long n) {
		long[] nums = { n, 2 * n, 3 * n, 4 * n, 5 * n, 6 * n };
		for (int i = 0; i < 5; i++) {
			if (!hasSame(nums[i % 5], nums[(i + 1) % 5]))
				return false;
		}
		return true;
	}

	static boolean hasSame(long n1, long n2) {
		String s1 = n1 + "";
		String s2 = n2 + "";
		for (int i = 0; i < s1.length(); i++) {
			if (!s2.contains(s1.charAt(i) + ""))
				return false;
		}
		return true;
	}

}
