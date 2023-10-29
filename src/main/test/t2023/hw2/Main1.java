package main.test.t2023.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n/16+1];
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = sc.next();
            String s = sc.next();
            int a = Integer.parseInt(s.substring(2),16);
            String s1 = Integer.toBinaryString(a);
            str.append(s1);
        }
        String in = str.toString().substring(0,n);
        func(in);
        //func("11100111011111");

    }

    public static void func(String s) {

        System.out.println(2);
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                list.add(i);
        }
        List<String> raaa = new ArrayList<>();
        int i = 1;
        int left = 0, right = 0;
        while (true) {
            //左移
            left=0;right=0;
            for (int a : list) {
                if ((a - i) >= 0 && s.charAt(a - i) == '0') {
                    break;
                }
                left++;
            }
            //右
            for (int a : list) {
                if ((a + i) < s.length() && s.charAt(a + i) == '0') {
                    break;
                }
                right++;
            }
            if (left == list.size()){
                index = i;
                //System.out.println(index);
                char[] res = new char[s.length()];
                for (int i1 = 0; i1 < res.length; i1++) {
                    res[i1]='0';
                }
                for (int a : list) {
                    res[a-i] = '1';
                }
                raaa.add("+"+index+"");
                raaa.add(res.toString());
                //System.out.println(res);
            }
            if (right == list.size()){
                index = -i;
                //System.out.println(index);
                char[] res = new char[s.length()];
                for (int i1 = 0; i1 < res.length; i1++) {
                    res[i1]='0';
                }
                for (int a : list) {
                    res[a+i] = '1';
                }
                raaa.add(index+"");

                System.out.println(res.toString());
                raaa.add(res.toString());
            }
            if(index!=0)
                break;
            i++;
            if(i>s.length()){
                System.out.println(0);
                break;
            }

        }
        System.out.println(raaa.size()/2);
        for (String s1 : raaa) {
            System.out.println(s1);
        }
    }
}
