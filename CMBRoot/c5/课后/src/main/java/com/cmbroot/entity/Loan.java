package com.cmbroot.entity;

public class Loan {
    /***
     * 贷款总额
     */
    private Float loanTotal;
    /***
     * 贷款方式
     */
    private String loanMode;
    /***
     * 贷款利率
     */
    private Double loanRate;
    /***
     * 贷款年限
     */
    private Integer year;

    private String payMethod;

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Float getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(Float loanTotal) {
        this.loanTotal = loanTotal;
    }

    public String getLoanMode() {
        return loanMode;
    }

    public void setLoanMode(String loan_mode) {
        this.loanMode = loan_mode;
    }

    public Double getLoanRate() {
        return loanRate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setLoanRate(Double loan_rate) {
        this.loanRate = loan_rate;
    }


}
