package problem145;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1_000_000_000; i++) {
            if (isReversible(i)) {
                count++;
            }
        }
        System.out.println("The total count of reversible numbers is: " + count);
    }

    private static boolean isReversible(int n) {
        if (n % 10 == 0) {
            return false;
        }
        int sum = n + reverseNumber(n);
        while (sum > 0) {
            int digit = sum % 10;
            if (digit % 2 == 0) {
                return false;
            }
            sum /= 10;
        }
        return true;
    }

    private static int reverseNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }
}