package com.xdf.huangli.test;

import com.xdf.huangli.util.CompareUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

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

//        String telPhone = "022-132";
//        String phoneStr = SecurityStringUtil.telPhoneStr(telPhone);
//        System.out.println(phoneStr);
//        Calendar date = Calendar.getInstance();
//        int i = date.get(Calendar.MONTH);

//        Calendar date = Calendar.getInstance();
//        int i1 = date.get(Calendar.YEAR);
//        System.out.println(i1);


        String[] month = new String[12];
        LocalDate today = LocalDate.now();
        for(int i = 1;i <= 12; i++){
            LocalDate localDate = today.minusMonths(i);
//            String ss = localDate.toString().substring(0,7).replace("-", "");
            String ss = localDate.toString().substring(0,7);
            month[12-i] = ss;
        }
        for(int i = 0;i < month.length;i++) {
            System.out.println(month[i]);
        }


    }
}
