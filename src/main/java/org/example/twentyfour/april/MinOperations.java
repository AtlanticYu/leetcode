package org.example.twentyfour.april;

import java.util.Arrays;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/08 20:43
 */
// 2009 hard
// 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
//
//如果 nums 满足以下条件，那么它是 连续的 ：
//
//nums 中所有元素都是 互不相同 的。
//nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
//比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
//
//请你返回使 nums 连续 的 最少 操作次数。
public class MinOperations {
    // 分析, 重复的元素是肯定需要被操作的, 且重复的元素可以认为是对结果有+1的贡献
    // 举例, 1, 1, 1, 2, 3, 4, 有多余的2个1, 考虑1,2,3,4的答案,当求出答案为N时, 可以把多余的1操作为max(1,2,3,4) + 1, max(1,2,3,4) + 2
    // 这样计算max - min - 1时, 除了这两个多余的1, 别的元素没有变化, 答案为N(错误, 新引入的重复的元素不一定会使得操作次数+1)
    // 所以step1: 去重数组, 仅处理去重后的数组, 得到的结果再+相同的元素个数即可


    // 排序后, 使用滑动窗口划入数组中的元素, 枚举当前元素为窗口右侧, 划进去的表示不需要操作
    // 设当前a[i] 为 窗口右侧, a[left] 为 窗口左侧,
    // a[left] 需要满足 a[left] >= a[i] - n + 1
    // 否则需要左侧窗口左移, 因为是递增序列, 左移后就有可能满足, 且在枚举 窗口右侧 时, 元素变大, 先前不满足的left更左的元素会更不满足, 满足滑动的特性, 左侧窗口只需要向右移
    // 在枚举右侧窗口且找到合适的左侧窗口时, 更新结果, 取最优
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        // 原地去重数组
        int m = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                // 这样达到去重的前提是nums已经做了排序
                // m表示处理后的不重复的元素, 游标
                nums[m] = nums[i];
                m++;
            }
        }
        // nums 有m个不重复的元素
        int left = 0; // 满足滑动特性, left只会向后移动
        int ans = 0;
        for(int i = 0; i < m; i++) {
            while (nums[left] < nums[i] - n + 1) { //  nums[left] < nums[i] - m + 1 , 应如何改造?, 不能改, 不能单纯认为新增重复的元素就肯定会使得原来的次数新增
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{8,5,9,9,8,4}));;
        System.out.println(minOperations(new int[]{8,5,9,4}));;
    }
}