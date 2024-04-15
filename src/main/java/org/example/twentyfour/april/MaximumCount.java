package org.example.twentyfour.april;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/09 19:09
 */
// 2529
public class MaximumCount {
    // 未考虑到多个0的情况
    public static int maximumCount(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        while (left < right) {
            int mid = left - (left - right) / 2;
            if(nums[mid] > 0) {
                right = mid - 1;
            } else if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                return Math.max(mid, n - mid - 1);
            }
        }
        if(nums[left] < 0) {
            return Math.max(left + 1, n - left - 1);
        } else if(nums[left] > 0) {
            return Math.max(left, n - left);
        } else {
            return Math.max(left, n - left - 1);
        }
    }

    public static int maximumCount2(int[] nums) {
        int neg = leftBoundary(nums, 0);
        int pos = nums.length - leftBoundary(nums, 1);
        return Math.max(neg, pos);
    }

    // 寻找第一个>=target的元素下标
    // 如果不存在这样的数，返回 nums.length
    public static int leftBoundary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left < 0 || left >= n) {
            return n;
        }
        return nums[left] >= target ? left : n;
    }
}
