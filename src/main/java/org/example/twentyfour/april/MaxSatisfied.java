package org.example.twentyfour.april;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/23 20:16
 */
// 1052
public class MaxSatisfied {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] profit = new int[n];
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 1) {
                // 生气
                profit[i] = customers[i];
            }
        }
        // 滑动窗口
        int maxWindowBegin = 0;
        int currentWindowBegin = 0;
        int maxProfit = 0;
        int currentProfit = 0;
        for(int i = 0; i < minutes; i++) {
            maxProfit += profit[i];
            currentProfit += profit[i];
        }
        while (currentWindowBegin + minutes < n) {
            // 滑动窗口
            currentProfit -= profit[currentWindowBegin];
            currentWindowBegin++;
            currentProfit += profit[currentWindowBegin + minutes - 1];
            if(currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxWindowBegin = currentWindowBegin;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0 || (i >= maxWindowBegin && i < maxWindowBegin + minutes)) {
                res += customers[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int res = maxSatisfied(customers, grumpy, 3);
        System.out.println(res);
    }
}
