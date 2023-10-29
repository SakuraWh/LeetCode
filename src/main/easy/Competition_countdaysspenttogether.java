package main.easy;

import java.util.Arrays;

public class Competition_countdaysspenttogether {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDaysTogether("10-20", "12-22", "06-21", "07-05"));
    }

    static class Solution {
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int arriveA_M,arriveA_D,leaveA_M,leaveA_D;
            int arriveB_M,arriveB_D,leaveB_M,leaveB_D;

            String[] split = arriveAlice.split("-");
            arriveA_M = Integer.parseInt(split[0]);
            arriveA_D = Integer.parseInt(split[1]);

            split = leaveAlice.split("-");
            leaveA_M = Integer.parseInt(split[0]);
            leaveA_D = Integer.parseInt(split[1]);

            split = arriveBob.split("-");
            arriveB_M = Integer.parseInt(split[0]);
            arriveB_D = Integer.parseInt(split[1]);

            split = leaveBob.split("-");
            leaveB_M = Integer.parseInt(split[0]);
            leaveB_D = Integer.parseInt(split[1]);

            int[] a = oneDohowdaytoday(arriveA_M, arriveA_D, leaveA_M, leaveA_D);
            int[] b = oneDohowdaytoday(arriveB_M, arriveB_D, leaveB_M, leaveB_D);
            if(a[0]<=b[0]&&a[1]>=b[0]&&a[1]<b[1])
                return a[1]-b[0]+1;
            if(a[0]>=b[0]&&b[1]>=a[0]&&b[1]<=a[1])
                return b[1]-a[0]+1;
            if(a[0]<=b[0]&&a[1]>=b[1])
                return b[1]-b[0]+1;
            if(a[0]>=b[0]&&b[1]>=a[1])
                return a[1]-a[0]+1;
            return 0;
        }

        public int[] oneDohowdaytoday(int arrM,int arrD,int leaM,int leaD){
            int[] mouth = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int begin = 0;
            for(int i= 0;i<arrM;i++){
                begin+=mouth[i];
            }
            begin += arrD;

            int end = 0;
            for(int i= 0;i<leaM;i++){
                end+=mouth[i];
            }
            end += leaD;
            return new int[]{begin,end};

        }
    }
}
