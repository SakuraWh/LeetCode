package main.easy;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_maximumdepthofbinarytree {

    public int maxDepth(TreeNode root) {
       return dfs(root,1);

    }
    private int dfs(TreeNode root,int deep){
        if(root==null)
            return deep-1;
        int l = dfs(root.left,deep+1);
        int r = dfs(root.right,deep+1);
        return Math.max(l,r);
    }
}
