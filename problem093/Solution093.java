package problem093;

import java.util.ArrayList;

public class Solution093 {

	// there are 9!/5!/4! = 126 different numbers
	// with 4*4*4 operations
	static final int TOTAL = 126 * 64;
	static int[] results;

	// create fours from 1..9
	static ArrayList<Integer> fours = new ArrayList<Integer>();

	// create all permutations from each number of fours
	static ArrayList<Integer> number;

	public static void main(String[] args) {
		long t = System.currentTimeMillis();

		int max = 0;
		int sol = 0;

		// create all combinations from 1..9
		selectFrom("", "123456789");
		// System.out.println(fours);

		// for every number in previous combination
		for (int i = 0; i < fours.size(); i++) {

			// create the different results array
			results = new int[TOTAL];

			// create the collection holding all permutations
			number = new ArrayList<Integer>();

			// create every permutation from the fours
			permute("", fours.get(i) + "");
			// System.out.println(number);

			// get all different results
			for (int num : number)
				operationsOn(num);

			// count ones from the result array
			for (int n = 1; n < results.length; n++) {
				if (results[n] == 0) {
					if (n - 1 > max) {
						max = n - 1;
						sol = fours.get(i);
					}
					// System.out.println(fours.get(i) + ", " + (n - 1));
					break;
				}
			}
		}

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);

	}

	static void selectFrom(String created, String remain) {
		if (created.length() == 4) {
			fours.add(Integer.valueOf(created));
			return;
		}
		for (int i = 0; i < remain.length(); i++) {
			String stringToProceed = created + remain.charAt(i);
			// create only ascending numbers
			String stringRemained = remain.substring(i + 1, remain.length());
			selectFrom(stringToProceed, stringRemained);
		}
	}

	static void permute(String created, String remain) {
		if (created.length() == 4) {
			number.add(Integer.valueOf(created));
			return;
		}
		for (int i = 0; i < remain.length(); i++) {
			String stringToProceed = created + remain.charAt(i);
			String stringRemained = remain.substring(0, i)
					+ remain.substring(i + 1, remain.length());
			permute(stringToProceed, stringRemained);
		}
	}

	static void operationsOn(int n) {
		//there are only two possibilities
		// 1. ((a#b)#c)#d
		// 2. (a#b)#(c#d) 
		ArrayList<Character> c = new ArrayList<Character>();
		c.add('+');
		c.add('-');
		c.add('*');
		c.add('/');
		int u1 = n % 10;
		n /= 10;
		int u2 = n % 10;
		n /= 10;
		int u3 = n % 10;
		int u4 = n / 10;
		for (char o1 : c) {
			for (char o2 : c) {
				for (char o3 : c) {
					Double res = op(op(op(u1, u2, o1), u3, o2), u4, o3);
					if (res > 0 && res.intValue() == res)
						results[res.intValue()] = 1;
					res = op(op(u1, u2, o1), op(u3, u4, o2), o3);
					if (res > 0 && res.intValue() == res)
						results[res.intValue()] = 1;
				}
			}
		}
	}

	static double op(double x, double y, char c) {
		switch (c) {
		case '+':
			return x + y;
		case '-':
			return x - y;
		case '*':
			return x * y;
		case '/':
			return x / y;
		}
		return 0;
	}
}
