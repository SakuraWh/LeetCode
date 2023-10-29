package main.middle;

import java.util.Arrays;
import java.util.Random;

public class test_sortanarray {
    public static void main(String[] args) {
        int[] ans = new int[]{5,2,3,1};
        test_sortanarray sort = new test_sortanarray();
        int[] ints = sort.quickSort(ans);
        for (int i : ints) {
            System.out.printf("%d ", i);
        }

    }

    //插入
    public int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int p = i - 1;
            while (p >= 0) {
                if (nums[p] <= nums[i])
                    break;
                p--;
            }
            int target = nums[i];
            int t = i;
            while (t > p + 1) {
                nums[t] = nums[t - 1];
                t--;
            }
            nums[p + 1] = target;
        }
        return nums;
    }

    //折半插入
    public int[] binarySearchSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int r = i - 1;
            int l = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int p = r;
            int t = i;
            while (t > p + 1) {
                nums[t] = nums[t - 1];
                t--;
            }
            nums[p + 1] = target;
        }
        return nums;
    }

    //希尔

    //冒泡

    //快排
    public int[] quickSort(int[] nums) {
        partition(nums, 0, nums.length-1);
        return nums;
    }
    public Random random = new Random();
    public void partition(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int index = random.nextInt(right -left+1)+left;
        int sb = nums[index];
        nums[index] = nums[left];
        nums[left] = sb;
        int i = left, j = right;
        while (i < j) {
            while (j > i && nums[j] >= sb) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= sb) i++;
            nums[j] = nums[i];
        }
        nums[i] = sb;
        partition(nums,left,i-1);
        partition(nums,i+1,right);
    }


    //简单选择

    //堆排序

    // 堆排序
}
