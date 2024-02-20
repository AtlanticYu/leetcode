package org.example.twentyfour.february;

import java.util.*;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/05 14:43
 */
// 24
public class NumsGame {

    public static int[] plusOne(int[] nums, int cursor) {
        int[] newArray = Arrays.copyOf(nums, nums.length);
        newArray[cursor]++;
        return newArray;
    }

    public static int[] subtractOne(int[] nums, int cursor) {
        int[] newArray = Arrays.copyOf(nums, nums.length);
        newArray[cursor]--;
        return newArray;
    }

    public static int[] numsGame(int[] nums) {
        // 记录已经穷举过的密码，防止走回头路
        Set<IntArray> visited = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int[][] initial = new int[2][nums.length];
        initial[0] = nums;
        initial[1] = new int[nums.length];
        q.offer(initial);
        visited.add(new IntArray(nums));
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[][] current = q.poll();
                if(isSatisfyRule(current[0])) {
                    for(int s = 0; s < current[1].length; s++) {
                        current[1][s] = current[1][s] % 1000000007;
                    }
                    return current[1];
                }
                for (int j = 0; j < nums.length; j++) {
                    int[] tempIndicator = Arrays.copyOf(current[1], current[1].length);
                    tempIndicator[j]++;
                    int[] up = plusOne(current[0], j);
                    if (!visited.contains(up)) {
                        int[][] temp = new int[2][nums.length];
                        temp[0] = up;
                        temp[1] = tempIndicator;
                        q.offer(temp);
                        visited.add(new IntArray(up));
                    }
                    int[] down = subtractOne(current[0], j);
                    if (!visited.contains(down)) {
                        int[][] temp = new int[2][nums.length];
                        temp[0] = down;
                        temp[1] = tempIndicator;
                        q.offer(temp);
                        visited.add(new IntArray(down));
                    }
                }
            }
        }
        return new int[nums.length];
    }

    public static boolean isSatisfyRule(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        for(int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] result = numsGame(new int[]{3,4,5,1,6,7});
        System.out.println(result);
    }

    private static class IntArray {
        private int[] array;

        public IntArray(int[] array) {
            this.array = array;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IntArray other = (IntArray) obj;
            return Arrays.equals(array, other.array);
        }
    }
}
