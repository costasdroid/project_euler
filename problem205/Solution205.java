import java.util.Arrays;

public class Solution205 {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		int dice1 = 4;
		int rolls1 = 9;
		int dice2 = 6;
		int rolls2 = 6;
		int[][] peter = new int[dice1 * rolls1 + 1][rolls1];
		int[][] colin = new int[dice2 * rolls2 + 1][rolls2];
		roll(dice1, rolls1, 0, peter);
		roll(dice2, rolls2, 0, colin);
		solve(peter, colin);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	static void solve(int[][] p, int[][] c) {
		int[] temp = new int[p.length];
		long cSum = 0;
		long pSum = 0;
		long total = 0;
		temp[0] = 0;
		for (int i = 1; i < c.length; i++) {
			temp[i] = c[i][c[i].length - 1] + temp[i - 1];
			pSum += p[i][p[i].length - 1];
			cSum += c[i][c[i].length - 1];
			total += p[i][p[i].length - 1] * temp[i - 1];
		}
		System.out.println("The solution is: " + Math.round(total / (double) (cSum * pSum) * 10000000) / 10000000.);
		return;
	}

	static void roll(int dice, int times, int time, int[][] array) {
		if (time >= times) return;
		for (int i = 1; i <= dice * times; i++) {
			if (time == 0) {
				array[i][0] = i > dice ? 0 : 1;
			} else {
				int sum = 0;
				for (int j = i - 1; j >= 1 && i - j <= dice; j--) {
					sum += array[j][time - 1];
				}
				array[i][time] += sum;
			}
		}
		roll(dice, times, time + 1, array);
		return;
	}
}
