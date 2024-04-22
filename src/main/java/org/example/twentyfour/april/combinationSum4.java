package org.example.twentyfour.april;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/22 19:49
 */
// 377. 组合总和 Ⅳ
// 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
// 和 零钱兑换2 不同, 本题的题解答案顺序不同即为新的答案
// https://leetcode.cn/problems/combination-sum-iv/solutions/2624750/yi-ci-xing-dai-ni-gao-ding-suo-you-bei-b-8059/?envType=daily-question&envId=2024-04-22
// https://leetcode.cn/problems/combination-sum-iv/solutions/2238348/xian-xun-huan-wu-pin-he-xian-xun-huan-be-t5kl/ 改写为二维
public class combinationSum4 {
    // 换零钱: dp[i][j] 表示在背包容量为i时, 使用前j个数组可以凑出target的组合数
    // 此处dp[i][j]的含义：第一个放入的物品为物品0-i，恰好装满容量为j的背包方式数
    // 注意本题为组合问题, 当dp[i][j]时, 第一次挑选机会已经被占用, 剩下i - 1次的挑选机会均可从当前全量商品中进行挑选, 结果会比换零钱更为丰富
    public static int combinationSum4(int[] nums, int target) {
        int m = nums.length;
        int[][] dp = new int[m][target + 1];
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 因为需要初始化dp[0][j], 所以需要先遍历背包
        for(int j = 1; j < target; j++) {
            // m - 1的含义: 排除当前选择, 剩余m -1 次选择均可从全量的数组中进行挑选
            if(j >= nums[0]) {
                dp[0][j] = dp[m - 1][j - nums[0]];
            }
            for(int i = 1 ; i < m; i++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // dp[i - 1][j]：第一个放入的物品为物品0-(i-1)，恰好装满容量为j的背包方式数
                    // dp[M - 1][j - weight[i]]：第一个放入的物品为物品i，恰好装满容量为j的背包的方式数
                    dp[i][j] = dp[i - 1][j] + dp[m - 1][j - nums[i]];
                }
            }
        }
        return dp[m - 1][target];
    }

    public static void main(String[] args) {
        int res = combinationSum4(new int[]{1,2,3}, 4);
        System.out.println(res);
        int[][][] ss = new int[2][2][2];
    }
}
