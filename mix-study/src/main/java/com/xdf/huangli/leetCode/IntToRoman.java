package com.xdf.huangli.leetCode;

/**
 * @author huangli
 * @version 1.0
 * @description
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-01-20 18:03
 */
public class IntToRoman {
    public static void main(String[] args) {
        int num = 900;
        String roman = intToRoman(num);
        System.out.println(roman);
    }

    public static String intToRoman(int num) {
        StringBuffer numSb = null;
        if(num < 1 || num > 3999){
            return "-1";
        }

        if(num >= 1 && num <= 10){
            return getTenNum(num, numSb);
        }

        if(num > 10 && num <= 50){
            return getFiftyNum(num, numSb);
        }

        if(num <= 100 && num > 50){
            return getHNum(num, numSb);
        }

        if(num > 100 && num <= 500){
            return getFHNum(num, numSb);
        }

        if(num > 500 && num <= 1000){
            return getForNum(num, numSb);
        }

        if(num > 1000 && num <= 3999){
            return getBNum(num, numSb);
        }

        return numSb.toString();
    }

    private static String getBNum(int num, StringBuffer numSb) {
        int snum = num / 1000;
        numSb = numSb == null ? new StringBuffer() : numSb;
        for(int i=0; i<snum; i++){
            numSb.append("M");
        }

        int qnum = num % 1000;

        return getRes(qnum, numSb);
    }

    private static String getRes(int num, StringBuffer numSb) {
        numSb = numSb == null ? new StringBuffer() : numSb;
        if(num >= 1 && num <= 10){
            return getTenNum(num, numSb);
        }

        if(num > 10 && num <= 50){
            return getFiftyNum(num, numSb);
        }

        if(num <= 100 && num > 50){
            return getHNum(num, numSb);
        }

        if(num > 100 && num <= 500){
            return getFHNum(num, numSb);
        }

        if(num > 500 && num <= 1000){
            return getForNum(num, numSb);
        }

        return numSb.toString();
    }

    private static String getForNum(int num, StringBuffer numSb) {
        if(num == 1000){
            return "M";
        }

        numSb = numSb == null ? new StringBuffer() : numSb;

        if(num > 500 && num < 900){
            int snum = num / 100;
            numSb.append("D");
            for(int i = 5; i < snum; i++){
                numSb.append("C");
            }

            int ynum = num % 100;
            return getYTenNum(ynum, numSb);
        }

        if(num >= 900 && num < 1000){
            numSb.append("CM");
            int ynum = num % 100;
            return getYTenNum(ynum, numSb);
        }

        return null;
    }

    private static String getFHNum(int num, StringBuffer numSb) {
        numSb = numSb == null ? new StringBuffer() : numSb;

        if(num == 500){
            numSb.append("D");
            return numSb.toString();
        }if(num > 100 && num <= 199){
            numSb.append("C");
            int ynum = num % 100;
            return getYTenNum(ynum, numSb);
        }if(num >= 200 && num <= 399){
            int snum = num / 100;
            for(int i=0; i<snum; i++){
                numSb.append("C");
            }
            int ynum = num % 100;
            return getYTenNum(ynum, numSb);
        }else{
            int snum = num / 100;

            for(int i = 0; i < 5 - snum; i++){
                numSb.append("C");
            }
            numSb.append("D");

            int ynum = num % 100;
            return getYTenNum(ynum, numSb);
        }

    }

    private static String getYTenNum(int num, StringBuffer numSb) {
        if(num >= 1 && num <= 10){
            return getTenNum(num, numSb);
        }

        if(num > 10 && num <= 50){
            return getFiftyNum(num, numSb);
        }

        if(num <= 100 && num > 50){
            return getHNum(num, numSb);
        }

        return numSb.toString();
    }

    private static String getHNum(int num, StringBuffer numSb) {
        numSb = numSb == null ? new StringBuffer() : numSb;
        if(num == 100){
            numSb.append("C");
            return numSb.toString();
        }

        if(num > 90){
            numSb.append("XC");

            int ynum = num % 10;
            getTenNum(ynum, numSb);

            return numSb.toString();
        } if(num == 90){
            numSb.append("XC");
            return numSb.toString();
        }else{
            int snum = num / 10;

            numSb.append("L");
            for(int i = 5; i < snum; i++){
                numSb.append("X");
            }

            int ynum = num % 10;
            getTenNum(ynum, numSb);

            return numSb.toString();
        }

    }

    private static String getFiftyNum(int num, StringBuffer numSb) {
        numSb = numSb == null ? new StringBuffer() : numSb;
        if(num == 50){
            numSb.append("L");
            return numSb.toString();
        }

        if(num < 40 && num > 10){
            int snum = num / 10;
            for(int i = 0; i < snum; i++){
                numSb.append("X");
            }
        }

        if(num >= 40){
            numSb.append("XL");
        }

        int ynum = num % 10;
        getTenNum(ynum, numSb);

        return numSb.toString();
    }

    private static String getTenNum(int num, StringBuffer numSb) {
        numSb = numSb == null ? new StringBuffer() : numSb;
        if(num >= 1 && num <= 3){
            for(int i = 1; i <= num; i++){
                numSb.append("I");
            }
            return numSb.toString();
        }

        if(num == 4){
            numSb.append("IV");
            return numSb.toString();
        }

        if(num == 5){
            numSb.append("V");
            return numSb.toString();
        }

        if(num >= 6  && num <= 8){
            numSb.append("V");
            for(int i = 6; i <= num; i++){
                numSb.append("I");
            }
            return numSb.toString();
        }

        if(num == 9){
            numSb.append("IX");
            return numSb.toString();
        }

        if(num == 10){
            numSb.append("X");
            return numSb.toString();
        }

        return null;
    }


}
