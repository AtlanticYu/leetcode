package org.example.array;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/20 16:26
 */
// 5 最长回文子串
// 给你一个字符串 s，找到 s 中最长的回文子串。
//如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
public class LongestPalindrome {

    public String res = "";
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String a = findByOne(s, i);
            String b = findByTwo(s, i, i + 1);
            if (a.length() > b.length()) {
                res = res.length() > a.length() ? res : a;
            } else {
                res = res.length() > b.length() ? res : b;
            }
        }
        return res;
    }

    public String findByOne(String s, int cursor) {
        int left = cursor - 1;
        int right = cursor + 1;
        while(left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    public String findByTwo(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) {
            return "";
        }
        left--;
        right++;
        while(left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    // findByOne findByTwo可以用这一个方法统一定义
    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
