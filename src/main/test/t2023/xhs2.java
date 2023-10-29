package main.test.t2023;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 第一行一个正整数T，表示有T组数据。
 * <p>
 * 对于每一组数据，第一行输入两个正整数n,k；第二行输入n个数a1,a2,....,an。该序列是一个1~n的排列。
 * <p>
 * 对于所有数据：1≤k≤n≤105,1≤ai≤n, ai≠aj,1≤T≤5
 */
public class xhs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            soulation soulation = new soulation();
            int res = soulation.FUNC(n, k, arr);
            System.out.println(res);
        }

    }


}

/**
 * K排序算法描述如下：首先，算法需要按照某种规则选择该数列上至多K个位置，将其对应的数抽出来，其他的数都往左对齐，之后这K个数排好序之后依次放在原数列末尾。以上过程算作一次操作。
 * <p>
 * 例如，对于数列[1,3,5,4,2]，当K=2时可以选择数字5和4，之后数列变成[1,3,2,4,5]。
 * <p>
 * 你的任务是：对于给定的数列，你需要计算出最少需要多少次上述操作，使得整个数列从小到大排好序？
 */


class soulation {


    public int FUNC(int n, int k, int[] arr) {
        min = Integer.MAX_VALUE;
        // 回溯：r选出两个数执行操作，从第一个不在最终位置的开始选
        target = arr.clone();
        Arrays.sort(target);
        int[] same = new int[arr.length];
        dfs(0, 0,arr);
        return min;
    }

    int[] target; // 已经排好序的数组
    //int[] arr;
    int min;

    public void dfs(int left, int t, int[] arr) {
        if (t >= min)
            return;
        int i = 0;


        for (i = left; i < arr.length; i++) {
            if (arr[i] != target[i])
                break;
        }
        if (i == arr.length) {
            // 所有的都排序好了
            min = Math.min(min, t);
            return;
        }
        // 从i开始选选两个进行排序
        for (int j = i; j < arr.length - 1; j++) {
            for (int l = j + 1; l < arr.length; l++) {
                //选j,l进行操作
                int[] change = change(j, l, arr);

                dfs(i, t + 1, change);
            }
        }
    }

    public int[] change(int i, int j, int[] arr) {
        int a = Math.min(arr[i], arr[j]);
        int b = Math.max(arr[i], arr[j]);
        int[] res = new int[arr.length];
        int t = 0;
        for (int k = 0; k < arr.length; k++) {
            if (k == i || k == j)
                continue;
            res[t++] = arr[k];
        }
        res[t++] = a;
        res[t++] = b;
        return res;
    }
}


/*
1
5 2
1 3 5 4 2

1
4 2
4 3 5


1
5 2
1 2 5 4 3
 */