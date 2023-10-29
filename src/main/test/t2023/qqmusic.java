//package main.test.t2023;
//
//import main.algorithm.DataStruct.tree.entity.TreeNode;
//
//import java.util.*;
//
//public class qqmusic {
//    public static void main(String[] args) {
//        solution solution = new solution();
////        System.out.println(solution.getCnt("aABbbC"));
//       // System.out.println(solution.getMaxValue("ababbbb", 2));
//    }
//}
//
///*
// * public class TreeNode {
// *   int val = 0;
// *   TreeNode left = null;
// *   TreeNode right = null;
// *   public TreeNode(int val) {
// *     this.val = val;
// *   }
// * }
// */
//
//class xSolution {
//
//    int[][] dp;
//    int len;
//
//    public int getMaxValue(String str, int k) {
//        // write code here
//        // [i,j]保存字符串i-j的权值
//        // dp[i][j]
//        dp = new int[str.length()][str.length()];
//        len = str.length();
//        for (int i = 0; i < str.length(); i++) {
//            STR sp = new STR();
//            for (int j = i; j < str.length(); j++) {
//                sp.add(str.charAt(j));
//                dp[i][j] = sp.getWeight();
//            }
//        }
//        //回溯
//        min = Integer.MAX_VALUE;
//        hs(0, 0, k, 0);
//        return min;
//    }
//
//    int min;
//
//    //t当前第t份 ，sum当前的和,begin起始
//    public void hs(int t, int sum, int k, int begin) {
//        if (begin >= len)
//            return;
//        if (t == k - 1) {
//            min = Math.min(min, sum + dp[begin][len - 1]);
//            return;
//        }
//        if (sum > min)
//            return;//cut
//
//        for (int i = begin; i < len; i++) {
//            hs(t + 1, sum + dp[begin][i], k, i);
//        }
//    }
//
//    class STR {
//        Map<Character, Integer> map = new HashMap<>();
//        LinkedList<Character> list = new LinkedList<>();
//
//        public void add(char c) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            list.addLast(c);
//        }
//
//        public int getWeight() {
//            return map.size() * list.size();
//        }
//
//    }
//
//    //---------------------------------------
//    public int getCnt(String str) {
//        // write code here
//        int t = 0;
//        char c = toLow(str.charAt(0));
//
//        for (int i = 1; i < str.length(); i++) {
//            char k = toLow(str.charAt(i));
//            if (k == c) {
//                t++;
//            }
//            c = k;
//        }
//        return t;
//    }
//
//    public char toLow(char c) {
//        if (c >= 'A' && c <= 'Z') {
//            c = (char) (c - 'A' + 'a');
//        }
//        return c;
//    }
////---------------------------------------
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param root TreeNode类
//     * @return TreeNode类
//     */
////    public TreeNode fun(TreeNode root) {
////        // write code here
////        //知道节点个数，奇数层，偶数层
////        bfs(root);
////        sum = sum_a + sum_b;
////        int a = sum / 2;
////        int b = sum - a;
////        use = new boolean[sum + 1];
////        tree = new int[sum + 1];
////
////        ans_a = 0;
////        ans_b = 0;
////        sum = 0;
////
////    }
////
////    int sum;
////    int ans_a;
////    int ans_b;
////    boolean[] use;
////    int num;
////    int[] tree;
////
////    public boolean ds(TreeNode root, int t) {
////        if (root == null)
////            return false;
////        if (num == sum) {
////            return true;
////        }
////        if (use[t] == true)
////            return false;
////
////        for (int i = 1; i < sum; i++) {
////            root
////        }
////
////    }
//
//
//    int sum_a = 0;//奇数层个数
//    int sum_b = 0;//偶然层个数
//
//    public void bfs(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        sum_a++;
//        int k = 1;//层数
//        int len = 1;
//        while (queue.isEmpty()) {
//            if (k % 2 == 1) {
//                sum_a += len;
//            } else {
//                sum_b += len;
//            }
//            int next_len = 0;
//            for (int i = 0; i < len; i++) {
//                TreeNode node = queue.removeFirst();
//                if (node.left != null) {
//                    queue.addLast(node.left);
//                    next_len++;
//                }
//                if (node.right != null) {
//                    queue.addLast(node.right);
//                    next_len++;
//                }
//            }
//            len = next_len;
//        }
//    }
//}