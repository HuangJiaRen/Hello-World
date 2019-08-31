package com.xdf.huangli.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @uthor huangli
 * @description
 * @date 2019/8/28 21:13
 *
 *
 */
public class StringAnaly {
    public static void main(String[] args) {
//        String str = "<nn></nn>dfsdfdfs<nn></nn><mn></mn>fdsfrtty<mn></mn>fdsf4fdsf<nn></nn>fds45";
//        String str = "dfsdfdfs<nn>1</nn><wn>2</wn>fdsfrtty<wn></wn>fdsf4fdsf<nn></nn>fds45<nn></nn>";
        String str = "<indent>霍测试复合题，小问有空的有不空的<br />Alfred Nobel was born in Stockholm, Sweden," +
                "on October 21, 1853 but moved to Russia with his parents in 1842, where his father " +
                "made a strong position for himself in the engineering industry, but unfortunately went " +
                "bankrupt few years later. Nobel had never been to school or university," +
                " but had studied <wn>1</wn> (private) and became a skillful chemist and excellent " +
                "linguist, <wn>2</wn> <span style=\"text-indent: 2em;\">(speak) Swedish, Russian, " +
                "German, French and English. Unlike his father, he had better luck in business " +
                "and showed more <wn>3</wn></span> <span style=\"text-indent: 2em;\"> (finance) sense. </span></indent>";
//        String str = "<mn></mn><mn></mn>dfsdfdfs<nn></nn><mn></mn>fdsfrtty<mn></mn>fdsf4fdsf<nn></nn>fds45";
//        String str = "<wn></wn>dfsdfdfs<wn></wn><wn></wn>fdsfrtty<wn></wn>fdsf4fdsf<wn></wn>fds45<wn></wn>";
//        String str = "<nn></nn><nn></nn>dfsdfdfs<nn></nn><nn></nn>fdsfrtty<nn></nn>fdsf4fdsf<nn></nn>fds45<nn></nn><nn></nn>";

        //一.解析<wn标签，增加切个符号#@#
        String[] arrStr = str.split("<wn");
        StringBuilder sb = new StringBuilder();

        if(null != arrStr && arrStr.length > 0){
            //是否以<wn开头
            boolean startBool = null == arrStr[0] || "".equals(arrStr[0]);

            //1.以<wn开头时，补全标签<wn
            if(startBool){
                sb.append("#@#<wn");
            }

            for (int i = 0; i < arrStr.length; i++) {
//                System.out.println(arrStr[i]);
                //2.以<wn开头时，步骤1已经拼接完头部，所以从第三个元素判断补全标签
                if(startBool && i > 1 && arrStr[i].contains("</wn>")){
                    sb.append("#@#<wn");
                }

                //3.不是以<wn开头时，依次判断元素补全标签
                if(startBool == false && arrStr[i].contains("</wn>")){
                    sb.append("#@#<wn");
                }

                sb.append(arrStr[i]);
            }

            System.out.println(sb.toString());
            System.out.println("------wn1--------");

            String wnString = sb.toString();
            //二.解析<nn标签，增加切个符号#@#
            String[] nnArrStr = wnString.split("<nn");
            sb = new StringBuilder();

            if(null != nnArrStr && nnArrStr.length > 0){
                //是否以<nn开头
                boolean nnStartBool = null == nnArrStr[0] || "".equals(nnArrStr[0]);

                //4.以<nn开头时，补全标签<nn
                if(nnStartBool){
                    sb.append("#@#<nn");
                }

                for (int i = 0; i < nnArrStr.length; i++) {
//                    System.out.println(nnArrStr[i]);
                    //5.以<nn开头时，步骤1已经拼接完头部，所以从第三个元素判断补全标签
                    if(nnStartBool && i > 1 && nnArrStr[i].contains("</nn>")){
                        sb.append("#@#<nn");
                    }

                    //6.不是以<nn开头时，依次判断元素补全标签
                    if(nnStartBool == false && nnArrStr[i].contains("</nn>")){
                        sb.append("#@#<nn");
                    }

                    sb.append(nnArrStr[i]);
                }

                System.out.println(sb.toString());
                System.out.println("------nn1--------");

                String wnStr = sb.toString();
                //三.解析以</wn>结尾，增加切个符号#@#
                String[] wnArr = wnStr.split("</wn>");
                sb = new StringBuilder();
                for (int i = 0; i < wnArr.length; i++) {
//                    System.out.println(wnArr[i]);
                    if(wnArr[i].contains("<wn") && StringUtil.isNotEmpty(wnArr[i])){
                        sb.append(wnArr[i]).append("</wn>#@#");
                    }else {
                        sb.append(wnArr[i]);
                    }
                }

                System.out.println(sb.toString());
                System.out.println("------wn2------");


                String nnStr = sb.toString();
                //四.解析以</nn>结尾，增加切个符号#@#
                String[] nnArr = nnStr.split("</nn>");
                sb = new StringBuilder();
                for (int i = 0; i < nnArr.length; i++) {
                    System.out.println(nnArr[i]);
                    if(nnArr[i].contains("<nn") && StringUtil.isNotEmpty(nnArr[i])){
                        sb.append(nnArr[i]).append("</nn>#@#");
                    }else {
                        sb.append(nnArr[i]);
                    }
                }

                System.out.println(sb.toString());
                System.out.println("-----nn2------");

                if(StringUtil.isNotEmpty(sb.toString())){
                    //五.根据#@#切割字符串
                    String[] strArr = sb.toString().split("#@#");
                    List<Map<String,String>> strList = new ArrayList<>();
                    Map<String, String> strMap = null;
                    int i = 1;
                    for (String s : strArr) {
                        if(StringUtil.isNotEmpty(s)){
                            strMap = new HashMap<>();
                            if(s.contains("<wn") || s.contains("<nn")){
                                strMap.put("isInput", "true");
                                strMap.put("content", "<input readOnly id=\"inputBox"+ i++ +"\" className={styles.inputBox} type=\"text\" value=\"\" />");
                            } else {
                                strMap.put("isInput", "false");
                                strMap.put("content", "\"" + s + "\"");
                            }
                            strList.add(strMap);
                        }
                    }

                    System.out.println(strList.toString());

                }

            }

        }
    }
}
