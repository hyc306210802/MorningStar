package com.cmbroot.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PayLoan {
    /***
     * 月还款总额
     */
    private List<BigDecimal> monthPayList = new ArrayList<>();
    /***
     *月供本金
     */
    private List<BigDecimal> monthPrincipal = new ArrayList<>();
    /***
     * 月供利息
     */
    private List<BigDecimal> monthInterest = new ArrayList<>();
    /***
     * 剩余本金
     */
    private List<BigDecimal> restPrincipal = new ArrayList<>();
    /***
     * 总还款额
     */
    private Double totalPay;
    /***
     * 总还款利润
     */
    private Double totalRate;


    public List<BigDecimal> getMonthPay() {
        return monthPayList;
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public void setRestPrincipal(List<BigDecimal> restPrincipal) {
        this.restPrincipal = restPrincipal;
    }

    public void setMonthInterest(List<BigDecimal> monthRate) {
        this.monthInterest = monthRate;
    }

    public void setMonthPrincipal(List<BigDecimal> monthPrincipal) {
        this.monthPrincipal = monthPrincipal;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalRate(Double totalRate) {
        this.totalRate = totalRate;
    }

    public void setMonthPay(List<BigDecimal> monthPay) {
        this.monthPayList = monthPay;
    }

    public void outputPayloan(Loan loan) {
        for (int i = 0; i <= this.monthPayList.size() - 1; i++) {
            System.out.println(String.format("第%d期还款%.2f，月供本金%.2f，月供利息%.2f，剩余本金%.2f",
                    i + 1,
                    this.monthPayList.get(i).doubleValue(),
                    this.monthPrincipal.get(i).doubleValue(),
                    this.monthInterest.get(i).doubleValue(),
                    this.restPrincipal.get(i).doubleValue()));

        }
        System.out.println(String.format("尊敬的客户您好，您的贷款总金额为%.2f元，总还款额为%.2f元，累计还款利息为%.2f元",
                loan.getLoanTotal(), this.getTotalPay().doubleValue(), this.totalRate.doubleValue()));

    }

    public void addMonthPayList(BigDecimal monthPay) {
        this.monthPayList.add(monthPay);
    }

    public void addMonthPrincipalList(BigDecimal monthPrincipal) {
        this.monthPrincipal.add(monthPrincipal);
    }

    public void addMonthInterestList(BigDecimal monthInterest) {
        this.monthInterest.add(monthInterest);
    }

    public void addRestPrincipalList(BigDecimal restPay) {
        this.restPrincipal.add(restPay);
    }
}
