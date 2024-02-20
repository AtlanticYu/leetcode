package org.example.twentyfour.january;

import java.util.*;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/01/23 16:47
 */
// 题号：1657
public class SampleString {
    public static boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> word1Map = new HashMap<>();
        for(int i = 0;i < word1.length(); i++) {
            char current = word1.charAt(i);
            if (word1Map.containsKey(current)) {
                word1Map.put(current, word1Map.get(current) + 1);
            } else {
                word1Map.put(current, 1);
            }
        }
        Map<Character, Integer> word2Map = new HashMap<>();
        for(int j = 0;j < word2.length(); j++) {
            char current = word2.charAt(j);
            if (word2Map.containsKey(current)) {
                word2Map.put(current, word2Map.get(current) + 1);
            } else {
                word2Map.put(current, 1);
            }
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : word1Map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!word2Map.containsKey(key)) {
                return false;
            }
            list1.add(value);
            list2.add(word2Map.get(key));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
    }
}
