package com.xdf.huangli.strategy.strategyStudy;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-26 13:10
 */
public class SuperCustomer implements Customer {
    @Override
    public BigDecimal cost(BigDecimal oldCost) {
        return oldCost.multiply(new BigDecimal("0.6"));
    }
}
