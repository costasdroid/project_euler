package problem015;
//Recursive. From every cell, we can go either right (with the right's cell paths)
//	or down (with the under's cell paths), so we must add them. We begin by setting
//	all right and under cells with 1 (only one path) and from bottom to top we pass
//	through all cells

public class Solution015 {
	
	static final int N = 40;
	
	static long[][] paths;
	
	public static void main(String[] args) {
		
		long t1 = System.currentTimeMillis();
		
		paths = new long[N][N];

		for (int i = 0; i < N; i++) {
			paths[i][N - 1] = 1;
		}
		for (int j = 0; j < N; j++) {
			paths[N - 1][j] = 1;
		}
		
		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 2; j >= 0; j--) {
				paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
			}
		}

		System.out.println(paths[0][0]);
		
		System.out.println("Time: " + (System.currentTimeMillis() - t1));
		
	}	

}
