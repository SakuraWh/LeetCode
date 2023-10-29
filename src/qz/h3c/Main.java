package qz.h3c;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(";");
        int target = Integer.parseInt(ss[1].trim());
        List<Integer> arr = Arrays.stream(ss[0].split(",")).map(a -> a.trim()).map(Integer::parseInt).toList();


        int[] nums = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("Indices:" + i + "," + j);
                    return;
                }
            }
        }
        System.out.println("No two sum solution");

    }
}



