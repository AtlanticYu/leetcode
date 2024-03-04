package org.example.doubleindicator;

import java.util.HashMap;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/24 13:52
 */
// 3 给定一个字符串，请你找出其中不含有重复字符的「最长子串」的长度。
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while(map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
