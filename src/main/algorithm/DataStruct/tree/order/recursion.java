package main.algorithm.DataStruct.tree.order;


import main.algorithm.DataStruct.tree.entity.TreeNode;

/**
 * 算法->数据结构->树->递归遍历:
 *  - 先序遍历（递归实现）
 *  - 中序遍历（递归实现）
 *  - 后序遍历（递归实现）
 */
public class recursion {
    public static void preOrder(TreeNode root){
        if(root == null)
            return;
        System.out.printf("%d ",root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.printf("%d ",root.data);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d ",root.data);
    }



    public static void main(String[] args) {
        TreeNode[] treeNode = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            treeNode[i] = new TreeNode(i);
        }
        TreeNode root;
        // init data
        {
            treeNode[5].left = treeNode[3];
            treeNode[5].right = treeNode[8];
            treeNode[3].left = treeNode[1];
            treeNode[3].right = treeNode[4];
            treeNode[8].left = treeNode[7];
            treeNode[8].right = treeNode[9];
            treeNode[1].left = treeNode[0];
            treeNode[1].right = treeNode[2];
            treeNode[7].left = treeNode[6];
            root = treeNode[5];
        }

        System.out.print("\n先序遍历：");
        preOrder(root);

        System.out.print("\n中序遍历：");
        inOrder(root);

        System.out.print("\n后序遍历：");
        postOrder(root);

    }


}
