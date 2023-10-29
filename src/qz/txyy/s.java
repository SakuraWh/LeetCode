package qz.txyy;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.math.BigDecimal;
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class s{
    int mod = 1000000007;
    public int cntOfMethods(TreeNode[] trees) {
        // write code here
        // 求最下层叶子节点个数
        BigDecimal allRoot = new BigDecimal(1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < trees.length; i++) {
            map.put(i, getDeepLeaf(trees[i]));
            allRoot = allRoot.multiply( new BigDecimal(map.get(i)));
        }
        List<Long> list = new ArrayList<>();
        long jc = getJC(trees.length - 1)%mod;  // 找n-1个节点有几种组合
        // 任选一个节点，求剩余节点的组合数*组合可能
        for (int i = 0; i < trees.length; i++) {
            int t = map.get(i);// 当前树的叶子数
            BigDecimal now = allRoot.divide(new BigDecimal(t));


            //list.add((now * jc)%mod);
        }
        long res = 0;
        for (Long aLong : list) {
            res += aLong;
        }
        return (int) ((res * 2) % mod);


    }

    private long getJC(int n) {
        long ans = 1;
        while (n > 0) {
            ans = (n*ans)%mod;
            n--;
        }
        return ans;
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