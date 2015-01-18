//from 1 to 9999, make chains of multiples until length of 9 is reached
//test if number is pandigital and find max

public class Solution038 {

	public static void main(String[] args) {

		String s;
		Long max = 0l;

		for (int n = 1; n <= 9999; n++) {
			s = "";
			int i = 1;
			while (s.length() < 9) {
				s = s + (i * n);
				i++;
			}
			if (s.length() == 9)
				if (isPandigital(s)) {
					if (max < Long.valueOf(s))
						max = Long.valueOf(s);
				}
		}
		System.out.println(max);

	}

	static boolean isPandigital(String s) {

		for (int i = 1; i <= 9; i++) {
			if (!s.contains(i + ""))
				return false;
		}

		return true;
	}

}
