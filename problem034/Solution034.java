package problem034;

import java.util.ArrayList;
import java.util.List;

public class Solution034 {

	static List<Integer> factorials = new ArrayList<Integer>();

	public static void main(String[] args) {

		int digits = 6;

		int sum = 0;

		factorials.add(1);
		for (int i = 1; i <= 9; i++) {
			factorials.add(factorials.get(factorials.size() - 1) * i);
		}

		for (int i = 3; i <= Math.pow(10, digits); i++) {
			if (sumFactors(i) == i)
				sum += i;
		}

		System.out.println(sum);
	}

	static int sumFactors(int n) {

		int sum = 0;

		while (n > 0) {
			sum += factorials.get(n % 10);
			n /= 10;
		}
		return sum;
	}

}
