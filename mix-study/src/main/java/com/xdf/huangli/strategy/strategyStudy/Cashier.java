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

    BigDecimal cost(BigDecimal oldCost){
        return customer.cost(oldCost);
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
