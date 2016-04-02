package problem118;

import java.util.ArrayList;
import java.util.Collections;

/*My big fat lazy brute force code

* First find all primes up to 9 digits (the problem doesn't mention that a set could not be consist of a single element)
* recursion through all primes from the current to a "proper" one
* test for digits*/

public class Solution118 {

	static int n = 0;
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static int sol = 0;
	static String digits = "123456789";

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();

		// find all primes from those digits
		recurs(digits, "");

		// Sort them to sublist only the largest ones (not to have same sets as
		// of {1,2,3} and {2,3,1}
		Collections.sort(primes);

		// System.out.println(primes);

		// create sets
		findSet(new ArrayList<Integer>(primes), new ArrayList<Integer>(), "");

		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

	public static void recurs(String left, String produced) {
		if (isPrime(Integer.valueOf(0 + produced))) {
			primes.add(Integer.valueOf(0 + produced));
		}
		if (left.length() == 0) {
			return;
		}
		for (int i = 0; i < left.length(); i++) {
			recurs(left.substring(0, i) + left.substring(i + 1), produced + left.charAt(i));
		}
	}

	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0 || n <= 1)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void findSet(ArrayList<Integer> primesLeft, ArrayList<Integer> set, String prod) {
		int wantedLengthOfSet = digits.length();
		int lengthOfSet = prod.length();
		
		// if it is what we want add them up
		if (lengthOfSet == wantedLengthOfSet) {
			// System.out.println("The set is " + set + ", " + lengthOfSet);
			sol++;
			return;
		}

		// if a largest set created return
		if (primesLeft.size() == 0) {
			return;
		}

		// pick the first greater than the last added
		int index = 0;
		while (index < primesLeft.size() && set.size() > 0 && set.get(set.size() - 1) > primesLeft.get(index)) {
			index++;
		}

		// if it found a bigger one
		if (index <= primesLeft.size()) {
			//for the rest primes
			for (int i = index; i < primesLeft.size(); i++) {
				int temp = primesLeft.remove(i);
				
				//test if the new one creates set > digits
				if ((temp + "").length() + lengthOfSet > wantedLengthOfSet) {
					primesLeft.add(i, temp);
					break;
				}
				
				//test for the digits used
				String s1 = set.toString();
				String s2 = temp + "";
				boolean isClear = true;
				for (char s : s2.toCharArray()) {
					if (s1.contains(s + "")) {
						isClear = false;
						break;
					}
				}
				
				//and if it is OK call the rec function again
				if (!isClear) {
					primesLeft.add(i, temp);
					continue;
				}
				set.add(temp);
				findSet(primesLeft, set, prod + temp);
				primesLeft.add(i, temp);
				set.remove(set.size() - 1);
			}
		}
	}

}
