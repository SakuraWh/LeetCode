package main.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test_combinationsumiii {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {


            dfs(ans,path,k,n,1,0);
            return ans;
        }

        public void dfs(List ans,LinkedList path,int k,int n,int begin,int sum){
            if(sum == n&&path.size()==k){
                ans.add(new ArrayList(path));
               
            return;
            }

            for(int i = begin;i<=9;i++){
                //if(sum+i>n) break;
                path.push(i);
                dfs(ans,path,k,n,i+1,sum+i);
                path.pop();
            }
        }
        public void dfsf(int begin,int[] nums){
            ans.add(new LinkedList(path));
            for(int i=begin;i<nums.length;i++){
                path.addLast(nums[i]);
                //path.addLast();
                dfsf(i+1,nums);
                path.removeLast();
            }
        }
    }
}
