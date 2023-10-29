package main.hard;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_binarytreemaximumpathsum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        l=l<0?0:l;
        r=r<0?0:r;
        int val = l + r + root.val;
        max = Math.max(val, max);
        return Math.max(root.val+l,root.val+r);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(-1);
        System.out.println(new Test_binarytreemaximumpathsum().maxPathSum(treeNode));


    }


}
