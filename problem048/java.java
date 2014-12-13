public class Solution048 {

	public static void main(String[] args) {
		long sum = 0;
		long temp;
		for (int i=1; i<1001; i++) {
			temp = 1;
			for (int j=i; j>=1; j--) {
				temp = (temp * i) % 10000000000l;
			}
			sum = (sum + temp) % 10000000000l;
		}
		System.out.println(sum);
	}
}
