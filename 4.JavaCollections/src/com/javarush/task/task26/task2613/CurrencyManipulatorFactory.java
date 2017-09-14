package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sukora Stas.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> currency = new HashMap<>();

    private CurrencyManipulatorFactory() {}

//    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
//        if (!currency.containsKey(currencyCode))
//            currency.put(currencyCode, new CurrencyManipulator(currencyCode));
//
//        return currency.get(currencyCode);
//    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        for (Map.Entry<String, CurrencyManipulator> pair : currency.entrySet()) {
            if (pair.getKey().equals(currencyCode)) {
                return pair.getValue();
            }
        }
        CurrencyManipulator newCM = new CurrencyManipulator(currencyCode);
        currency.put(currencyCode, newCM);
        return newCM;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return currency.values();
    }

}
