package problem149;

public class Test {
    final int N = 4;
    long table[][];
    long s[] = new long[N * N + 1];

    long max = -1000000l;

    public static void main(String[] args) {
        Test test = new Test();
        test.table = new long[][] { { -2, 5, 3, 2 }, { 9, -6, 5, 1 }, { 3, 2, 7, 3 }, { -1, 8, -4, 8 } };

        System.out.println("rows: ");
        for (int i = 0; i < 4; i++) {
            long sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += test.table[i][j];
            }
            if (i == 0 || sum > test.max) {
                test.max = sum;
            }
            System.out.println("sum: " + sum);
        }

        System.out.println("columns: ");
        for (int j = 0; j < 4; j++) {
            long sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += test.table[i][j];
            }
            if (sum > test.max) {
                test.max = sum;
            }
            System.out.println("sum: " + sum);
        }

        System.out.println("diagonal 1st row: ");
        for (int j = 0; j < 4; j++) {
            long sum = 0;
            for (int i = 0; i < 4 - j; i++) {
                sum += test.table[i][i + j];
            }
            if (sum > test.max) {
                test.max = sum;
            }
            System.out.println("sum: " + sum);
        }
        System.out.println("diagonal 1st col: ");
        for (int i = 1; i < 4; i++) {
            long sum = 0;
            for (int j = 0; j < 4 - i; j++) {
                sum += test.table[i + j][j];
            }
            if (sum > test.max) {
                test.max = sum;
            }
            System.out.println("sum: " + sum);
        }

        System.out.println("counter diagonal 1st col: ");
        for (int i = 0; i < 4; i++) {
            long sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += test.table[i - j][j];
            }
            if (sum > test.max) {
                test.max = sum;
            }
            System.out.println("sum: " + sum);
        }

        System.out.println("counter diagonal last row: ");
        for (int j = 0; j < 4; j++) {
            long sum = 0;
            for (int i = 3; i >= j; i--) {
                sum += test.table[i][3 - i + j];
            }
            if (sum > test.max) {
                test.max = sum;
            }
            System.out.println("sum: " + sum);
        }

        System.out.println("max: " + test.max);
    }
}
