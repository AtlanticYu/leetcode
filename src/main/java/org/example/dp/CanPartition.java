package org.example.dp;

import java.util.Arrays;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/20 18:30
 */
// 416 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int bagSize = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i ++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < nums[i - 1]) {
                    // 当前商品无法装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (dp[i - 1][j - nums[i-1]] || dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[nums.length][bagSize];
    }
}
