package org.example.twentyfour.may;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/05/09 21:45
 */
public class MinimumRefill {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int midLeft = plants.length / 2 - 1;
        int midRight;
        if(plants.length % 2 == 0) {
            midRight = midLeft + 1;
        } else {
            midRight = midLeft + 2;
        }
        int supplyWaterA = 0;
        int fullA = capacityA;
        int fullB = capacityB;
        int supplyWaterB = 0;
        for(int i = 0; i <= midLeft; i++) {
            if(capacityA < plants[i]) {
                supplyWaterA += 1;
                capacityA = fullA;
            }
            capacityA -= plants[i];
        }
        for(int i = plants.length - 1; i >= midRight; i--) {
            if(capacityB < plants[i]) {
                supplyWaterB += 1;
                capacityB = fullB;
            }
            capacityB -= plants[i];
        }
        if(midLeft + 1 != midRight) {
            if(Math.max(capacityA, capacityB) < plants[midLeft + 1]) {
                return supplyWaterA + supplyWaterB + 1;
            }
        }
        return supplyWaterA + supplyWaterB;
    }
}
