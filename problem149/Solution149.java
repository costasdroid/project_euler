package problem149;

public class Solution149 {

    final int N = 2000;
    long table[][] = new long[N][N];
    long s[] = new long[N * N + 1];

    long max;

    public static void main(String[] args) {
        Solution149 solution = new Solution149();
        solution.generateS();
        solution.populateTable();

        solution.max = solution.table[0][0];

        solution.eachRow();
        solution.eachColumn();
        solution.eachDiagonal();
        solution.counterDiagonal();
        System.out.println("max: " + solution.max);
    }

    private void generateS() {
        for (int k = 1; k <= 55; k++) {
            s[k] = (long) (100003 - 200003 * (long) k + 300007 * (long) k * k * k) % 1000000 - 500000;
        }
        for (int k = 56; k < N * N + 1; k++) {
            s[k] = (s[k - 24] + s[k - 55] + 1000000) % 1000000 - 500000;
        }

        // System.out.println("s10: " + s[10]);
        // System.out.println("s100: " + s[100]);
    }

    private void populateTable() {
        for (int i = 0; i < N; i++) {
            int index = i * N;
            for (int j = 0; j < N; j++) {
                table[i][j] = (int) s[index + j + 1];
            }
        }
    }

    private void eachRow() {
        long temp;
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                temp = table[i][j];
                if (temp < 0) {
                    compare2max(sum);
                    sum = 0;
                } else {
                    sum += temp;
                }
            }
            compare2max(sum);
        }
    }

    private void eachColumn() {
        long temp;
        for (int j = 0; j < N; j++) {
            long sum = 0;
            for (int i = 0; i < N; i++) {
                temp = table[i][j];
                if (temp < 0) {
                    compare2max(sum);
                    sum = 0;
                } else {
                    sum += temp;
                }
            }
            compare2max(sum);
        }
        System.out.println("max: " + max);
    }

    private void eachDiagonal() {
        for (int j = 0; j < N; j++) {
            long sum = 0;
            for (int i = 0; i < N - j; i++) {
                sum += table[i][i + j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        for (int i = 1; i < N; i++) {
            long sum = 0;
            for (int j = 0; j < N - i; j++) {
                sum += table[i + j][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
    }

    private void counterDiagonal() {
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += table[i - j][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        for (int j = 0; j < N; j++) {
            long sum = 0;
            for (int i = N - 1; i >= j; i--) {
                sum += table[i][N - 1 - i + j];
            }
            if (sum > max) {
                max = sum;
            }
        }
    }

    private void compare2max(long sum) {
        if (sum > max) {
            max = sum;
        }
    }

}