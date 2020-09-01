package com.cmbroot.additional;

/***
 * 定义还款利率的折扣信息
 */
public class Discount {
    private static final Double DEFAULT_RATE = 4.99;

    private Double discountRate;

    public Boolean isDefault() {
        return false;
    }
}
