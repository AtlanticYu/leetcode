package org.example.twentyfour.march;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/21 18:34
 */
// 2671. 频率跟踪器
public class FrequencyTracker {
    // a, b  数字a, 数字a出现的次数
    private HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    // c, d  出现的次数c, 有几个这样的出现频率
    private HashMap<Integer, Integer> frequencyMapStatistic = new HashMap<>();

    public FrequencyTracker() {

    }

    public void add(int number) {
        frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        // 增加 frequencyMap.get(number) 的频率
        frequencyMapStatistic.put(frequencyMap.get(number), frequencyMapStatistic.getOrDefault(frequencyMap.get(number), 0) + 1);
        // 减少 frequencyMap.get(number) - 1 的频率
        if (frequencyMap.get(number) - 1 > 0 && frequencyMapStatistic.containsKey(frequencyMap.get(number) - 1)) {
            frequencyMapStatistic.put(frequencyMap.get(number) - 1, frequencyMapStatistic.get(frequencyMap.get(number) - 1) - 1);
        }
    }

    public void deleteOne(int number) {
        if (frequencyMap.containsKey(number)) {
            int value = frequencyMap.get(number);
            frequencyMap.put(number, value - 1);
            // 减小 frequencyMap.get(number) 的频率
            frequencyMapStatistic.put(value, frequencyMapStatistic.get(value) - 1);
            // 增加 frequencyMap.get(number) - 1 的频率
            frequencyMapStatistic.put(value - 1, frequencyMapStatistic.getOrDefault(value - 1, 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return frequencyMapStatistic.containsKey(frequency) && frequencyMapStatistic.get(frequency) > 0;
    }

    public static void main(String[] args) {
        FrequencyTracker f = new FrequencyTracker();
        f.add(5);
        f.add(4);
        f.deleteOne(6);
        f.deleteOne(4);
        f.deleteOne(7);
        boolean result = f.hasFrequency(1);
        System.out.println(result);
    }
}