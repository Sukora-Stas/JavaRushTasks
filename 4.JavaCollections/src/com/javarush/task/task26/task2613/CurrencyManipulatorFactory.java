package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sukora Stas.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator current = null;
        return current;
    }


}
