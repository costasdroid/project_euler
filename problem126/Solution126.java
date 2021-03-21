import java.util.Arrays;
public class Solution126 {

	public static void main(String[] args) {
		// For timing
		long t1 = System.currentTimeMillis();
		// Upper bound constrain
		final int LIMIT = 100000;
		// number to find
		final int N = 1000;
		// The C(n)
		int[] cuboids = new int[LIMIT + 1];
		// the usual solution variable
		long sol = 0;

		for (int x = 1; x <= LIMIT; x++) {
			for (int y = 1; y <= x; y++) {
				for (int z = 1; z <= y; z++) {
					int cubes = initialC(x, y, z);
					for (int n = 1; n <= LIMIT; n++) {
						cubes += 4 * (-4 + 2 * n + x + y + z);
						if (cubes > LIMIT) {
							break;
						} else {
							cuboids[cubes]++;
							// if (cubes == 154) System.out.println(x + ", " + y + ", " + z + ", " + n);
						}
					}
					if (initialC(x, y, z) > LIMIT) break;
				}
				if (initialC(x, y, 1) > LIMIT) break;
			}
			if (initialC(x, 1, 1) > LIMIT) break;
		}

		for (int i = 1; i <= LIMIT; i++) {
			if (cuboids[i] == N) {sol = i; break;}
		}

		// System.out.println(Arrays.toString(cuboids));

		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	static int initialC(int x, int y, int z) {
		return 8 - 4 * x - 4 * y + 2 * x * y - 4 * z + 2 * x * z + 2 * y * z;
	}

	static int calc(int x, int y, int z, int n) {
		return 2 * (4 - 6 * n + 2 * n * n - 2 * x + 2 * n * x - 2 * y + 2 * n * y + x * y - 2 * z + 2 * n * z + x * z + y * z);
	}
}

/*
   The formula for Mathematica:

   2*(x*y + Sum[2 (x + y) + 4 (i - 1), {i, 1, n - 1}]) + (2 (x + y) +
     4 n - 4) z // Factor

   This derives as:
   1. The cuboid has upper surface of x * y
   2. The first layer around has 2(x+y) cubes
   3. Every other has 4 more

   so

   4. Every time you have to double the layer up to the middle
   5. and add the z middle layers which have the next number of cubes as of 2.-3.

   The total formula is 8 - 12 n + 4 n^2 - 4 x + 4 n x - 4 y + 4 n y + 2 x y - 4 z + 4 n z + 2 x z + 2 y z

   Conclusions:

   Only even number

 */
