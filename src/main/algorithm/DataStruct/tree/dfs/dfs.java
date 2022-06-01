package main.algorithm.DataStruct.tree.dfs;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class dfs {

    public static void up_down(TreeNode root){
        if(root ==null)
            return;
        System.out.print(" "+root.data);
        up_down(root.left);
        up_down(root.right);
    }

    /**
     * 如需存储结果，需采用分治法，既将所得结果返回后合并
     *
     * 分治和递归的区别：是否返回值进行合并
     * @param root
     */
    public static void down_up(TreeNode root){
        if(root ==null)
            return;
        down_up(root.left);
        down_up(root.right);
        System.out.print(" "+root.data);
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

        System.out.print("\nDFS从上往下：");
        up_down(root);

        System.out.print("\nDFS从下往上：");
        down_up(root);

    }
}
