package main.algorithm.template;

import com.sun.scenario.effect.Merge;
import main.algorithm.DataStruct.tree.entity.TreeNode;

public class 分治法 {
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
