package main.easy;

public class Daily_largesttrianglearea {
    /**
     * 海伦公式：鉴定为纯纯的数学题，高中知识，傻逼不想做
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE, max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE;
        for (int[] a : points) {
            min_x = Math.min(a[0], min_x);
            min_y = Math.min(a[1], min_y);
            max_x = Math.max(a[0], max_x);
            max_y = Math.max(a[1], max_y);
        }
        System.out.println(min_x);
        System.out.println(min_y);
        System.out.println(max_x);
        System.out.println(max_y);
        int len = max_x - min_x;
        int high = max_y - min_y;

        return len * high /2.0;
    }

}
