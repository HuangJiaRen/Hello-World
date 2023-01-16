package com.xdf.huangli.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xdf.huangli.util.CompareUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TreeMap;

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


        TreeMap<Object, Object> treeMap = new TreeMap<>();

//        Student student = new Student();
//        System.out.println(student.getName());
//        System.out.println(ObjectUtil.isNull(student));
//        System.out.println(ObjectUtil.isEmpty(student));

        LocalDateTime parse = LocalDateTime.parse("2022-11-27 12:39:22", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime parse2 = LocalDateTime.parse("2022-11-28 12:39:22", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse.compareTo(parse2));

        if (parse.compareTo(parse2) < 0) {
            System.out.println("运单生成时间早于订单生成时间，无法转入！");
        }
    }
}
