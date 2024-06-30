package org.example.twentyfour.june;

import java.util.Arrays;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/06/30 23:07
 */
// 1450
// 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
//
//已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
//
//请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
public class BusyStudent {
    // method1 枚举
    public int busyStudent(int[] st, int[] et, int t) {
        int res = 0;
        for(int i = 0; i < st.length; i++) {
            if (st[i] <= t && et[i] >= t) {
                res++;
            }
        }
        return res;
    }

    // method2 差分数组
    public int busyStudent2(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int maxEndTime = Arrays.stream(endTime).max().getAsInt();
        if (queryTime > maxEndTime) {
            return 0;
        }
        int[] cnt = new int[maxEndTime + 2];
        for (int i = 0; i < n; i++) {
            cnt[startTime[i]]++;
            cnt[endTime[i] + 1]--;
        }
        int ans = 0;
        for (int i = 0; i <= queryTime; i++) {
            ans += cnt[i];
        }
        return ans;
    }
}
