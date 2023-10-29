package main.easy;

import main.algorithm.DataStruct.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test_findmodeinbinarysearchtree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(1), new TreeNode(3), 2);
        new Solution().findMode(treeNode);
    }

    static class Solution {
        List<Integer> list = new ArrayList<>();//次数等于最大值的数

        int maxsum = 0;//最大出现次数
        int nownum = Integer.MIN_VALUE;//当前数
        int nowsum = 0;//当前数出现次数
        public int[] findMode(TreeNode root) {

            inorder(root);
            if(maxsum<nowsum){
                //清楚list
                list.clear();
                list.add(nowsum);
                maxsum = nowsum;
            }else if(maxsum == nowsum){
                list.add(nownum);
            }
            int[] ans = new int[list.size()];
            for(int i=0;i<ans.length;i++){
                ans[i]=list.get(i);
            }
            return ans;
        }
        public void inorder(TreeNode root){
            if(root==null)
                return;
            inorder(root.left);
            if(nownum==Integer.MIN_VALUE){
                nownum=root.val;
                nowsum=1;
                maxsum = nowsum;
            }else if(nownum==root.val){
                nowsum++;
            }else{
                if(maxsum<nowsum){
                    //清楚list
                    list.clear();
                    list.add(nownum);
                    maxsum = nowsum;
                }else if(maxsum == nowsum){
                    list.add(nownum);
                }
                nownum=root.val;
                nowsum=1;
            }
            inorder(root.right);
        }
    }
}
