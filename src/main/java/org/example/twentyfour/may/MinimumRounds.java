package org.example.twentyfour.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/05/14 18:58
 */
// 2244. 完成所有任务需要的最少轮数
public class MinimumRounds {
    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i : tasks) {
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            Integer value = entry.getValue();
            if(value == 1) {
                return -1;
            }
            if(value % 3 == 1) {
                ans = ans + (value / 3) + 1;
            } else if (value % 3 == 2) {
                ans = ans + (value / 3) + 1;
            } else {
                ans = ans + (value / 3);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,2,4,4,4,4,4};
        minimumRounds(nums);
    }
}
