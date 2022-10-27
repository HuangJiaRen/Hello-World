package com.xdf.huangli.strategy.strategyStudy;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-26 16:28
 */
public class StrategyTest {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        CommonCustomer commonCustomer = new CommonCustomer();
        SuperCustomer superCustomer = new SuperCustomer();
        VIPCustomer vipCustomer = new VIPCustomer();
        BigDecimal bigDecimal = new BigDecimal(7.2);
        cashier.setCustomer(commonCustomer);
        System.out.println(cashier.cost(bigDecimal));

        cashier.setCustomer(vipCustomer);
        System.out.println(cashier.cost(bigDecimal));

        cashier.setCustomer(superCustomer);
        System.out.println(cashier.cost(bigDecimal));
    }
}
