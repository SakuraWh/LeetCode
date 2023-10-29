package main.hard;

public class Test_trappingrainwater {
    public static void main(String[] args) {
        new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

}

class Solution {
    public int trap(int[] height) {
        int[] pre = new int[height.length];
        int[] end = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            pre[i] = Math.max(pre[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            end[i] = Math.max(end[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < pre.length; i++) {
            int x = Math.min(pre[i], end[i]) - height[i];
            if (x > 0)
                res += x;
        }
        return res;

    }
}