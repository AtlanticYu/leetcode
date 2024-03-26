package org.example.dp;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/25 22:08
 */
public class ChangeReview {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        // dp [i][j] 在金额为i的情况下, 使用前j个硬币, 有dp种方案
        for(int i = 0; i < coins.length; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= amount; i++) {
            for(int j = 1; j <= coins.length; j++) {
                if(i >= coins[j - 1]) {
                    // 不放入该硬币 + 放入该硬币
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                } else {
                    // 不放入该硬币
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[amount][coins.length];
    }
}
