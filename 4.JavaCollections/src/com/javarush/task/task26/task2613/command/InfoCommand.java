package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Sukora Stas.
 */
class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"info_en", Locale.ENGLISH);


    @Override
    public void execute() {
        Collection<CurrencyManipulator> bills = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean hasMoney = false;

        for (CurrencyManipulator bill : bills) {
            if (bill.hasMoney()) {
                hasMoney = true;
                System.out.println(bill.getCurrencyCode() + " - " + bill.getTotalAmount());
            }
        }

        if (!hasMoney) {
            System.out.println("No money available.");
        }
    }
}
