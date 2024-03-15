package org.example.search;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/05 14:45
 */
public class leftBound {
    static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 如果越界，target 肯定不存在，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int res = left_bound(new int[]{1,1,2,2,3}, 2);
        System.out.println(res);
    }
}
