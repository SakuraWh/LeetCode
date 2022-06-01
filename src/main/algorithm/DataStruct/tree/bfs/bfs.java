package main.algorithm.DataStruct.tree.bfs;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs {

    public static void bfs(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            System.out.print(t.data);
            if (t.left!=null)
                queue.offer(t.left);
            if (t.right!=null)
                queue.offer(t.right);
        }
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

        System.out.print("\nbfs：");
        bfs(root);

    }
}
