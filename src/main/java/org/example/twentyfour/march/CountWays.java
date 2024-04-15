package org.example.twentyfour.march;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 2580 统计将重叠区间合并成组的方案数
 * @author: rubei
 * @create: 2024/03/27 17:57
 */
public class CountWays {
    public static int countWays(int[][] ranges) {
        // 1 将ranges进行排序
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        Arrays.sort(ranges, (a,b) -> a[0] - b[0]);
        // 2 合并有交集的集合, 统计互相无交集的集合的数量
        int insulateNum = 1;
        int ans = 2;
        int currentMax = ranges[0][1];
        for(int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] > currentMax) {
                insulateNum++;
                ans = ans * 2 % 1000000007;
            }
            currentMax = Math.max(currentMax, ranges[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        countWays(new int[][]{{1,10},{2,5},{3, 9},{4,12},{15,17}});
    }
}
