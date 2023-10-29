package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Test_binarytreelevelordertraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int k =1;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int kt=0;
            for (int i = 0; i < k; i++) {

                TreeNode n = queue.poll();
                list.add((Integer) n.val);
                if(n.left!=null){
                    queue.offer(n.left);
                    kt++;
                }
                if(n.right!=null){
                    queue.offer(n.right);
                    kt++;
                }
            }
            k=kt;
            res.add(list);
        }
        return res;


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
        Test_binarytreelevelordertraversal test_binarytreelevelordertraversal = new Test_binarytreelevelordertraversal();
        test_binarytreelevelordertraversal.levelOrder(root);

    }
}
