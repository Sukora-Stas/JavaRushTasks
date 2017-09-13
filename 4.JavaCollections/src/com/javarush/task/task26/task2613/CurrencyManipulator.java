package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sukora Stas.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.denominations = new HashMap<>();
        this.currencyCode = currencyCode;
    }


    public String getCurrencyCode() {
        return currencyCode;
    }
}
