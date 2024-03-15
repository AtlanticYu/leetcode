package org.example.twentyfour.march;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/06 21:53
 */
// 2917
// 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
//
//nums 中的 K-or 是一个满足以下条件的非负整数：
//
//只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。
//返回 nums 的 K-or 值。
//
//注意 ：对于整数 x ，如果 (2i AND x) == 2i ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。
// 总结 把nums都转化为二进制, 遍历每个nums的第i位, 如果为1的数字和大于k, 则对结果贡献该二进制位置的1
public class FindKOr {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for(int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) == 1) {
                    cnt++;
                }
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
