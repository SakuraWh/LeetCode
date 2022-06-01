package main.middle;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.*;

public class Test_binarytreelevelordertraversalii {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

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
                list.add((Integer) n.data);
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
        Collections.reverse(res);
        return res;

    }
}
