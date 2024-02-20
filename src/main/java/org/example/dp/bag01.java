package org.example.dp;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/20 17:59
 */
// 0,1背包
public class bag01 {
    // 可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]
    int knapsack(int W, int N, int[] wt, int[] val) {
        // dp[i][j] 在前i个物品中, 当背包的容量为j, 最佳方案装入的物品价值为dp[i][j]
        int[][] dp = new int[N + 1][W = 1];
        for (int i = 1; 1 <= N; i ++) {
            for (int j = 1; j < W; j++) {
                if (j < wt[i - 1]) {
                    // 当前商品无法装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][j] = Math.max(
                            dp[i - 1][j - wt[i-1]] + val[i-1],
                            dp[i - 1][j]
                    );
                }
            }
        }
        return dp[N][W];
    }
}
