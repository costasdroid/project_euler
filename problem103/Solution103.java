package problem103;

//The first time I simply guessed the number using the algorithm!!!!!!!!!!!
//When I solved the 105 I returned to brute force it

public class Solution103 {

	// Testing for some numbers I found the max = 45!
	static int N = 25;
	static int[] numbers = new int[N + 1];

	static boolean stop = false;

	static String sol;

	public static void main(String[] args) {

		long t = System.currentTimeMillis();

		for (int n = 0; n <= N; n++)
			numbers[n] = 20 + n;

		// generate sets
		generate(0, numbers, 0, "");

		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);

	}

	static void generate(int howMany, int[] numbers, int index, String created) {
		if (howMany == 7) {
			Set temp = new Set(created.substring(0, created.length() - 1));
			if (temp.isOk()) {
				sol = created.replace(",", "");
				stop = true;
			}
			return;
		}
		for (int n = index; n < numbers.length; n++) {
			generate(howMany + 1, numbers, n + 1, created + numbers[n] + ",");
			if (stop)
				return;
		}
	}
}
