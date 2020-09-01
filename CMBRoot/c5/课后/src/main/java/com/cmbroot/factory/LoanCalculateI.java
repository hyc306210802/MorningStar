package com.cmbroot.factory;

import com.cmbroot.entity.Loan;
import com.cmbroot.entity.PayLoan;

import java.math.BigDecimal;
import java.math.RoundingMode;

/***
 * 按照等额本息公式计算还款
 */
public class LoanCalculateI implements Calculate {

    @Override
    public PayLoan calculate(Loan loan, PayLoan payLoan) {
        Float total = loan.getLoanTotal();
        Double rate = loan.getLoanRate();
        Integer year = loan.getYear();

        Integer month = year * 12;
        System.out.println("###########按照等额本息公式计算##############");
        BigDecimal monthRate = this.caculateMonthrate(rate);


        BigDecimal monthPay = this.cacualteMonthPay(monthRate, total, month);

        BigDecimal totalPay = monthPay.multiply(BigDecimal.valueOf(month));

        BigDecimal totalInterest = totalPay.subtract(BigDecimal.valueOf(total));

        BigDecimal restPay = BigDecimal.valueOf(total);

        for (int i = 0; i < month; i++) {
            BigDecimal monthInterest = restPay.multiply(monthRate);
            BigDecimal monthPrincipal = monthPay.subtract(monthInterest);
            restPay = restPay.subtract(monthPrincipal);

            payLoan.addMonthPayList(monthPay);
            payLoan.addMonthPrincipalList(monthPrincipal);
            payLoan.addMonthInterestList(monthInterest);
            payLoan.addRestPrincipalList(restPay);
        }
        payLoan.setTotalPay(totalPay.doubleValue());
        payLoan.setTotalRate(totalInterest.doubleValue());
        return payLoan;
    }

    private BigDecimal caculateMonthrate(Double rate) {
        return BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
    }

    private BigDecimal cacualteMonthPay(BigDecimal monthRate, double total, Integer month) {
        BigDecimal principal = BigDecimal.valueOf(total);
        BigDecimal tempValue = monthRate.add(BigDecimal.valueOf(1)).pow(month);
        BigDecimal monthPay = principal.multiply(monthRate).multiply(tempValue).
                divide(tempValue.subtract(BigDecimal.valueOf(1)), 10, RoundingMode.HALF_UP);
        return monthPay;
    }
}
