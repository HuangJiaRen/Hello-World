package com.xdf.huangli.strategy.strategyStudy;

import java.math.BigDecimal;

/**
 * <p>
 *  收银员
 * </P>
 *
 * @author huangli
 * @since 2022-10-26 13:12
 */
public class Cashier {
    private Customer customer;

    private BigDecimal cost(BigDecimal oldCost){
        return customer.cost(oldCost);
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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
