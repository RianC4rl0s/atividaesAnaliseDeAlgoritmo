import java.util.Arrays;

public class Main {

    public static int maxSubarraySum(int[] A) {
        int n = A.length;
        int maxSum = A[0];
        int currentSum = A[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(A[i], currentSum + A[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static int solidez(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.max(0, A[0]);
        }
        int[] dp = new int[n];
        dp[0] = Math.max(0, A[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i-1] + A[i]);
        }
        int maxSum = maxSubarraySum(A);
        if (maxSum <= 0) {
            return -maxSum;
        }
        return Math.max(maxSum, Arrays.stream(dp).max().getAsInt());
    }
    public static void main(String[] args) {
        int[] arr = {20, -30, 15, -10, 30, -20, -30, 30};
        int n = arr.length;
        int maxSum = solidez(arr);
        System.out.println("A soma máxima em um subvetor do vetor dado é " + maxSum);
    }
}
