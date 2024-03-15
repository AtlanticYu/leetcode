package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/06 10:07
 */
//76. 最小覆盖子串
// 当前的写法会超时,
// 更优的写法 https://labuladong.online/algo/essential-technique/sliding-window-framework/#%E4%B8%80%E3%80%81%E6%9C%80%E5%B0%8F%E8%A6%86%E7%9B%96%E5%AD%90%E4%B8%B2
public class MinWindow {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int left = 0, right = t.length();
        String res = "";
        while(left < right && right <= s.length()) {
            String currentString = s.substring(left, right);
            if (isContain(currentString, t)) {
                if (res == "" || res.length() > currentString.length()) {
                    res = currentString;
                }
                left++;
            } else {
                right++;
            }
        }
        return res;
    }

    // 判断subString是否涵盖 target 中的所有字符
    public static boolean isContain(String subString, String target) {
        if (target.length() > subString.length()) return false;
        char[] subStringCharArray = subString.toCharArray();
        char[] targetCharArray = target.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(Character c : subStringCharArray) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(Character c : targetCharArray) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Integer a = map1.get(entry.getKey());
            if (a == null) return false;
            if (a < entry.getValue()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String res = minWindow("", "ABC");
        System.out.println(res);
    }

    // 优化写法
    public static String minWindow2(String s, String t) {
        char[] arrayT = t.toCharArray();
        HashMap<Character, Integer> hashMapT = new HashMap<>();
        for(char at : arrayT) {
            hashMapT.put(at, hashMapT.getOrDefault(at, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int cnt = 0;
        String result = "";
        int left = 0, right = 0;
        while (right < s.length()) {
            char current = s.charAt(right);
            right++;
            window.put(current, window.getOrDefault(current, 0) + 1);
            if (window.get(current).equals(hashMapT.get(current))) {
                cnt++;
            }
            while (cnt == hashMapT.size()) {
                if (result == "" || right - left < result.length()) {
                    result = s.substring(left, right);
                }
                char leftChar = s.charAt(left);
                if (window.get(leftChar).equals(hashMapT.get(leftChar))) {
                    cnt--;
                }
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
        }
        return result;
    }
}
