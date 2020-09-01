package com.cmbroot;

import com.cmbroot.service.LoanService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LoanService loanService = new LoanService();
        loanService.calculatePayLoan();
    }
}
