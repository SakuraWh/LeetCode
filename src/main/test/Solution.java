package main.test;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.*;

class Solution {

    Boolean t  = false;
    public Boolean pathTarget(TreeNode root, int target) {
        recur(root, target);
        return t;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        tar -= root.val;
        if(tar == 0  && root.left == null && root.right == null)
            t = true;
        recur(root.left, tar);
        recur(root.right, tar);
    }
}
