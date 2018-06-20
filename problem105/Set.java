package problem105;

public class Set {

	// The data set
	int[] numbers;

	// How many numbers inside set
	int cardinal;

	// The sums for each subset
	int[][] sums;

	// The total sum
	public int sum;

	// the aborting var of recursion
	boolean ok = true;

	// the min and max of each subset
	int[] min;
	int[] max;

	public Set(String s) {

		// Remove spaces
		String[] sNums = s.replace(" ", "").split(",");

		// Count numbers
		cardinal = sNums.length;

		// populate the set
		numbers = new int[cardinal];

		for (int n = 0; n < cardinal; n++) {
			numbers[n] = Integer.valueOf(sNums[n]);
			// keep track of sum
			sum += numbers[n];
		}

		// for each 0 to n-1 numbers in set keep track of each sum
		sums = new int[cardinal + 1][sum + 1];

		// track min and max of each set
		min = new int[cardinal + 1];
		max = new int[cardinal + 1];

	}

	public boolean isOk() {

		perm(0, numbers, 0, 0, "");
		return ok;

	}

	private void perm(int howMany, int[] number, int index, int sum,
			String created) {

		// System.out.println(created);

		// test if sum found again
		if (sums[howMany][sum] == 1) {
			ok = false;
			return;
		}

		// test if sum is less than the greatest of the smaller set.
		if (howMany > 1 && sum <= max[howMany - 1] && max[howMany - 1] != 0) {
			ok = false;
			return;
		}

		// test if sum is greater than the smallest of the bigger set.
		if (howMany < cardinal && sum >= min[howMany + 1]
				&& max[howMany + 1] != 0) {
			ok = false;
			return;
		}

		// mark the sum as found
		sums[howMany][sum] = 1;

		// in case, change accordingly the min or max
		if (sum > max[howMany])
			max[howMany] = sum;
		if (min[howMany] == 0 || sum < min[howMany])
			min[howMany] = sum;

		for (int n = index; n < cardinal; n++) {
			perm(howMany + 1, number, n + 1, sum + number[n], created
					+ number[n] + ",");
			if (!ok)
				return;
		}
	}
}
