package com.xdf.huangli.leetCode;


/**
 * @author huangli
 * @version 1.0
 * @description JAVA 两个大字符串数字相加
 * 整体步骤：
 *
 * 将两个字符串长度补全，补成一致长度，长度短的左边补0；
 * 定义一个新的整形数组，长度为字符串的长度+1，因为结果的长度可能超出原字符串的长度（整形数组值默认为0）；
 * 倒叙循环相加，将结果%10的余位放在低位，结果的/10的结果放在高位；最终合并结果返回。
 * @date 2021-03-17 22:31
 */
public class AddStringNumTest {
    public static void main(String[] args) {
        System.out.println(23/10);
        System.out.println(23%10);
        String a = "1232323232";
        String b = "  98323232";
        String numberPlus = bigNumberPlus(a, b);
        System.out.println(numberPlus);
    }

    private static String bigNumberPlus(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if(lenA > lenB){
            b = flushLeft('0', lenA, b);
        }else {
            a = flushLeft('0', lenB, a);
        }

        int[] sum = new int[a.length() + 1];

        for(int i = a.length()-1; i >= 0; i --){
            int ai = Integer.parseInt(a.charAt(i)+"");
            int bi = Integer.parseInt(b.charAt(i)+"");
            int ci = sum[i + 1];

            int t = ai + bi + ci;
            sum[i + 1] = t%10;
            sum[i] = t / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            if(i == 0 && sum[i] == 0){
                continue;
            }else {
                sb.append(sum[i]);
            }
        }

        return sb.toString();
    }


    /**
     * c 要填充的字符
     * length 填充后字符串的总长度
     *  content 要格式化的字符串
     *  格式化字符串，左对齐
     * @param c
     * @param length
     * @param content
     * @return
     */
    public static String flushLeft(char c, long length, String content){
        String str = "";
        String cs = "";
        if (content.length() > length){
            str = content;
        }else{
            for (int i = 0; i < length - content.length(); i ++){
                cs = c + cs;
            }
        }
        str = cs + content;
        return str;
    }
}
