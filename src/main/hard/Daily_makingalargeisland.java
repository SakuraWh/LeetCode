package main.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Daily_makingalargeisland {
    public static void main(String[] args) {
        //int[][] a = new int[][]{{1,1,0},{0,0,1},{1,1,1}};
        //int[][] a = new int[][]{{0,0},{0,0}};
        int[][] a = new int[][]{{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}};

        new Solution().largestIsland(a);
    }
    static class Solution {
        //dfs 染色法
        Map<Integer,Integer> map;
        public int largestIsland(int[][] grid) {
            map = new HashMap<>();
            int c =2;
            for(int i=0;i<grid.length;i++)
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] ==1){
                        map.put(c,0);
                        dfsColor(grid,i,j,c);
                        c++;
                    }
                }

            if (map.isEmpty())
                return 1;
            int max_area = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 0){
                        int[] a = new int[]{0,0,0,0};
                        int[] b = new int[]{0,0,0,0};

                        if(i>0&&grid[i-1][j]!=0){
                            a[0] = map.get(grid[i-1][j]);
                            b[0] = grid[i-1][j];
                        }
                        if(j>0&&grid[i][j-1]!=0){
                            a[1] = map.get(grid[i][j-1]);
                            b[1] = grid[i][j-1];
                        }
                        if(i<grid.length-1&&grid[i+1][j]!=0){
                            a[2] = map.get(grid[i+1][j]);
                            b[2] = grid[i+1][j];
                        }
                        if (j<grid[0].length-1&&grid[i][j+1]!=0){
                            a[3] = map.get(grid[i][j+1]);
                            b[3] = grid[i][j+1];
                        }

                        Arrays.sort(b);
                        int t =map.getOrDefault(b[0],0);
                        for (int k = 1; k < 4; k++) {
                            if(b[k]!=b[k-1])
                                t +=map.getOrDefault(b[k],0);
                        }
                        max_area = Math.max(t+1,max_area);

                    }
                }
            }
            if(max_area==0)
                return grid.length*grid[0].length;

            return  max_area;
        }

        public void dfsColor(int[][] g,int i,int j,int c){
            if(g[i][j]==1){
                g[i][j] = c;
                map.put(c,map.get(c)+1);
            }else
                return;
            if(i>0)
                dfsColor(g,i-1,j,c);
            if(j>0)
                dfsColor(g,i,j-1,c);
            if(i<g.length-1)
                dfsColor(g,i+1,j,c);
            if (j<g[0].length-1)
                dfsColor(g,i,j+1,c);
        }

    }
}
