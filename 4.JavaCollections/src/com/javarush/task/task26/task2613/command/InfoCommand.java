package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;

/**
 * Created by Sukora Stas.
 */
class InfoCommand implements Command {
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
