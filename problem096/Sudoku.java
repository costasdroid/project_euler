package problem096;

import java.util.ArrayList;

public class Sudoku {
	static boolean ended;
	String grid;

	static int sum = 0;

	int[][] table = new int[9][9];

	public Sudoku(String grid, String[] sudoku) {
		this.grid = grid;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				table[i][j] = Integer.valueOf(sudoku[i].charAt(j) + "");
			}
		}
		ended = false;
		fillIt(table, 0, 0);
	}

	private void fillIt(int[][] t, int x, int y) {
		int i = x;
		int j = y;
		if (y > 8) {
			j = 0;
			i++;
		}
		if (i > 8) {
			ended = true;
			sum += t[0][0] * 100 + t[0][1] * 10 + t[0][2];
			return;
		}
		if (t[i][j] != 0) {
			fillIt(t, i, j + 1);
		} else {

			// find numbers not present
			ArrayList<Integer> ar = new ArrayList<Integer>();

			// in same row
			for (int n = 0; n < 9; n++) {
				if (t[i][n] != 0 && !ar.contains(t[i][n]))
					ar.add(t[i][n]);
			}

			// in same column
			for (int n = 0; n < 9; n++) {
				if (t[n][j] != 0 && !ar.contains(t[n][j]))
					ar.add(t[n][j]);
			}

			// in same square
			int rowSquare = i / 3;
			int colSquare = j / 3;
			for (int n = 0; n < 3; n++) {
				for (int m = 0; m < 3; m++) {
					if (t[rowSquare * 3 + n][colSquare * 3 + m] != 0
							&& !ar.contains(t[rowSquare * 3 + n][colSquare * 3
									+ m]))
						ar.add(t[rowSquare * 3 + n][colSquare * 3 + m]);
				}
			}

			if (ar.size() == 9) {
				t[i][j] = 0;
				return;
			}

			// for every not present int, fill the gap and continue
			for (int a = 1; a <= 9; a++) {
				if (!ar.contains(a)) {
					t[i][j] = a;
					fillIt(t, i, j + 1);
					if (ended) {
						return;
					}
					t[i][j] = 0;
				}
			}
		}
	}

	// private void printTable(int[][] t) {
	// 	for (int[] n : t) {
	// 		for (int i : n) {
	// 			System.out.print(i + " ");
	// 		}
	// 		System.out.println();
	// 	}
	// 	System.out.println();
	// }

}
