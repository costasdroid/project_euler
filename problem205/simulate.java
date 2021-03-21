import java.util.Random;


public class simulate {

	static Random rand = new Random();

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		final int N = 1000000;
		int wins = 0;
		for (int i = 0; i < N; i++) {
			if (roll(4, 9) > roll(6, 6)) wins++;
		}
		System.out.println("The solution is: " + wins + " over " + N);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	static int roll(int dice, int rolls) {
		int sum = 0;
		for (int i = 0; i < rolls; i++) {
			sum += rand.nextInt(dice) + 1;
		}
		return sum;
	}
}
