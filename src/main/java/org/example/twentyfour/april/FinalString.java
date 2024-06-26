package org.example.twentyfour.april;

/**
 * @description: 2810
 * @author: rubei
 * @create: 2024/04/01 19:45
 */
// 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
//
//给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
//
//返回最终笔记本屏幕上输出的字符串。
public class FinalString {
    public String finalString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : charArray) {
            if(c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
