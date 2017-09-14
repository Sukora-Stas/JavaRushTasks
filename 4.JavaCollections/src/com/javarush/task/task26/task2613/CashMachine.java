package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Sukora Stas.
 */
public class CashMachine {
    public static void main(String[] args) throws InterruptOperationException {




        try {
            Locale.setDefault(Locale.ENGLISH);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);

            } while (operation != Operation.EXIT);

        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Operation was terminated! Bye...");
        }
    }
}
