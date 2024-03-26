package org.example.slidingwindow;

import java.util.HashMap;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/15 18:21
 */
// 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
//换句话说，s1 的排列之一是 s2 的 子串 。
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for(char c : s1.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int cnt = 0;
        while(right < s2.length()) {
            char current = s2.charAt(right);
            right++;
            windowMap.put(current, windowMap.getOrDefault(current, 0) + 1);
            if (windowMap.get(current).equals(targetMap.get(current))) {
                cnt++;
            }
            if (right - left == s1.length()) {
                if (cnt == targetMap.size()) {
                    return true;
                }
                char currentLeft = s2.charAt(left);
                if (windowMap.get(currentLeft).equals(targetMap.get(currentLeft))) {
                    cnt--;
                }
                windowMap.put(currentLeft, windowMap.get(currentLeft) - 1);
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = checkInclusion("ab", "eidbaooo");
        System.out.println(result);
    }
}
