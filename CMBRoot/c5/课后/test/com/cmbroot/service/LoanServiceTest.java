package com.cmbroot.service;

import org.junit.Test;

import java.io.IOException;

public class LoanServiceTest {
    LoanService loanService = new LoanService();

    @Test(expected = NullPointerException.class)
    public void should_throw_exception() throws IOException {
        loanService.calculatePayLoan();
    }

    @Test
    public void should_write_read_data_success() throws IOException {
    String fileName = "story.txt";
    loanService.dataProcess(fileName);
    }
}