package main.easy;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_balancedbinarytree {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return flag;
    }

    public int getHeight(TreeNode root) {
        if(root ==null)
            return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if(Math.abs(l-r)>1)
            flag = false;
        return Math.max(l,r)+1;
    }
}
