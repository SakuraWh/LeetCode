package main.test.t2023;

import java.util.*;

public class bd3 {
    public void main(String[] args) {
        new Soulation().func();
    }
    class Soulation {
        Map<Integer, Node> map;

        public void func() {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                String s = sc.next();
                //构建树
                Node[] tree = new Node[n];
                map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    tree[i] = new Node(s.charAt(i));
                    tree[i].val = i + 1;
                    map.put(i + 1, tree[i]);
                }
                int res = 0;
                List<int[]> bian = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    // TODO 求权值
                    int t = Math.min(a, b);
                    int p = Math.max(a, b);
                    Node parent = map.get(t);
                    Node son = map.get(p);
                    if (parent.left == null) {
                        parent.left = son;
                    } else {
                        parent.right = son;
                    }
                    son.parent = parent;

                    bian.add(new int[]{t, p});

                }
//            block = 1;
//            dfs(tree[0],tree[0].color);
//            System.out.println(block);
                for (int[] ints : bian) {
                    res += GetWeight(ints[0], ints[1], tree[0]);
                }
                System.out.println(res);
            }
        }

        public int GetWeight(int a, int b, Node root) {
            // 1.树分成两个子树 //b是a的子树 a为根
            Node parent = map.get(a);
            Node son = map.get(b);
            int x, y;
            if (son == parent.left) {
                parent.left = null;
                //// 2.求每个子树的连通块个数
                x = GetConnectBlock(son);
                y = GetConnectBlock(root);
                parent.left = son;
            } else {
                parent.right = null;
                x = GetConnectBlock(son);
                y = GetConnectBlock(root);
                parent.right = son;
            }
            //// 3.求权值
            return Math.abs(x - y);
        }

        int block;

        public int GetConnectBlock(Node root) {
            block = 1;
            dfs(root, root.color);
            return block;
        }


        public void dfs(Node root, char color) {
            // 采用bfs求连通块个数
            if (root == null)
                return;
            if (color != root.color) {
                block++;
            }
            dfs(root.left, root.color);
            dfs(root.right, root.color);
        }


    }

    class Node {
        char color;//0r 1b
        Node left, right, parent;
        int val;

        public Node() {

        }

        public Node(char color) {
            this.color = color;
        }

        public Node(char color, Node left, Node right) {
            this.color = color;
            this.left = left;
            this.right = right;
        }
    }
}


