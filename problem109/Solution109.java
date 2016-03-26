package problem109;

import java.util.ArrayList;

public class Solution109 {

	static int max = 99;
	static int target = 0;
	static int counts = 0;

	public static void main(String[] args) {

		long t = System.currentTimeMillis();
		
		ArrayList<Integer> darts = new ArrayList<Integer>();

		for (int i = 0; i <= 20; i++) {
			darts.add(i);
		}
		darts.add(25);

		for (target = 2; target <= max; target++) {
			int temp = counts;
			checkout(darts, 0, 0, "", "S", 0);
			//System.out.println("For " + target + " we need " + (counts - temp));
		}
		int sol = counts;
		
		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

	public static void checkout(ArrayList<Integer> darts, int dart, int total, String s, String type, int hit) {

		if (dart > 2 || total > target) {
			return;
		}
		if (dart == 2 && target != total && (target - total) % 2 == 0 && darts.contains((target - total) / 2)) {
			// System.out.println((s + " D" + (target - total) /
			// 2).replaceAll("S0 ", "").replaceAll("D25 ","Bull"));
			counts++;
		}

		for (int d : darts) {
			if (type == "S") {
				if (d >= hit) {
					checkout(darts, dart + 1, total + d, s + " S" + d, "S", d);
				}
				if (d > 0)
					checkout(darts, dart + 1, total + 2 * d, s + " D" + d, "D", d);
				if (d > 0 && d <= 20)
					checkout(darts, dart + 1, total + 3 * d, s + " T" + d, "T", d);
			}
			if (type == "D") {
				if (d >= hit) {
					checkout(darts, dart + 1, total + 2 * d, s + " D" + d, "D", d);
				}
				if (d > 0 && d <= 20)
					checkout(darts, dart + 1, total + 3 * d, s + " T" + d, "T", d);
			}
			if (type == "T" && d <= 20) {
				if (d >= hit) {
					checkout(darts, dart + 1, total + 3 * d, s + " T" + d, "T", d);
				}
			}
		}
	}

}
