package hw;


/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：批次计算任务
 *
 * @author 命题组
 * @since 2020-05-23
 */

public class Main11 {
    private static int[] getActiveUserNum(String[] logs) {
        Map<String,Set<String>> map = new HashMap<>();
        for (String log : logs) {
            String[] s = log.split("\\|");
            if(s[2].equals("/login.do")&&s[3].equals("success")){
                Set<String> set = map.getOrDefault(s[0], new HashSet<>());
                set.add(convertIp(s[1]));
                map.put(s[0],set);
            }
        }
        int k = 0;
        int[] res = new int[32];
        for (String s : map.keySet()) {
            int day = Integer.parseInt(s.split("-")[2]);
            res[day] += map.get(s).size();
        }

        for (int i = 1; i < res.length; i++) {
            if(res[i]!=0)
                k++;
        }
        res[0]=k;
        return res;
    }
    private static String convertIp(String s){
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("\\.");
        for (String string : split) {
            int i = Integer.parseInt(string);
            sb.append(i+".");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    // main入口由OJ平台调用
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());

        int num = Integer.parseInt(cin.nextLine());
        String[] logs = new String[num];
        for (int i = 0; i < num; i++) {
            logs[i] = cin.nextLine();
        }
        cin.close();

        int[] results = getActiveUserNum(logs);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", strResult));
    }
    private static int getLongestFlawedVowelSubstrLen(int flaw, String input) {
        if(isU(input.charAt(0))&&isU(input.charAt(input.length()-1)))
            if(input.length()<=2)
            return input.length();
        return 0;

    }
    private static boolean isU(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
            return true;
        return false;
    }
}