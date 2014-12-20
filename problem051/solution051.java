/*
 * Had to manually solve it test some "types" like how many digits
 * 	or how large the number is. Then the solution was not the correct one!
 * 	My solution was ***109 but it didn't work with the site. Changing to 
 *  the first prime with no leading zeros was this particular one!
 *  
 *  So... I run from 100 to 999 with 3 digits
 *  and create all the combinations with the previous number and 3 x's
 *  I replace the x's with numbers and count. A very fast solution!!!
*/
import java.util.ArrayList;

public class Solution051 {

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int prime = 0;

		for (int i = 100; i < 999; i++) {
			String s = i + "";
			String temp;

			for (int pos1 = 0; pos1 < s.length(); pos1++)
				for (int pos2 = pos1; pos2 < s.length(); pos2++) {
					for (int pos3 = pos2; pos3 < s.length(); pos3++) {
						temp = s.substring(0, pos1) + "x"
								+ s.substring(pos1, pos2) + "x"
								+ s.substring(pos2, pos3) + "x"
								+ s.substring(pos3, s.length());
						int count = 0;
						boolean found = false;
						for (int k = 0; k <= 9; k++) {
							if (isPrime(Integer.valueOf(temp.replaceAll("x", k
									+ "")))) {
								if (!found)
									prime = Integer.valueOf(temp.replaceAll(
											"x", k + ""));
								found = true;
								count++;
							}
						}
						if (count > 6)
							primes.add(prime);
					}
				}
		}
		int min = 999999;
		for (int p : primes) {
			if (p < min && p > 99999)
				min = p;
		}
		System.out.println(min);
	}

	static boolean isPrime(int n) {
		if (n <= 3)
			return n > 1;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}
}
