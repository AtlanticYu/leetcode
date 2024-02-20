package org.example.twentyfour.january;

import java.util.HashMap;
import java.util.HashSet;

public class minExtraChar
{
    // 2707
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String item : dictionary) {
            set.add(item);
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for(int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i -1] +1;
            for(int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[s.length()];
    }
}
