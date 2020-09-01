package com.cmbroot.additional;

import com.cmbroot.entity.Loan;
import com.cmbroot.entity.PayLoan;
import com.cmbroot.factory.LoanCalculateI;
import com.cmbroot.factory.LoanCalculateP;

/***
 * 选择还款方式与策略，共有等额本息与等额本金两种
 */
public class LoanStrategy {
    private String strategyMethod;
    private PayLoan payLoan;
    private Loan loan;
    public LoanStrategy(Loan loan,PayLoan payLoan) {
        this.strategyMethod = loan.getPayMethod();
        this.loan = loan;
        this.payLoan = payLoan;
    }

    public PayLoan getLoanCaculator() {
        if (this.strategyMethod.equals("P")) {
            LoanCalculateP loanCalculateP = new LoanCalculateP();
            return loanCalculateP.calculate(loan,payLoan);
        } else if (this.strategyMethod.equals("I")) {
            LoanCalculateI loanCalculateI = new LoanCalculateI();
            return loanCalculateI.calculate(loan,payLoan);
        } else {
            return null;
        }
    }
}
