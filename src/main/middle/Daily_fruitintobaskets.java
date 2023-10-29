package main.middle;

public class Daily_fruitintobaskets {
    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }

    static class Solution {
        /**
         * 采用动态规划的思想，申请dp[2][n]
         *      第一行表示：当前第i个元素作为第一个装进篮子里的水果的最大长度
         *      第二行表示：当前第i个元素作为第二个装进篮子里的水果的最大长度
         * 在定义a,b两个篮子作为第一个，第二个篮子
         * 则：
         *      1) 当前水果与上一种水果同类型：
         *          则 dp[][i] = dp[][i-1]
         *      2) 当前水果与上一种水果不同类型，但在已经在篮子中：
         *          dp[0][i] = 1 代表当前类型如果作为第一个装进篮子里的最大长度
         *          dp[1][i] = dp[1][i-1] +1 代表当前水果依然可以接到最长长度中
         *      3) 当前水果与上一种水果同类型，且不在篮子里：
         *          dp[0][i] = 1 代表当前类型如果作为第一个装进篮子里的最大长度
         *          dp[1][i] = dp[0][i-1] +1 代表当前水果作为第二个装进篮子的，去加上上一个水果作为第一个装进来水果的长度
         *
         *      注意：要去维护ab两个篮子，时刻保持在当前第i次装箱时 a作为第一个篮子，b作为第二个篮子
         */
        public int totalFruit(int[] fruits) {
            int res = 1;
            int[][] dp = new int[2][fruits.length];
            int a = -1, b = -1; // a表示第一个装进篮子里的，b表示第二个
            dp[0][0] = 1;
            dp[1][0] = 1;
            b = fruits[0];
            for (int i = 1; i < fruits.length; i++) {
                if (fruits[i] == fruits[i - 1]) {
                    dp[0][i] = dp[0][i - 1] + 1;
                    dp[1][i] = dp[1][i - 1] + 1;
                } else if (fruits[i] == a || fruits[i] == b) {//还在集合内，但前一个不同
                    dp[0][i] = 1;
                    dp[1][i] = dp[1][i - 1] + 1;
                    if (fruits[i] == a) {
                        //保证b是当前元素
                        a = b;
                        b = fruits[i];
                    }
                } else { // 不在集合里
                    a = b;
                    b = fruits[i];
                    dp[0][i] = 1;
                    dp[1][i] = dp[0][i - 1] + 1;
                }
                res = Math.max(dp[1][i], res);
            }
            return res;
        }
    }
}
