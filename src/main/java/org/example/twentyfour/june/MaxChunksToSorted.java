package org.example.twentyfour.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/06/25 21:32
 */
// leetcode 768
// arr 是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
//
//之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
//
//我们最多能将数组分成多少块？
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int[] clone = arr.clone();
        int ans = 0;
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        // 使用map <int1, int2> 来统计int1 在子序列中出现的频率, tot表示当前有多少个去重后的元素
        for(int i = 0, tot = 0; i < arr.length; i++) {
            int a = arr[i], b = clone[i];
            // 考虑使用map统计字符频率, a增加, b减少
            // 当字符频率从0->1, 1->0, 0->-1, -1->0这四种情况时, 更新tot
            // 当tot为零时，表示arr和clone的[0, i] 子字符串的字符频率相同, 可以分割为答案中的一个"块"
            if(map.getOrDefault(a, 0) == -1) {
                // -1->0
                tot--;
            } else if (map.getOrDefault(a, 0) == 0) {
                // // 0->1
                tot++;
            }
            // 更新map
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.getOrDefault(b, 0) == 1) {
                // 1->0
                tot--;
            } else if (map.getOrDefault(b, 0) == 0) {
                // // 0->-1
                tot++;
            }
            // 更新map
            map.put(b, map.getOrDefault(b, 0) - 1);
            if(tot == 0) {
                ans++;
            }
        }
        return ans;
    }
}
// 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
//
//我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
//
//返回数组能分成的最多块数量。
//
//
//
//示例 1:
//
//输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
//示例 2:
//
//输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
//对每个块单独排序后，结果为 [0, 1], [2], [3], [4]