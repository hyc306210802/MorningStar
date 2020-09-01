package com.cmbroot.factory;

import com.cmbroot.entity.Loan;
import com.cmbroot.entity.PayLoan;

/***
 * 计算还款额接口
 */
public interface Calculate {
    PayLoan calculate(Loan loan, PayLoan payLoan);
}
