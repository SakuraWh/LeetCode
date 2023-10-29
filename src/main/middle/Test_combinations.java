package main.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test_combinations {
    public static void main(String[] args) {

    }
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<Integer>();

            dfs(ans,path,k,n,1);
            return ans;

        }
        public void dfs(List ans,List path,int k,int n,int begin){
           if(path.size() == k){
               ans.add(new ArrayList<>(path));
               return;
           }
           for(int i=begin;i<=n;i++){
               path.add(i);
               dfs(ans,path,k,n,i+1);
               path.remove(path.size()-1);
           }
        }

    }
}
