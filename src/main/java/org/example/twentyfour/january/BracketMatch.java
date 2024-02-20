package org.example.twentyfour.january;

import java.util.*;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/01/31 16:59
 */
// 20
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        每个右括号都有一个对应的相同类型的左括号。
public class BracketMatch {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> hashmap = new HashMap<Character, Character>() {{ put(')', '(');put('}', '{');put(']', '[');}};

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for(char c : charArray) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if(c - top != 1 && c - top != 2) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
