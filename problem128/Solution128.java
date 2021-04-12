public class Solution128 {

	public static void main(String[] args) {

		// For timing
		long t1 = System.currentTimeMillis();

		Node node = new Node();

		long sol = node.current.id;
		System.out.println("The solution is: " + sol);
		System.out.println("Took: " + (System.currentTimeMillis() - t1) + "ms");
	}

}
