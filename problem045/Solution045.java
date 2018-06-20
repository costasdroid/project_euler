public class Solution045 {

	public static void main(String[] args) {
		
		int n = 144;
		long temp = n * (2 * n - 1);
		
		while(!isPentagonal(temp) && !isTriangular(temp)) {
			n++;
			temp = n * (2 * n - 1);
		}
		System.out.println(temp);
	}

	static boolean isTriangular(long n) {
		return ((int) (Math.sqrt(8 * n - 1) - 1) / 2) == (Math.sqrt(8 * n - 1) - 1) / 2;
	}
	
	static boolean isPentagonal(long n) {
		return ((int) (Math.sqrt(24 * n + 1) + 1) / 6) == (Math.sqrt(24 * n + 1) + 1) / 6;
	}

}
