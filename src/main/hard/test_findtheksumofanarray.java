package main.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test_findtheksumofanarray {
    int k;
    public long kSum(int[] nums, int k) {
        this.k = k;
        priorityQueue.add((long)0);
        Arrays.sort(nums);
        dfs(nums.length-1,nums,0);
        return priorityQueue.peek();
    }
    PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    public void dfs(int begin,int[] nums,long ans){
        for (int i = begin; i >=0; i--) {
            long sum = ans+nums[i];
            if(priorityQueue.size()<k){
                priorityQueue.add(sum);
            }else{
                if (priorityQueue.peek()<sum){
                    priorityQueue.poll();
                    priorityQueue.add(sum);
                }else if (nums[i]<0)
                    return;
            }
            dfs(i-1,nums,sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(new test_findtheksumofanarray().kSum(new int[]{1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009}, 10));

    }
}
