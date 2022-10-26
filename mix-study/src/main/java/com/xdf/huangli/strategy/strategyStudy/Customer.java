package com.xdf.huangli.strategy.strategyStudy;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-26 13:06
 */
public interface Customer {
    /**
     * 计算折扣后的花费
     */
    public BigDecimal cost(BigDecimal oldCost);
}
