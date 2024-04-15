package org.example.twentyfour.march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxArrayValue {
    public long maxArrayValue(int[] nums) {
        List<Long> list = new ArrayList<>();
        long max = nums[nums.length - 1];
        long[] longArray = new long[nums.length];
        for(int i = 0; i < nums.length; i++) {
            longArray[i] = nums[i];
        }
        for(int i = longArray.length - 1; i > 0; i--) {
            if (longArray[i] < longArray[i - 1]) {
                list.add(longArray[i]);
                max = Math.max(max, longArray[i - 1]);
                continue;
            }
            longArray[i - 1] = longArray[i - 1] + longArray[i];
            max = Math.max(max, longArray[i - 1]);
        }
        list.add(longArray[0]);
        return max;
    }
}
