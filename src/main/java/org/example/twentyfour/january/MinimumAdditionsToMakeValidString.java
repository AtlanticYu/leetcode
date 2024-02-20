package org.example.twentyfour.january;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/01/11 21:41
 */
public class MinimumAdditionsToMakeValidString {
    public int addMinimum(String word) {
        if (word.length() == 1) {
            return 2;
        }
//        int i = 1, j = 0, k = 0;
//        int result = 0;
//        for(;i < word.length();i++) {
//            int current = word.charAt(i) - 'a';
//            if (j != i) {
//                int currentj = word.charAt(j) - 'a';
//                if (currentj >= current) {
//                    result
//                }
//            }
//        }
        int result = 0;
        int length = 1;
        for(int i = 1; i < word.length(); i++) {
            if (word.charAt(i) - 'a' <= word.charAt(i - 1) - 'a') {
                result += 3 - length;
                length = 1;
            } else {
                length++;
            }
        }
        return result - length + 3;
    }
}
