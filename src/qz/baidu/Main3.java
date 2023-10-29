package qz.baidu;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        methodLoader methodLoader = new methodLoader();
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            switch (op) {
                case 1: methodLoader.create(str);break;
                case 2: methodLoader.invoke(str);break;
            }
        }

    }

    static class methodLoader {
        Map<String, List<method>> map = new HashMap<>();

        public void create(String str) {
            method m = new method(str);
            List<method> list = map.getOrDefault(m.name, new ArrayList<>());
            for (method method : list) {
                if (method.equalObejct(m)) {
                    System.out.printf("method %s is already defined.\n", m.name);
                    return;
                }
            }
            list.add(m);
            map.put(m.name, list);
            System.out.println("ok.");
        }

        public void invoke(String str) {
            String name = method.getStrName(str);
            if (map.getOrDefault(name, new ArrayList<>()).size() == 0) {
                System.out.println("cannot find symbol solve.");
                return;
            }
            List<method> list = map.getOrDefault(name,new ArrayList<>());
            for (method method : list) {
                if (method.equalInvoke(str)) {
                    System.out.println("ok.");
                    return;
                }
            }
            System.out.printf("method %s cannot be applied to given types.\n", name);
        }
    }

    static class method {
        String name;
        String type;
        List<String> varType = new ArrayList<>();


        public method(String str) {
            int i = str.indexOf(" ");
            type = str.substring(0, i);
            int j = str.indexOf("(");
            name = str.substring(i + 1, j);
            String vars = str.substring(j + 1, str.length() - 1);
            String[] s = vars.split(",");
            for (String s1 : s) {
                String[] s2 = s1.split(" ");
                varType.add(s2[0]);
            }
        }

        public boolean equalInvoke(String str) {
            int j = str.indexOf("(");
            name = str.substring(0, j);
            String vars = str.substring(j + 1, str.length() - 1);
            String[] s = vars.split(",");
            List<String> varTypeNew = new ArrayList<>(Arrays.asList(s));
            if (varTypeNew.size() != varType.size())
                return false;
            for (int i = 0; i < varType.size(); i++) {
                if (!varTypeNew.get(i).equals(varType.get(i)))
                    return false;
            }
            return true;
        }

        public boolean equalObejct(method m) {
            if (!m.name.equals(name))
                return false;
            if (m.varType.size() != varType.size())
                return false;
            for (int i = 0; i < varType.size(); i++) {
                if (!m.varType.get(i).equals(varType.get(i)))
                    return false;
            }
            return true;
        }

        public static String getStrName(String str) {
            int j = str.indexOf("(");
            return str.substring(0, j);
        }

    }
}
