package main.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Test_slidingwindowmedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> res = new ArrayList<>();

        PriorityQueue<Integer> big_heap = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        PriorityQueue<Integer> small_heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            big_heap.add(nums[i]);
            // 当k为记述，取bigheap,偶数取两个heap/2
        }
        for (int i = 0; i < k / 2; i++) {
            small_heap.add(big_heap.poll());
        }
        double t = 0;
        for (int i = 0; i < nums.length - k; i++) {

            if (big_heap.size() == small_heap.size()) {
                //两个都取
                t = (big_heap.peek()/ 2.0 + small_heap.peek()/ 2.0) ;
            } else {
                //取大的
                t = (double) big_heap.peek();
            }
            res.add(t);
            //滑动窗口
            if (nums[i] > t) {
                //在大的那一半里 small_heap
                small_heap.remove(nums[i]);//延迟删除
            }else {
                big_heap.remove(nums[i]);
            }
            if(nums[i+k]>t){
                small_heap.add(nums[i+k]);
            }else {
                big_heap.add(nums[i+k]);
            }
            while (small_heap.size() > big_heap.size()) big_heap.add(small_heap.poll());
            while (big_heap.size() - small_heap.size() > 1) small_heap.add(big_heap.poll());
        }
        if (big_heap.size() == small_heap.size()) {
            //两个都取
            t = (big_heap.peek()/ 2.0 + small_heap.peek()/ 2.0) ;
        } else {
            //取大的
            t = (double) big_heap.peek();
        }
        res.add(t);
        //System.out.println(res);
        double[] ress = new double[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }

    public static void main(String[] args) {
        int[] ints = {2147483647,2147483647};
        new Test_slidingwindowmedian().medianSlidingWindow(ints, 2);
    }
}
