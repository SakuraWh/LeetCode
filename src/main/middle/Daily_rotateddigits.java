package main.middle;

public class Daily_rotateddigits {
    class Solution {
        // 0125689
        public int rotatedDigits(int n) {
            int ans =0;
            for (int i = 1; i <= n; i++) {
                boolean check = check(i);
                if(check==true)
                    ans++;

            }
            return ans;

        }
        public boolean check(int x){
            char[] c = (x+"").toCharArray();
            for (char cc :c){
                switch (cc){
                    case '0':break;
                    case '1':break;
                    case '2':break;
                    case '5':break;
                    case '6':break;
                    case '8':break;
                    case '9':break;
                    default:return false;
                }
            }
            return true;
        }
    }
}
