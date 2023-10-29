package main.hard;

import java.util.PriorityQueue;

public class Test_medianoftwosortedarrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> small_heap = new PriorityQueue<>();
        PriorityQueue<Integer> big_heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : nums1) {
            small_heap.add(i);
        }
        for (int i : nums2) {
            small_heap.add(i);
        }
        for (int i = 0; i < (nums1.length + nums2.length) / 2; i++) {
            big_heap.add(small_heap.poll());
        }
        if (big_heap.size() == small_heap.size()) {
            double v = big_heap.poll() / 2.0 + small_heap.poll() / 2.0;
            return v;
        } else {
            return small_heap.poll();
        }
    }
}
