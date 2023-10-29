package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_constructbinarytreefrominorderandpostordertraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public static void main(String[] args) {
        new Solution().buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }
    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 1. post最后一个是根
            // 2. in根左边确定左子树，右边二确定右子树
            if(postorder.length==0)
                return null;
            int root = postorder[postorder.length-1];
            TreeNode node = new TreeNode(root);
            int div=-1;
            for(int i=0;i<inorder.length;i++){
                if(inorder[i]==root){
                    div=i;
                    break;
                }
            }
            if(div==-1)
                return null;
            int[] left_in = new int[div];
            int[] right_in = new int[inorder.length-div-1];
            for(int i=0;i<left_in.length;i++) left_in[i]=inorder[i];
            for(int i=div+1;i<inorder.length;i++) right_in[i-div-1] = inorder[i];

            int[] left_post = new int[div];
            int[] right_post = new int[inorder.length-div-1];
            for(int i=0;i<left_post.length;i++) left_post[i]=postorder[i];
            for(int i=left_post.length;i<postorder.length-1;i++) right_post[i-left_post.length] = postorder[i];

            node.left = buildTree(left_in,left_post);
            node.right = buildTree(right_in,right_post);
            return node;
        }

    }
}
