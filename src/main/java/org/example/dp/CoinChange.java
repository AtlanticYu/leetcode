package org.example.dp;

import java.util.Arrays;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/22 17:42
 */
// 322 零钱兑换
// 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return calculate(coins, amount);
    }

    // 方法一, 自上而下
    private int calculate(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            // 计算子问题的结果
            int subProblem = calculate(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            res = Math.min(subProblem, calculate(coins, amount - coin) + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/
    // 方法二, 自下而上
    public int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] == -1) return -1;
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
