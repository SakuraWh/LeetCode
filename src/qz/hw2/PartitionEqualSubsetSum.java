package qz.hw2;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public int largestSumPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return 0;
        }

        int target = totalSum / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums = {2,4,6,8,10};

        if (solution.canPartition(nums)) {
            int result = solution.largestSumPartition(nums);
            System.out.println("最大相等和为: " + result);
        } else {
            System.out.println("无法分割成两个相等的子集");
        }
    }
}
