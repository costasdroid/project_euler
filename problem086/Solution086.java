package problem086;

public class Solution086 {

	public static void main(String[] args) {
		
		long t = System.currentTimeMillis();
		
		final int TARGET = 1000000;
		
		int count = 0;
		int a = 0;

		while (count < TARGET) {
			a++;
			for (int b = 1; b <= a; b++) {
				for (int c = 1; c <= b; c++) {
					double short1 = Math.sqrt(a * a + (b + c) * (b + c));
					
					//There is no need for other instances as the shortest is the above
					
					//double short2 = Math.sqrt(b * b + (a + c) * (a + c));
					//double short3 = Math.sqrt(c * c + (a + b) * (a + b));
					//double tempMin = (short1 < short2) ? short1 : short2;
					//double min = (tempMin < short3) ? tempMin : short3;
					if (short1 == (int) short1)
						count++;
				}
			}
		}

		int sol = a;
		
		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + sol);
	}

}
