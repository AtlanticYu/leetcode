package org.example.designmode.chainresponsibility;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/05/15 17:17
 */
// 请使用Java语言实现如下税率计算:区间(section)
//税率(tax rate)
//1~5000
//0%3%
//5001~8000
//8001~17000
//17001~30000
//30001~4000040081~60800
//6000185000
//85001~
//10%
//20%25%
//30%
//35%
//45%
//e.g.
//税前10000元
//收税金额=50000.0+30000.03+2000*0.1
//要求
//1.使用面向对象设计;
//2.代码规范，变量命名等;
//3.具备可扩展性，当税率配置的区间、税率发生变化时，以下实现必需能够兼容,
public class TaxBracketChain {
    private int start;
    private int end;
    private double taxRate;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public TaxBracketChain getNext() {
        return next;
    }

    private TaxBracketChain next;

    public TaxBracketChain(int start, int end, double taxRate) {
        this.start = start;
        this.end = end;
        this.taxRate = taxRate;
    }

    public void setNext(TaxBracketChain next) {
        this.next = next;
    }

    public double calculateTax(double income) {
        if (getNext() != null) {
            if (income >= getStart()) {
                System.out.println("费率: " + getTaxRate() + "金额: " + (Math.min(income, getEnd()) - getStart() + 1) * getTaxRate());
                return getNext().calculateTax(income) + (Math.min(income, getEnd()) - getStart() + 1) * getTaxRate();
            } else {
                System.out.println("费率: " + getTaxRate() + "金额: " + 0);
                return getNext().calculateTax(income);
            }
        } else {
            if (income >= getStart()) {
                System.out.println("费率: " + getTaxRate() + "金额: " + (Math.min(income, getEnd()) - getStart() + 1) * getTaxRate());
                return (Math.min(income, getEnd()) - getStart() + 1) * getTaxRate();
            } else {
                System.out.println("费率: " + getTaxRate() + "金额: " + 0);
                return 0;
            }
        }
    }
}
