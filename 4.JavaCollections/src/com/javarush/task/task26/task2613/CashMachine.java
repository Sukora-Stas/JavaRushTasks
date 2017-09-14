package com.javarush.task.task26.task2613;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Sukora Stas.
 */
public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        CurrencyManipulator currencyManipulator;

        String code = ConsoleHelper.askCurrencyCode();
        String[] strs = ConsoleHelper.getValidTwoDigits(code);
        currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        currencyManipulator.addAmount(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
        System.out.println(currencyManipulator.getTotalAmount());
    }
}
