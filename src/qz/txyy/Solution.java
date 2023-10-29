package qz.txyy;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.*;


public class Solution {
    //    public int fun (int n) {
//        String s = String.valueOf(n);
//        int count = 0;
//        while(s.length()>=0){
//            if(Integer.parseInt(s)%5==0)
//                return count;
//            s = s.substring(0,s.length()-1);
//            count++;
//            if(s.length()==0)
//                s="0";
//        }
//        return -1;
//    }
//
//
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param t string字符串
//     * @return int整型
//     */
//    public int cntOfMethod(String t) {
//        // write code here
//        this.t = t;
//        return count;
//    }
//
//    String t;
//    int count = 0;
//    Map<String, String> map = new HashMap<>();
//
//    public void dfs(int begin, String s, Map<String, String> map) {
//        if (s.length() == t.length()) {
//            count++;
//            return;
//        }
//        // 添加任意字符
//        addMapItem(map,t.charAt(begin));
//
//
//        dfs(begin + 1, s + t.charAt(begin), map);
//
//        // 复制子串
//
//
//    }
//
//    public void addMapItem(Map<String, String> map, char c) {
//        Set<String> strings = map.keySet();
//        for (String s : strings) {
//            map.put(s + c,s + c);
//        }
//    }
    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[2];
        treeNodes[0] = new TreeNode(1);
        treeNodes[0].right = new TreeNode(2);

        treeNodes[1] = new TreeNode(3);
        treeNodes[1].left = new TreeNode(4);
        treeNodes[1].right = new TreeNode(5);

        System.out.println(new Solution().cntOfMethods(treeNodes));
    }

    List<Integer> list = new ArrayList<>();
    int mod = 1000000007;
    int all = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int cntOfMethods(TreeNode[] trees) {
        for (int i = 0; i < trees.length; i++) {
            map.put(i, getDeepLeaf(trees[i]));
        }
        dfs(trees.length,new boolean[trees.length],1);
        return all;
    }

    private void dfs(int n, boolean[] visit, int sum) {
        if (list.size() == n - 1) {
            all = (all + sum) % mod;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            list.add(i);
            dfs(n, visit, (2 * sum * map.get(i)) % mod);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }


    private int getDeepLeaf(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            n = len;
            for (int i = 0; i < len; i++) {
                TreeNode t = queue.poll();
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
        }
        return n;
    }


}