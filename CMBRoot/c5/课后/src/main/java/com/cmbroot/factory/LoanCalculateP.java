package com.cmbroot.factory;

import com.cmbroot.entity.Loan;
import com.cmbroot.entity.PayLoan;

import java.math.BigDecimal;
import java.math.RoundingMode;

/***
 * 按照等额本金公式计算还款
 */

public class LoanCalculateP implements Calculate {
    @Override
    public PayLoan calculate(Loan loan, PayLoan payLoan) {
        Float total = loan.getLoanTotal();
        Double rate = loan.getLoanRate();
        Integer year = loan.getYear();
        System.out.println("############按照等额本金公式计算#############");
        BigDecimal monthRate = BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
        Integer month = year * 12;
        BigDecimal monthPrincipal = BigDecimal.valueOf(total).divide(BigDecimal.valueOf(month), 10, RoundingMode.HALF_UP);
        BigDecimal restPrincipal = BigDecimal.valueOf(total);
        BigDecimal totalPay = BigDecimal.valueOf(0);
        BigDecimal totalInterest = BigDecimal.valueOf(0);

        for (int i = 0; i < month; i++) {
            BigDecimal monthInterest = restPrincipal.multiply(monthRate);

            BigDecimal monthPay = monthInterest.add(monthPrincipal);

            totalPay = totalPay.add(monthPay);
            totalInterest = totalInterest.add(monthInterest);
            restPrincipal = restPrincipal.subtract(monthPrincipal);

            payLoan.addMonthPayList(monthPay);
            payLoan.addMonthPrincipalList(monthPrincipal);
            payLoan.addRestPrincipalList(restPrincipal);
            payLoan.addMonthInterestList(monthInterest);
        }
        payLoan.setTotalPay(totalPay.doubleValue());
        payLoan.setTotalRate(totalInterest.doubleValue());
        return payLoan;
    }
}
