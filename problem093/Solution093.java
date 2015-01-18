//the answer is not 1256 so some modifications needed maybe in parenthesis

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
		//System.out.println(fours);

		// for every number in previous combination
		for (int i = 0; i < fours.size(); i++) {

			// create the different results array
			results = new int[TOTAL];

			// create the collection holding all permutations
			number = new ArrayList<Integer>();

			// create every permutation from the fours
			permute("", fours.get(i) + "");
			//System.out.println(number);

			// get all different results
			for (int num : number)
				operationsOn(num / 10 + "", num % 10);

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

	static void operationsOn(String s, double res) {
		// if no string remains and the result is proper fill the array
		if (s.length() == 0) {
			if (res >= 0 && res == (int) res) {
				results[(int) res] = 1;;
			}
			return;
		}

		//testing merge
		// continue with the respective operation
		operationsOn(s.substring(0, s.length() - 1),
				res + Integer.valueOf(s.charAt(s.length() - 1) + ""));
		operationsOn(s.substring(0, s.length() - 1),
				res - Integer.valueOf(s.charAt(s.length() - 1) + ""));
		operationsOn(s.substring(0, s.length() - 1),
				res * Integer.valueOf(s.charAt(s.length() - 1) + ""));
		operationsOn(s.substring(0, s.length() - 1),
				res / Integer.valueOf(s.charAt(s.length() - 1) + ""));
	}

}
