package org.example.twentyfour.april;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/25 19:24
 */
// 2739. 总行驶距离
// 该卡车每耗费 1 升燃料都可以行驶 10 km。每当主油箱使用了 5 升燃料时，如果副油箱至少有 1 升燃料，则会将 1 升燃料从副油箱转移到主油箱。
//
//返回卡车可以行驶的最大距离。
public class DistanceTraveled {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank >= 5 && additionalTank > 0) {
            int usePerFive = mainTank / 5;
            int last = mainTank % 5;
            if(additionalTank >= usePerFive) {
                additionalTank -= usePerFive;
                mainTank = last + usePerFive;
                res = res + usePerFive * 50;
            } else {
                mainTank = last + additionalTank;
                additionalTank = 0;
                res = res + usePerFive * 50;
            }
        }
        res += mainTank * 10;
        return res;
    }
}
