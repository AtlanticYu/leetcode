package org.example.twentyfour.march;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/18 21:22
 */
public class NumArray {
    private static int[] sumNum;

    public NumArray(int[] nums) {
        sumNum = new int[nums.length];
        sumNum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sumNum[i] = nums[i] + sumNum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumNum[right];
        }
        return sumNum[right] - sumNum[left - 1];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
//        int res1 = numArray.sumRange(0, 2);
        int res2 = numArray.sumRange(2, 5);
        int res3 = numArray.sumRange(0, 5);
        System.out.println(res3);
    }
}
