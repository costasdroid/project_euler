package problem012;

import java.util.ArrayList;
import java.util.List;

public class Solution012 {

	static List<Long> list;
	static List<Long> ocs;
	
	public static void main(String[] args) {
		
		Long t1 = System.currentTimeMillis();
		
		long sum = 1;
		
		for (int i = 2; i <= 100000; i++) {
			list = new ArrayList<Long>();
			ocs = new ArrayList<Long>();
			sum = sum + i;
			findPrimes(sum);
			if (makeDivisorsFrom(ocs) > 500) {
				System.out.println(sum);
				break;
			}
		}
		System.out.println("Time: " + (System.currentTimeMillis() - t1));
	}

	private static void findPrimes(long n) {

		while (n > 1) {
			Long i;
			for (i = (long) 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					if (list.contains(i)) {
						ocs.set(list.indexOf(i), ocs.get(list.indexOf(i)) + 1);
					} else {
						list.add(i);
						ocs.add(1L);
					}
					n = n / i;
					break;
				}
			}
			if (i > Math.sqrt(n)) {
				if (list.contains(n)) {
					ocs.set(list.indexOf(n), ocs.get(list.indexOf(n)) + 1);
				} else {
					list.add(n);
					ocs.add(1L);
				}
				break;
			}
		}

	}
	
	private static Long makeDivisorsFrom(List<Long> l) {
		Long count = 1L;
		for (Long i: l) {
			count = count * (i + 1);
		}
		return count;
	}
}
