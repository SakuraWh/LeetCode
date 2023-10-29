package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_validatebinarysearchtree {
    public boolean isValidBST(TreeNode root) {
        return div(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }
    public boolean div(TreeNode root,long min,long max) {
        if (root == null)
            return true;
        if((long)root.val>min&&(long)root.val<max){
            boolean left = div(root.left,min,(long) root.val);
            System.out.println(left);
            boolean right = div(root.right,(long)root.val,max);
            return left && right;
        }
        return false;

    }
}
