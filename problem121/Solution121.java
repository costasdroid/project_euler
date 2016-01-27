package problem121;

public class Solution121 {

	public static void main(String[] args) {
		
		long t = System.currentTimeMillis();
		double sol = 0;
		
		int draws = 15;
		
		double[][] ps = new double[draws + 1][draws + 1];
		
		ps[1][0] = 1/2.;
		ps[1][1] = 1/2.;
		for (int draw = 2; draw <= draws; draw++) {
			ps[draw][0] = draw * ps[draw - 1][0] / (draw + 1);
			for (int blue = 1; blue <= draw; blue++) {
				ps[draw][blue] = ps[draw - 1][blue - 1] / (draw + 1.) + draw * ps[draw - 1][blue] / (draw + 1.);
				if (draw == draws && blue > draws / 2) sol += ps[draw][blue];
			}
		}
		
		sol = 1 / sol;
		
		System.out.println("Took: " + (System.currentTimeMillis() - t) + "ms");
		System.out.println("Answer: " + (int) sol);

	}

}
