package qz.tx;

import main.algorithm.DataStruct.tree.entity.TreeNode;

public class Main {
    public static void main(String[] args) {

    }

    public class Solution {
        public int pathNumber(TreeNode root) {
            if (root == null)
                return 0;
            dfs(root, 0, 0);
            return result;
        }

        private int result = 0;

        private void dfs(TreeNode root, int one, int zero) {
            if (root.val == 1)
                one++;
            else
                zero++;
            if (root.left == null && root.right == null) { //叶子节点
                if (one == zero + 1)
                    result++;
                return;
            }
            if (root.left != null)
                dfs(root.left, one, zero);
            if (root.right != null)
                dfs(root.right, one, zero);
        }

    }
}
