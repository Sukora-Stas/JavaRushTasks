package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by Sukora Stas.
 */
class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        Enumeration<String> cardNumbers = validCreditCards.getKeys();

        while (true) {
            System.out.println("Enter number of card");
            String cardNumber = ConsoleHelper.readString();
            System.out.println("Enter pin-code");
            String pinCode = ConsoleHelper.readString();
            if (validCreditCards.containsKey(cardNumber)) {
                if (validCreditCards.getString(cardNumber).equals(pinCode)) {
                    boolean isLogin = false;
                    while (cardNumbers.hasMoreElements()) {
                        String c = cardNumbers.nextElement();
                        String p = validCreditCards.getString(c);
                        if (c.equals(cardNumber) && p.equals(pinCode)) {
                            System.out.println("Welcome dear user!");
                            isLogin = true;
                            break;
                        }
                    }
                    if (isLogin) {
                        break;
                    }
                } else {
                    System.out.println("Incorrect number of card or pin-code");
                }
            }
        }
    }
}