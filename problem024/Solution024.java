package problem024;

/*
 *  This algorithm runs through all permutations of a given set with a lexicographic order
 *  1. From right to left find the first number not in ascending order
 *  2. Swap this number with the max of the right's ones
 *  3. Reverses this last part of the number :)
 */

public class Solution024 {

	public static void main(String[] args) {
		final int PERMUTATIONS = 1000000;
		final int NUMBERS = 10;

		int[] table = new int[NUMBERS];
		
		for (int i = 0; i < NUMBERS; i++) {
			table[i]=i;
		}

		// number of permutation completed
		int completed = 0;

		// temporary for swap
		int tmp;

		while (completed < PERMUTATIONS - 1) {
			
			//find the wrong one
			int posToChange = NUMBERS - 1;
			while (table[posToChange] < table[posToChange - 1]) {
				posToChange--;
			}
			tmp = table[posToChange - 1];

			//find the min of the right ones which are greater than the previous
			int min = NUMBERS - 1;
			int foundInPosition = posToChange;
			for (int pos = posToChange; pos <= NUMBERS - 1; pos++) {
				if (table[pos] > tmp && table[pos] < min) foundInPosition = pos;
			}
			
			//and swap it
			table[posToChange - 1] = table[foundInPosition];
			table[foundInPosition] = tmp;
			
			
			// reversing positions
			int revPos = 0;

			while (revPos < (NUMBERS - posToChange) / 2) {
				tmp = table[posToChange + revPos];
				table[posToChange + revPos] = table[NUMBERS - revPos - 1];
				table[NUMBERS - revPos - 1] = tmp;
				revPos++;
			}
			completed++;
		
		}
		for (int i = 0; i < NUMBERS; i++) {
			System.out.print(table[i]);
		}
	}

}
