package problem128;

public class Solution128 {

	public static void main(String[] args) {

		// For timing
		long t1 = System.currentTimeMillis();

		new Node(2000);

		long sol = Node.n;
		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

}
