package main.algorithm.template;


import main.algorithm.DataStruct.tree.entity.TreeNode;

public class bin {
    public int[] traversal(TreeNode root){
        // nil or leaf
        if(root == null)  {
            // do something and return
        }

        // Divide
        int[] left = traversal(root.left);
        int[] right = traversal(root.right);

        // Merge
        int[] result = new int[0];//merge left + right

        return result;
    }
}
