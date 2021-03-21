public class Cuboid {
	int[][][] shape;
	int dimX;
	int dimY;
	int dimZ;
	int needed;
	int lastLayerSymbol;
	int maxN;

	public Cuboid(int dimX, int dimY, int dimZ, int n) {
		this.needed = 0;
		this.lastLayerSymbol = 1;
		this.maxN = n;
		this.dimX = dimX;
		this.dimY = dimY;
		this.dimZ = dimZ;
		this.shape  = new int[dimX][dimY][dimZ];
		for (int x = 0; x < dimX; x++) {
			for (int y = 0; y < dimY; y++) {
				for (int z = 0; z < dimZ; z++) {
					shape[x][y][z] = lastLayerSymbol;
				}
			}
		}
	}

	public void nextLayer() {
		shape = copy(shape, dimX, dimY, dimZ);
		dimX += 2;
		dimY += 2;
		dimZ += 2;
		needed = 0;

		for (int x = 0; x < dimX; x++) {
			for (int y = 0; y < dimY; y++) {
				for (int z = 0; z < dimZ; z++) {
					if (z > 0 && shape[x][y][z] == lastLayerSymbol && shape[x][y][z - 1] == 0) {
						shape[x][y][z - 1] = lastLayerSymbol + 1;
						needed++;
					}
					if (z < dimZ - 1 && shape[x][y][z] == lastLayerSymbol && shape[x][y][z + 1] == 0) {
						shape[x][y][z + 1] = lastLayerSymbol + 1;
						needed++;
					}
					if (x > 0 && shape[x][y][z] == lastLayerSymbol && shape[x - 1][y][z] == 0) {
						shape[x - 1][y][z] = lastLayerSymbol + 1;
						needed++;
					}
					if (x < dimX - 1 && shape[x][y][z] == lastLayerSymbol && shape[x + 1][y][z] == 0) {
						shape[x + 1][y][z] = lastLayerSymbol + 1;
						needed++;
					}
					if (y > 0 && shape[x][y][z] == lastLayerSymbol && shape[x][y - 1][z] == 0) {
						shape[x][y - 1][z] = lastLayerSymbol + 1;
						needed++;
					}
					if (y < dimY - 1 && shape[x][y][z] == lastLayerSymbol && shape[x][y + 1][z] == 0) {
						shape[x][y + 1][z] = lastLayerSymbol + 1;
						needed++;
					}
				}
				if (needed > maxN) {
					return;
				}
				// System.out.println("this row: " + needed);
			}
		}
		lastLayerSymbol++;
		return;
	}

	private int[][][] copy(int[][][] t, int x, int y, int z) {
		int[][][] temp = new int[x + 2][y + 2][z + 2];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < z; k++) {
					temp[i + 1][j + 1][k + 1] = t[i][j][k];
				}
			}
		}
		return temp;
	}
}
