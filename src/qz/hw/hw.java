package qz.hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hw {
    static final int MAX = 35;
    static int dx[] = new int[]{0, 0, 1, -1};
    static int dy[] = new int[]{1, -1, 0, 0};
    static int m, n;
    static int[][] mp = new int[MAX][MAX];
    static int[][] dist = new int[MAX][MAX];

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                mp[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Node> q = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            if (mp[i][1] == 1) {
                dist[i][1] = 0;
                q.add(new Node(i, 1));
            }
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && mp[nx][ny] == 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }
        int minDist = -1;
        for (int i = 1; i <= m; i++) {
            if (mp[i][n] == 1 && dist[i][n] != -1) {
                if (minDist == -1 || dist[i][n] < minDist) {
                    minDist = dist[i][n];
                }
            }
        }
        return minDist;
    }
}
