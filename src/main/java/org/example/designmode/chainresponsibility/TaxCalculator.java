package org.example.designmode.chainresponsibility;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/05/15 16:42
 */
public class TaxCalculator {
    private TaxBracketChain taxBracketChain;

    public TaxCalculator() {
        this.taxBracketChain = createTaxBracketChain();
    }

    private TaxBracketChain createTaxBracketChain() {
        TaxBracketChain firstBracket = new TaxBracketChain(1, 5000, 0.0);
        TaxBracketChain secondBracket = new TaxBracketChain(5001, 8000, 0.03);
        TaxBracketChain thirdBracket = new TaxBracketChain(8001, 17000, 0.1);
        TaxBracketChain fourthBracket = new TaxBracketChain(17001, 30000, 0.2);
        TaxBracketChain fifthBracket = new TaxBracketChain(30001, 40000, 0.25);
        TaxBracketChain sixthBracket = new TaxBracketChain(40001, 60000, 0.3);
        TaxBracketChain seventhBracket = new TaxBracketChain(60001, 85000, 0.35);
        TaxBracketChain lastBracket = new TaxBracketChain(85001, Integer.MAX_VALUE, 0.45);

        // 设置责任链的顺序
        firstBracket.setNext(secondBracket);
        secondBracket.setNext(thirdBracket);
        thirdBracket.setNext(fourthBracket);
        fourthBracket.setNext(fifthBracket);
        fifthBracket.setNext(sixthBracket);
        sixthBracket.setNext(seventhBracket);
        seventhBracket.setNext(lastBracket);

        return firstBracket;
    }

    public double calculateTax(double income) {
        return taxBracketChain.calculateTax(income);
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
        // 3000 * 0.03 + 9000 * 0.1 + 13000 * 0.2 + 10000 * 0.25 + 20000 * 0.3 + 25000 * 0.35 + 5000 * 0.45
        double income = 90000.0;
        double taxAmount = calculator.calculateTax(income);
        System.out.println("税前" + income + "元");
        System.out.println("收税金额：" + taxAmount);
    }
}