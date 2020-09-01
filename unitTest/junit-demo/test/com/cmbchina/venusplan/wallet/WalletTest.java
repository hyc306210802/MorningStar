package com.cmbchina.venusplan.wallet;

import com.cmbchina.venusplan.wallet.exception.WalletException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WalletTest {
    @Test
    public void should_get_max_paper_money() {
        List<Integer> paperMoney = Arrays.asList(1,5,4,99990, 45);
        Wallet wallet = new Wallet(paperMoney);

        int maxPaperMoney = wallet.getMaxPaperMoney();
        Assert.assertEquals(99990, maxPaperMoney);
    }

    @Test(expected = WalletException.class)
    public void should_throw_exception_when_paper_moneys_is_null() {
        Wallet wallet = new Wallet(null);

        int max = wallet.getMaxPaperMoney();
    }


    @Test(expected = RuntimeException.class)
    public void should_get_max_money_when_wallet_is_empty() {
        Wallet wallet = new Wallet(null);
        int maxPaperMoney = wallet.getMaxPaperMoney();
    }


}