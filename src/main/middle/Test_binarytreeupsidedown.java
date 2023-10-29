package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Test_binarytreeupsidedown {
    public static void main(String[] args) {
        new Test_binarytreeupsidedown().upsideDownBinaryTree(new TreeNode(new TreeNode(2), new TreeNode(3), 1));
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return reverse(root);
    }

    public TreeNode reverse(TreeNode root) {
        if (root.left == null)
            return root;
        root.left.left = reverse(root.right);
        root.left.right = reverse(root);
        return root.left;
    }
}
