public class Solution026 {

	public static void main(String[] args) {
		int maxOrder = 0;
		int temp;
		int number = 1;
		for (int i = 2; i <= 1000; i++) {
			temp = orderOf10In(i);
			if (temp > maxOrder) {
				maxOrder = temp;
				number = i;
			}
		}
		System.out.println(number);
	}

	static int orderOf10In(int n) {
		int order = 0;

		int temp = 10;

		while (temp > 1 && order <= n) {
			order++;
			temp = (10 * temp) % n;
		}

		if (order > n)
			return 0;
		else
			return order;
	}

}
