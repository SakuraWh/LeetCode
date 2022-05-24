package main.algorithm.DataStruct.tree.entity;

public class TreeNode<E> {

    public TreeNode left;
    public TreeNode right;
    public E data;

    public TreeNode() {
    }

    public TreeNode(E data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right, E data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
