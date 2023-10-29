package main.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_3sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (-nums[i] == nums[left] + nums[right]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return res;

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];

                if(Math.abs(target-sum)>Math.abs(target-min)){
                    min = sum;
                }
                if(sum>target){
                    q--;
                }else
                    p++;

            }
        }
        return min;
    }

    public static void main(String[] args) {
        new Test_3sum().threeSum(new int[]{3, 0, -2, -1, 1, 2});
    }

}
