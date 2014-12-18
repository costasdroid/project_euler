public class Solution047 {

	public static void main(String[] args) {
		 for (int n = 3; n <= 1000000; n++) {
			 if (howManyFactors(n)==4) {
				 if (howManyFactors(n+1) == 4 && howManyFactors(n+2) == 4 && howManyFactors(n+3) == 4) {
					 System.out.println(n);
					 break;
				 }
			 }
		 }
	}

	static int howManyFactors(int n) {
		int factors = 0;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				factors++;
				while (n % i == 0) {
					n = n / i;
				}
			}
		}
		return factors + 1;
	}

}
