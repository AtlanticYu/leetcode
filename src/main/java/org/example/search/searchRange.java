package org.example.search;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/05 15:07
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = search_left_bound(nums, target);
        int right = search_right_bound(nums, target);
        return new int[]{left, right};
    }

    public int search_left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left < 0 || left >= nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    public int search_right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || right >= nums.length) return -1;
        return nums[right] == target ? right : -1;
    }
}
