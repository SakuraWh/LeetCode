package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_lowestcommonancestorofabinarytree {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return result;
    }
    public boolean dfs(TreeNode root,TreeNode p, TreeNode q){
        if(root==null)
            return false;
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if(l&&r){
            result = root;
        }else if(l||r&&(root==p||root==q)){
            result = root;
        }else if(l||r){
            return true;
        }else if((root==p||root==q))
            return true;
        return false;

    }
}
