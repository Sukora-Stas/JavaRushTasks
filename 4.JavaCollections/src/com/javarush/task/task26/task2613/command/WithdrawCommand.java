package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ConcurrentModificationException;
import java.util.Map;

/**
 * Created by Sukora Stas.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        boolean flag = true;
        while (flag) {
            System.out.println("Enter amount of money for withdraw");
            String temp = ConsoleHelper.readString();
            if (temp.matches("\\d+")) {
                int amount = Integer.valueOf(temp);
                if (cm.isAmountAvailable(amount)) {
                    Map<Integer, Integer> wa;
                    try
                    {
                        wa = cm.withdrawAmount(amount);
                        for (Map.Entry<Integer, Integer> pair : wa.entrySet()) {
                            System.out.println("\t" + pair.getKey() + " - " + pair.getValue());
                        }
                    }
                    catch (NotEnoughMoneyException e)
                    {
                        System.out.println("Not enough money");
                    }
                    catch (ConcurrentModificationException e) {}
                    flag = false;
                }
            } else {
                System.out.println("Incorrect data");
            }
        }
    }
}
