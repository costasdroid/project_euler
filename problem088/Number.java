package problem088;

import java.util.ArrayList;

public class Number {

	int number;

	public int distinctFactors;

	public int[][] factorsArray;

	public int[] divisors;

	public ArrayList<String> product = new ArrayList<String>();

	public Number(Number[] previous, int number) {

		this.number = number;
		factorsArray = fillFactorArray();

		distinctFactors = factorsArray.length;

		divisors = new int[numberOfDivisors()];

		getAllFactors(0, 1);

		productWays(previous);

	}

	private int[][] fillFactorArray() {
		ArrayList<Integer> factor = new ArrayList<Integer>();
		ArrayList<Integer> freq = new ArrayList<Integer>();
		int temp = number;
		int div = 2;
		while (div <= temp) {
			int times = 0;
			while (temp % div == 0) {
				times++;
				temp /= div;
			}
			if (times != 0) {
				factor.add(div);
				freq.add(times);
			}
			div++;
		}

		int[][] array = new int[factor.size()][2];
		for (int i = 0; i < factor.size(); i++) {
			array[i][0] = factor.get(i);
			array[i][1] = freq.get(i);
		}

		return array;
	}

	void getAllFactors(int n, int f) {
		if (n > distinctFactors - 1) {
			int i = 0;
			while (divisors[i] != 0)
				i++;
			divisors[i] = f;
			return;
		}
		int temp = f;
		for (int j = 0; j <= factorsArray[n][1]; j++) {
			getAllFactors(n + 1, temp);
			temp *= factorsArray[n][0];
		}
	}

	int numberOfDivisors() {
		int temp = 1;
		for (int[] n : factorsArray) {
			temp *= (n[1] + 1);
		}
		return temp;
	}

	void productWays(Number[] previous) {
		for (int n : divisors) {
			if (n!=1 && n!=number) {
				for (String a : previous[n].product) {
					for (String b : previous[number/n].product) {
						String[] as = a.split(" ");
						String[] bs = b.split(" ");
						if (Integer.valueOf(as[as.length-1])<=Integer.valueOf(bs[0]) && !product.contains(a+b))
							product.add(a + b);
					}
				}
			}
		}
		product.add(number + " ");
	}

}
