package qz.mi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=1){
            System.out.println(1);
            return;
        }
        job[] arr = new job[n];
        Set<job> zero = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = new job(i);
            zero.add(arr[i]);
        }

        List<String> list = Arrays.stream(sc.next().split(",")).toList();
        for (String s : list) {
            String[] split = s.split(":");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            arr[b].list.add(arr[a]);
            zero.remove(arr[a]);
        }

        if(zero.isEmpty()){
            System.out.println(0);
            return;
        }


        for (job job : zero) {
            if (!bfs(job)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    static boolean bfs(job root){
        // bfs
        Queue<job> queue = new LinkedList<>();
        queue.add(root);
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()){
            job a = queue.poll();
            if(set.contains(a.val))
                return false;
            set.add(a.val);
            for (job job : a.list) {
                queue.add(job);
            }
        }
        return true;
    }

    static class job {
        int val;
        List<job> list;

        job(int val) {
            this.val = val;
            list = new ArrayList<>();
        }
    }
}
