package org.example.twentyfour.march;

import java.util.Map;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/10 21:03
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] a = new int[10];
        int[] b = new int[10];
        int numberA = 0;
        int numberB = 0;
        for(int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                numberA++;
            } else {
                a[s[i] - '0']++;
                b[g[i] - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (a[i] > 0 && b[i] > 0) {
                numberB += Math.min(a[i], b[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(numberA).append('A').append(numberB).append("B").toString();
    }
}
