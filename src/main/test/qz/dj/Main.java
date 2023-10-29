package main.test.qz.dj;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int circle_fly(int[] charge, int[] cost) {
        int[] tx = new int[charge.length];
        int sum = 0;
        for (int i = 0; i < charge.length; i++) {
            tx[i] = charge[i] - cost[i];
            sum+=tx[i];
        }
        if(sum<0)
            return -1;


        for (int i = 0; i < tx.length; i++) {
            if(tx[i] < 0)
                continue;
            int f = i;
            int s = 0;
            for (int j = 0; j < tx.length; j++) {
                s+=tx[(j+f)%tx.length];
                if(s<0)
                    break;
                if(j==tx.length-1)
                    return f;
            }

        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int charge_size = 0;
        charge_size = in.nextInt();
        int[] charge = new int[charge_size];
        for(int charge_i = 0; charge_i < charge_size; charge_i++) {
            charge[charge_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int cost_size = 0;
        cost_size = in.nextInt();
        int[] cost = new int[cost_size];
        for(int cost_i = 0; cost_i < cost_size; cost_i++) {
            cost[cost_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new Solution().circle_fly(charge, cost);
        System.out.println(String.valueOf(res));

    }
}
