public class Solution049 {

	public static void main(String[] args) {
		for (int i = 1000; i <= 9999; i++) {
			if (!(i==1487) && isPrime(i)) {
				for (int j = 2; j <= (10000 - i) / 2; j = j + 2) {
					if (isPrime(i + j) && isPrime(i + 2 * j)) {
						if (arePermuted(i, i + j, i + 2 * j))
							System.out.println(i +""+ (i+j) + "" + (i + 2*j));
					}
				}
			}
		}
	}

	private static boolean arePermuted(int n, int k, int l) {
		String s1 = n + "";
		String s2 = k + "";
		String s3 = l + "";

		for (int i = 0; i < s1.length(); i++) {
			if (!s2.contains(s1.charAt(i) + "")
					|| !s3.contains(s1.charAt(i) + ""))
				return false;
			if (!s1.contains(s2.charAt(i) + "")
					|| !s3.contains(s2.charAt(i) + ""))
				return false;
			if (!s2.contains(s3.charAt(i) + "")
					|| !s1.contains(s3.charAt(i) + ""))
				return false;
		}

		return true;
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
