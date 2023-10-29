package main.middle;

public class Test_containerwithmostwater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            int weight = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, weight);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
