package org.example.twentyfour.march;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/11 20:40
 */
// 2129
// 输入：title = "capiTalIze tHe titLe"
//输出："Capitalize The Title"
public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        String[] split = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String sp : split) {
            if(sp.length() <= 2) {
                sb.append(sp.toLowerCase());
                sb.append(" ");
                continue;
            }
            sp = sp.toLowerCase();
            sp = sp.substring(0, 1).toUpperCase() + sp.substring(1, sp.length());
            sb.append(sp);
            sb.append(" ");
        }
        String result = sb.toString();

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String title = "capiTalIze tHe titLe";
        String[] split = title.split(" ");
        String c = "A";
        c.toUpperCase();
        System.out.println("aaa");
    }
}
