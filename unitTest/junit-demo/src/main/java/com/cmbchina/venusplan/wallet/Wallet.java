package com.cmbchina.venusplan.wallet;

import com.cmbchina.venusplan.wallet.exception.WalletException;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Wallet {

    private final List<Integer> paperMoneys;

    public Wallet(List<Integer> paperMoneys) {
        this.paperMoneys = paperMoneys;
    }

    public int getMax() {
        if (paperMoneys == null || paperMoneys.size() == 0) {
            throw new WalletException("Wallet is empty!");
        }
        int max = paperMoneys.get(0);
        for (int i = 1; i < paperMoneys.size(); i++) {
            if (max < paperMoneys.get(i)) {
                max = paperMoneys.get(i);
            }
        }
        return max;
    }

    public int getMaxPaperMoney() {
        return Optional.ofNullable(paperMoneys)
                .filter(integers -> !integers.isEmpty())
                .map(List::stream)
                .map(integerStream -> integerStream.mapToInt(Integer::intValue))
                .map(IntStream::max)
                .map(OptionalInt::getAsInt)
                .orElseThrow(() -> new WalletException("wallet is empty"));
    }
}

