package qz.tx;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(method(arr));

    }

    public static long method(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            max.add(arr[n - i - 1]);
            if (n - i - 1 == i)
                break;
            min.add(arr[i]);
        }
        long ans = 0;
        int x = 0;
        while (!max.isEmpty() && !min.isEmpty()) {
            Integer a = max.removeFirst();//大
            ans += a - x;
            x = a;
            Integer b = min.removeFirst();
            x = b;
        }
        if (!max.isEmpty()) ans += max.removeFirst() - x;
        return ans;
    }
}
