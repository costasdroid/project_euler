package problem028;

public class Solution028 {

	public static void main(String[] args) {

		final int GRID = 1001;

		int sum = 1;
		int i = 1;
		int j = 1;

		// while you are in the grid
		while (i <= (GRID - 1) * (GRID - 1)) {
			// sum the four corners
			sum = sum + (i + (j + 1)) + (i + 2 * (j + 1)) + (i + 3 * (j + 1))
					+ (i + 4 * (j + 1));
			// which they increase the distance by two each outer perimeter
			j = j + 2;
			// with every grid increasing to n*n each time
			i = j * j;
		}

		System.out.println(sum);
	}

}
