package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_insertintoabinarysearchtree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        bst(root,val);
        return root;
    }
    public void bst(TreeNode root, int val) {
        if(val>(Integer) root.val){
            if(root.right!=null)
                bst(root.right,val);
            else
                root.right=new TreeNode(val);
        }else {
            if(root.left!=null)
                bst(root.left,val);
            else
                root.left=new TreeNode(val);
        }

    }
}
