package org.example.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/18 15:07
 */
// 46 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        boolean[] hasViewed = new boolean[nums.length];
        backtrack(nums, trace, hasViewed);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> trace, boolean[] hasViewed) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList(trace));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (hasViewed[i] == true) {
                continue;
            }
            hasViewed[i] = true;
            trace.add(nums[i]);
            backtrack(nums, trace, hasViewed);
            hasViewed[i] = false;
            trace.removeLast();
        }
    }
}
