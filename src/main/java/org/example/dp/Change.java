package org.example.dp;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/22 19:21
 */
// 518 零钱兑换2
// 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//
//请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//
//假设每一种面额的硬币有无限个。
//
//题目数据保证结果符合 32 位带符号整数。

public class Change {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        // dp[i][j] 在金额为i时, 使用前j种硬币, 能达到的最大凑成次数
        for(int i = 0; i <= coins.length; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= amount; i++) {
            for(int j = 1; j <= coins.length; j++) {
                if (coins[j - 1] > i) {
                    // 不放入该硬币
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 不放入该硬币 + 放入该硬币
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                }
            }
        }
        return dp[amount][coins.length];
    }

    // 一维, 排列背包, 先遍历物品, 再遍历背包（零钱2）
    public int chang2e(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i] <= j) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
