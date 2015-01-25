package problem090;

public class Solution090 {

	static String digits = "0123456789";
	static String[] dice = new String[210];
	static int index = 0;

	public static void main(String[] args) {
		long t = System.currentTimeMillis();

		comb("", digits);
		int sol = solveIt();

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static void comb(String created, String remains) {
		if (created.length() == 6) {
			dice[index] = created;
			index++;
			return;
		}
		for (int i = 0; i < remains.length(); i++) {
			comb(created + remains.charAt(i),
					remains.substring(i + 1, remains.length()));
		}
	}

	static int solveIt() {
		int howMany = 0;
		for (int i1 = 0; i1 < index; i1++) {
			for (int i2 = i1; i2 < index; i2++) {
				if (existsAll(dice[i1], dice[i2]))
					howMany++;
			}
		}
		return howMany;
	}

	static boolean existsAll(String d1, String d2) {
		int[] ints = new int[100];

		if (d1.contains("6") && !d1.contains("9"))
			d1 += "9";
		if (!d1.contains("6") && d1.contains("9"))
			d1 += "6";
		if (d2.contains("6") && !d2.contains("9"))
			d2 += "9";
		if (!d2.contains("6") && d2.contains("9"))
			d2 += "6";

		for (int i = 0; i < d1.length(); i++) {
			for (int j = 0; j < d2.length(); j++) {
				ints[Integer.valueOf(d1.charAt(i) + "" + d2.charAt(j) + "")] = 1;
				ints[Integer.valueOf(d2.charAt(j) + "" + d1.charAt(i) + "")] = 1;
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (ints[i * i] != 1) {
				return false;
			}
		}

		// System.out.println("The two dices " + d1.substring(0, 6) + " and " +
		// d2.substring(0, 6) + " are valid");
		return true;
	}

}
