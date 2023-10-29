package main.easy;

public class Daily_defusethebomb {

    class Solution {
        public int[] decrypt(int[] code, int k) {
            int[] ans = new int[code.length];
            int n = code.length;
            if(k==0)
                return ans;
            if(k>0){
                int sum=0;
                for (int i = 0; i < k; i++)
                    sum+=code[i];
                for (int i = 0; i < code.length; i++) {
                    sum-=code[(i+n)%n];
                    sum+=code[(i+k+n)%n];
                    ans[i]=sum;
                }
            }else {
                k=-k;
                int sum =0;
                for (int i = 0; i < k; i++)
                    sum+=code[(-i-1+n)%n];
                for (int i = 0; i < n; i++) {
                    sum-=code[(i-k+n)%n];
                    sum+=code[(i-1+n)%n];
                    ans[i] =sum;
                }
            }
            return ans;
        }
    }

}
