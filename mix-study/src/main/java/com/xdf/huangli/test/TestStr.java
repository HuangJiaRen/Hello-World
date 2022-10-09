package com.xdf.huangli.test;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-08-23 11:23
 */
public class TestStr {
    public static void main(String[] args) {
//        String a = "张三哈";
//        if(a.length() == 2){
//            String replace = SecurityStringUtil.nameStr(a);
//            System.out.println(replace);
//        }
//
//        if(a.length() > 2){
//            String replace = SecurityStringUtil.nameStr(a);
//            System.out.println(replace);
//        }
//        System.out.println(a.length());
//
//
//        String sb = "534534 534546 5535";
//        String substring = sb.substring(0, 6);
//        String s = sb.substring(sb.length() - 4);
//        String bankCarStr = SecurityStringUtil.bankCarStr(sb);
//        System.out.println(substring);
//        System.out.println(s);
//        System.out.println(bankCarStr);
//
//        String ae = "12@qq.com";
//        String mailStr = SecurityStringUtil.mailStr(ae);
//        System.out.println(mailStr);

        String telPhone = "022-132";
        String phoneStr = SecurityStringUtil.telPhoneStr(telPhone);
        System.out.println(phoneStr);
    }
}
