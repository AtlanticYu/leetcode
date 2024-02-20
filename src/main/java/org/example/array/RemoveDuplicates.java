package org.example.array;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/20 13:48
 */
// 26 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，
// 使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
