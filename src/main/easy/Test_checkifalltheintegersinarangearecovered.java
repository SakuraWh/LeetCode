package main.easy;

public class Test_checkifalltheintegersinarangearecovered {
    static class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            int[] diff = new int[51];
            for (int[] range : ranges) {
                diff[range[0]]++;
                diff[range[1]+1]--;
            }
            //前缀和
            for (int i = 1; i < 51; i++) {
                diff[i] += diff[i - 1];
            }
            for (int i = left; i <= right; i++) {
                if (diff[i] == 0) return false;
            }
            return true;

        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        new Solution().isCovered(ints, 2, 5);
    }
}
