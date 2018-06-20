package helperPackage;

public class Numbers {
	
	//test for primality
	static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if (n % 3 == 0 || n % 2 == 0)
			return false;
		long i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
			i += 6;
		}
		return true;
	}
	static boolean isPrime(int n) {
		return isPrime((long) n);
	}
	
}
