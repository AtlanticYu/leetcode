package org.example.twentyfour.may;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/05/13 19:15
 */
// 994. 腐烂的橘子
// 值 0 代表空单元格；
//值 1 代表新鲜橘子；
//值 2 代表腐烂的橘子。
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int M = grid.length;
        int N = grid[0].length;
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(grid[r][c] == 1) {
                    count++;
                } else if(grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int time = 0;
        while (count > 0 && !queue.isEmpty()) {
            time++;
            int size = queue.size();
            while (size > 0) {
                int[] node = queue.poll();
                size--;
                int row = node[0];
                int col = node[1];
                // 上
                if(row - 1 >= 0 && grid[row - 1][col] == 1) {
                    count--;
                    grid[row - 1][col] = 2;
                    queue.offer(new int[]{row - 1, col});
                }
                // 下
                if(row + 1 < M && grid[row + 1][col] == 1) {
                    count--;
                    grid[row + 1][col] = 2;
                    queue.offer(new int[]{row + 1, col});
                }
                // 左
                if(col - 1 >= 0 && grid[row][col - 1] == 1) {
                    count--;
                    grid[row][col - 1] = 2;
                    queue.offer(new int[]{row, col - 1});
                }
                // 右
                if(col + 1 < N && grid[row][col + 1] == 1) {
                    count--;
                    grid[row][col + 1] = 2;
                    queue.offer(new int[]{row, col + 1});
                }
            }
        }
        if(count == 0) {
            return time;
        }
        return -1;
    }
}
