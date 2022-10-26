package com.xdf.huangli.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-21 09:17
 */
public class BigDecimalFuncTest {
    /**
     * 环保对比单位：绕地球几圈；跨度为0.5圈
     */
    private static final BigDecimal a = new BigDecimal(0.5);

    public static void main(String[] args) {
        //TODO 运输里程
        BigDecimal decimal = new BigDecimal(55000.567);

        BigDecimal divide = decimal.divide(new BigDecimal(40000), 2, BigDecimal.ROUND_HALF_DOWN);
        // 整数部分
        BigDecimal integerPart = divide.setScale(0, RoundingMode.DOWN);
        // 小数部分
//        BigDecimal fractionalPart = divide.subtract(integerPart);
        BigDecimal fractionalPart = new BigDecimal(0.65D);

        System.out.println(integerPart);
        System.out.println(fractionalPart + "");

        if(fractionalPart.compareTo(a) < 0){
            System.out.println(integerPart);
        }

        if(fractionalPart.compareTo(a) > 0){
            System.out.println(integerPart.add(a));
        }


//        BigDecimal decimal = new BigDecimal(55000);

        System.out.println(decimal.doubleValue());

//        BigDecimal multiply = decimal.multiply(new BigDecimal(0.35)).multiply(new BigDecimal(0.717));
//        System.out.println(multiply.setScale(2));

        BigDecimal v = a.multiply(new BigDecimal(0.35)).multiply(new BigDecimal(0.717)).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(v);
    }
}
