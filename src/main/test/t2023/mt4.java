package main.test.t2023;

import java.util.Scanner;

/**
 * 小D和小W最近在玩坦克大战，双方操控自己的坦克在16*16的方格图上战斗，小D的坦克初始位置在地图的左上角，朝向为右，其坐标(0,0)，小W的坦克初始位置在地图右下角，朝向为左，坐标为(15,15)。坦克不能移动到地图外，坦克会占领自己所在的格子，己方的坦克不可以进入对方占领过的格子。每一个回合双方必须对自己的坦克下达以下5种指令中的一种：
 *
 * • 移动指令U：回合结束后，使己方坦克朝向为上，若上方的格子未被对方占领，则向当前朝向移动一个单位（横坐标-1），否则保持不动；
 *
 * • 移动指令D：回合结束后，使己方坦克朝向为下，若下方的格子未被对方占领，则向当前朝向移动一个单位（横坐标+1），否则保持不动；
 *
 * • 移动指令L：回合结束后，使己方坦克朝向为左，若左侧的格子未被对方占领，则向当前朝向移动一个单位（纵坐标-1），否则保持不动；
 *
 * • 移动指令R：回合结束后，使己方坦克朝向为右，若右侧的格子未被对方占领，则向当前朝向移动一个单位（纵坐标+1），否则保持不动；
 *
 * • 开火指令F：己方坦克在当前回合立即向当前朝向开火；
 *
 * 己方坦克开火后，当前回合己方坦克的正前方若有对方的坦克，对方的坦克将被摧毁，游戏结束，己方获得胜利；若双方的坦克在同一回合被摧毁，游戏结束，判定为平局；若双方的坦克在同一回合内进入到同一个未被占领的格子，则双方的坦克发生碰撞，游戏结束，判定为平局；当游戏进行到第256个回合后，游戏结束，若双方坦克均未被摧毁，则占领格子数多的一方获得胜利，若双方占领的格子数一样多，判定为平局。 * 注意，若一方开火，另一方移动，则认为是先开火，后移动。
 *
 * 现在小D和小W各自给出一串长度为256的指令字符串，请你帮助他们计算出游戏将在多少个回合后结束，以及游戏的结果。
 */
public class mt4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String dd = scanner.next();
            String ww = scanner.next();
            char[] d = dd.toCharArray();
            char[] w = ww.toCharArray();
            int[][] path = new int[16][16];
            path[0][0] = 1;//左上角d 上下左右 1234
            path[15][15] = -1;//右下角w 上下左右 -1234
            tank dtank = new tank(0, 0, 'R', 1);
            tank wtank = new tank(15, 15, 'L', -1);
            int i = 0;
            for (; i < 256; i++) {
                if (d[i] != 'F' && w[i] != 'F') {
                    //都移动
                    path = dtank.move(d[i], path);
                    path = wtank.move(w[i], path);
                    if (dtank.x == wtank.x && dtank.y == wtank.y) {
                        //撞车
                        System.out.println(i + 1);
                        System.out.println("P");
                        break;
                    }
                } else if (d[i] != 'F' && w[i] == 'F') {
                    //w攻击
                    boolean attack = wtank.attack(path, dtank.x, dtank.y);
                    if (attack) {
                        System.out.println(i + 1);
                        System.out.println("W");
                        break;
                    }
                    path = dtank.move(d[i], path);
                } else if (d[i] == 'F' && w[i] != 'F') {
                    //w攻击
                    boolean attack = dtank.attack(path, wtank.x, wtank.y);
                    if (attack) {
                        System.out.println(i + 1);
                        System.out.println("D");
                        break;
                    }
                    path = wtank.move(w[i], path);
                } else {
                    //都攻击
                    boolean dattack = dtank.attack(path, wtank.x, wtank.y);
                    boolean wattack = wtank.attack(path, dtank.x, dtank.y);
                    if (dattack && wattack) {
                        System.out.println(i + 1);
                        System.out.println("P");
                        break;
                    } else if (dattack) {
                        System.out.println(i + 1);
                        System.out.println("D");
                        break;
                    } else if (wattack) {
                        System.out.println(i + 1);
                        System.out.println("W");
                        break;
                    } else {
                        System.out.println(i + 1);
                        System.out.println("P");
                        break;
                    }
                }

            }
            if (i == 256) {
                int res = 0;
                for (int j = 0; j < 16; j++) {
                    for (int k = 0; k < 16; k++) {
                        res += path[j][k];
                    }
                }
                System.out.println(256);
                if (res > 0) {
                    System.out.println("D");
                } else if (res < 0) {
                    System.out.println("W");
                } else
                    System.out.println("P");
            }

            //数格子

        }
    }

    static class tank {
        int x, y;//坐标
        char to;//朝向 shangx
        int z;//占领标志

        public tank(int x, int y, char to, int z) {
            this.x = x;
            this.y = y;
            this.to = to;
            this.z = z;
        }

        public boolean attack(int[][] path, int x, int y) {
            //target : xy
            switch (to) {
                case 'R':
                    if (this.x == x && this.y < y)
                        return true;
                case 'L':
                    if (this.x == x && this.y > y)
                        return true;
                    break;
                case 'U':
                    if (this.y == y && this.x > x)
                        return true;
                    break;
                case 'D':
                    if (this.y == y && this.x < x)
                        return true;
                    break;
            }
            return false;

        }

        int[][] move(char c, int[][] path) {
            switch (c) {
                case 'R':
                    if (y < 16 && path[x][y + 1] != -z) {
                        y++;
                        path[x][y] = z;
                    }
                    break;
                case 'L':
                    if (y > 0 && path[x][y - 1] != -z) {
                        y--;
                        path[x][y] = z;
                    }
                    break;
                case 'U':
                    if (x > 0 && path[x - 1][y] != -z) {
                        x--;
                        path[x][y] = z;
                    }
                    break;
                case 'D':
                    if (x < 16 && path[x + 1][y] != -z) {
                        x++;
                        path[x][y] = z;
                    }
                    break;
            }
            to = c;
            return path;
        }
    }
}
