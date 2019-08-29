package com.xdf.huangli.test;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-08-28 16:48
 */
public class StringTest {
    public static void main(String[] args) {

        String str = "<wn>1</wn>";
        String str4 = "<nn></nn>";
        String str2 = "<wn>1</wn><nn>2</nn>";
        String str3 = "<nn></nn><wn>2</wn>";

        System.out.println(anaString(str2));
    }


    public static String anaString(String string){
        String res = "";

        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) >= 48 && string.charAt(i) <= 57){
                res += string.charAt(i);
            }
        }

        return res;
    }
}
