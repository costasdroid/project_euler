package problem090;

public class Solution090 {

	static String digits = "012345678";
	static String[] dice = new String[84];
	static int index = 0;

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		comb("", digits);
		int sol = solveIt();

//		for (String s : dice)
//				System.out.println(s);

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	static void comb(String created, String remains) {
		if (created.length() == 6) {
			if (created.contains("6"))
				created += "9";
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
				Boolean itIsOk = true;
				int[] ints = new int[100];

				for (int i = 0; i < dice[i1].length(); i++) {
					for (int j = 0; j < dice[i2].length(); j++) {
						ints[Integer.valueOf(dice[i1].charAt(i) + ""
								+ dice[i2].charAt(j) + "")] = 1;
						ints[Integer.valueOf(dice[i2].charAt(j) + ""
								+ dice[i1].charAt(i) + "")] = 1;
					}
				}

				for (int i = 1; i <= 9; i++) {
					if (ints[i * i] != 1) {
						itIsOk = false;
						break;
					}
				}
				if (itIsOk) {
					System.out.println(dice[i1] + ", " + dice[i2]);
					howMany++;
				}
			}
		}

		return howMany;
	}

}
