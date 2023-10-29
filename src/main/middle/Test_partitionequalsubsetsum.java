package main.middle;

public class Test_partitionequalsubsetsum {
    public static boolean canPartition(int[] nums) {
        // 找到和是sum/2的子集
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2==1) return false;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int i = nums[0]; i <= sum / 2; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i][sum/2]==sum/2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        canPartition(new int[]{1, 5, 11, 5});
    }
}
