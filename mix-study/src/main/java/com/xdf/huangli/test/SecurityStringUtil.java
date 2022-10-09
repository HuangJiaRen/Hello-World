package com.xdf.huangli.test;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-08-23 11:37
 */
public class SecurityStringUtil {
    private static String defaultCarrier = "智运承运商";
    /**
     * 姓名脱敏加工方法
     * @param oriStr
     * @return
     */
    public static String nameStr(String oriStr){
        if(defaultCarrier.equals(oriStr)){
            return oriStr;
        }
        String replace = null;
        if(oriStr.length() == 2){
            replace = oriStr.replace(oriStr.charAt(oriStr.length() - 1) + "", "*");
        }

        if(oriStr.length() > 2){
            char endStr = oriStr.charAt(oriStr.length() - 1);
            char startStr = oriStr.charAt(0);
            replace = startStr + "*" + endStr;
        }
        return replace;
    }


    /**
     * 银行卡号脱敏加工方法
     * @param oriStr
     * @return
     */
    public static String bankCarStr(String oriStr){
        String replace = null;
        if(StringUtil.isNotEmpty(oriStr) && oriStr.length() > 10){
            //前六位
            String substring = oriStr.substring(0, 6);
            //后四位
            String s = oriStr.substring(oriStr.length() - 4);
            int mid = oriStr.length() - 10;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < mid; i++) {
                builder.append("*");
            }
            replace = substring + builder.toString() + s;
        }
        return replace;
    }

    /**
     * 电子邮件脱敏加工方法
     * @param oriStr
     * @return
     */
    public static String mailStr(String oriStr){
        String replace = null;
        if(StringUtil.isNotEmpty(oriStr)){
            String[] split = oriStr.split("@");
            String string = split[0].toString();
            int length = string.length();
            if(length > 1){
                int ai = length - 1;
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < ai; i++) {
                    builder.append("*");
                }
                replace = oriStr.charAt(0) + builder.toString() + "@" + split[1];
            }else {
                return oriStr;
            }
        }
        return replace;
    }

    /**
     * 固定电话敏加工方法
     * @param oriStr
     * @return
     */
    public static String telPhoneStr(String oriStr){
        String replace = null;
        if(StringUtil.isNotEmpty(oriStr)){
            String[] split = oriStr.split("-");
            //电话区号后的数字
            String string = split[1].toString();
            //截取后两位
            String substring = string.substring(string.length() - 2, string.length());
            int length = string.length();
            if(length >= 2){
                int ai = length - 2;
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < ai; i++) {
                    builder.append("*");
                }
                replace = split[0] + "-" + builder.toString() + substring;
            }
        }
        return replace;
    }

    public static void main(String[] args) {
        String sb = "5345345345465535";
        String substring = sb.substring(0, 6);
        String s = sb.substring(sb.length() - 4);
//        String bankCarStr = SecurityStringUtil.bankCarStr(sb);
        System.out.println(substring);
        System.out.println(s);
    }
}
