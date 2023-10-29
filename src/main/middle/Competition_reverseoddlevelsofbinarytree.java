package main.middle;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Competition_reverseoddlevelsofbinarytree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.reverseOddLevels(new TreeNode(new TreeNode(2),new TreeNode(3),1));

        int size = (int) (Math.log((double)1)/Math.log((double)2));
        System.out.println(size);
    }
    static class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            //bfs
            List<Integer> tree = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                if (t.left!=null)queue.add(t.left);
                if (t.right!=null)queue.add(t.right);
                tree.add(t.val);
            }

            int a[] = new int[tree.size()];
            for (int i = 0; i < a.length; i++) {
                a[i]=tree.get(i);
            }


            int size = (int)(Math.log((double)a.length+1)/Math.log((double)2));
            for (int i = 1; i < size; i+=2) {
                int len = (int) Math.pow(2,i);//这层的节点总个数
                int begin  = (int) (Math.pow(2,i)-1);//这层的起始位置
                int p = begin,q=begin+len-1;
                while(p<q){
                    int t = a[p];
                    a[p]=a[q];
                    a[q]=t;
                    p++;
                    q--;
                }
            }
            //获得顺序，再遍历bfs
            queue = new ArrayDeque();
            int k = 0;
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                if (t.left!=null)queue.add(t.left);
                if (t.right!=null)queue.add(t.right);
                t.val=a[k];
                k++;
            }
            return root;

        }


    }
    private static class TreeNode {

        public TreeNode left;
        public TreeNode right;
        public Integer val;

        public TreeNode() {
        }

        public TreeNode(Integer data) {
            this.val = data;
        }

        public TreeNode(TreeNode left, TreeNode right, Integer data) {
            this.left = left;
            this.right = right;
            this.val = data;
        }
    }
}
