//there are only 2 combinations with 1+4+4 digits and 2+3+4 digits
//we need the array in order to stick to unique values

import java.util.ArrayList;

public class Solution032_2 {
	static String digits = "123456789";

	static ArrayList<Integer> sums = new ArrayList<Integer>();

	static int sum = 0;

	public static void main(String[] args) {
		perm(digits);

		System.out.println(sum);
	}

	static void perm(String s) {
		perm("", s);
	}

	static void perm(String prefix, String s) {
		int N = s.length();
		if (N == 0) {
			if (Integer.valueOf(prefix.substring(0, 1))
					* Integer.valueOf(prefix.substring(1, 5)) == Integer
						.valueOf(prefix.substring(5, 9))) {
				if (!sums
						.contains((int) Integer.valueOf(prefix.substring(5, 9)))) {
					sums.add((int) Integer.valueOf(prefix.substring(5, 9)));
					sum = sum + Integer.valueOf(prefix.substring(5, 9));
					// System.out.println(prefix.substring(0, 1) + " "
					// + prefix.substring(1, 5) + " "
					// + prefix.substring(5, 9));
				}
			}
			if (Integer.valueOf(prefix.substring(0, 2))
					* Integer.valueOf(prefix.substring(2, 5)) == Integer
						.valueOf(prefix.substring(5, 9))) {
				if (!sums
						.contains((int) Integer.valueOf(prefix.substring(5, 9)))) {
					sums.add((int) Integer.valueOf(prefix.substring(5, 9)));
					sum = sum + Integer.valueOf(prefix.substring(5, 9));
					// System.out.println(prefix.substring(0, 2) + " "
					// + prefix.substring(2, 5) + " "
					// + prefix.substring(5, 9));
				}
			}
		} else {
			for (int i = 0; i < N; i++)
				perm(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, N));
		}

	}
}
