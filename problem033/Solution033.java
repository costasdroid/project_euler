package problem033;

import java.math.BigInteger;

public class Solution033 {

	public static void main(String[] args) {
		int productNom = 1;
		int productDen = 1;
		for (int i = 10; i <= 99; i++) {
			for (int j = i; j <= 99; j++) {
				if (i != j && (j % 10) * (i % 10) != 0) {
					int a1 = i / 10;
					int b1 = j / 10;
					int a2 = i % 10;
					int b2 = j % 10;
					if (a1 == b1 && i * b2 == j * a2) {
						productNom *= i;
						productDen *= j;
					}
					if (a1 == b2 && i * b1 == j * a2) {
						productNom *= i;
						productDen *= j;
					}
					if (a2 == b1 && i * b2 == j * a1) {
						productNom *= i;
						productDen *= j;
					}
					if (a2 == b2 && i * b1 == j * a1) {
						productNom *= i;
						productDen *= j;
					}
				}
			}
		}
		System.out.println(productDen
				/ (new BigInteger(productDen + "").gcd(new BigInteger(
						productNom + "")).intValue()));
	}
}
