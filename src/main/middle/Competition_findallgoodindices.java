package main.middle;

import java.util.*;

public class Competition_findallgoodindices {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{253747,459932,263592,354832,60715,408350,959296};
        solution.goodIndices(a,2);

    }
    static class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            List<Integer> ans = new ArrayList<>();
            if(nums.length<=2*k)
                return ans;
            Left left = new Left();
            Right right = new Right();
            //初始化左右
            for (int j = 0; j < k; j++) {
                left.add(nums[j]);
            }
            for (int j = k+1; j <2*k; j++) {
                right.add(nums[j]);
            }


            for (int i = k; i < nums.length-k; i++) {

                right.add(nums[i+k]);
                if(left.is_k(k)&& right.is_T())
                    ans.add(i);
                if(left.is_k(k))
                    left.remove();
                left.add(nums[i]);
                right.remove();
            }
            return ans;
        }
        class Left{
            Deque<Integer> list = new LinkedList<>();
            int k = 0;
            Left(){}
            public void add(int x){
                if (!list.isEmpty()&&x>list.getLast()){
                    list = new LinkedList<>();
                    k=0;
                }
                list.addLast(x);
                k++;
            }

            public void remove(){
                list.removeFirst();
                k--;
            }
            public  boolean is_k(int k){
                if(this.k==k)
                    return true;
                return false;
            }
        }
        class Right{
            List<Integer> list = new ArrayList<>();
            int k = 0;

            Right(){}
            public void add(int x){
                list.add(x);
            }

            public void remove(){
                list.remove(0);
            }
            public  boolean is_T(){
                for (int i = 1; i < list.size(); i++) {
                    if(list.get(i)<list.get(i-1))
                        return false;
                }
                return true;
            }
        }
    }


}
