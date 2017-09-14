package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Sukora Stas.
 */
public class CashMachine {
    public static final String RESOURCE_PATH = "com.javarush.task.task26.task2613.resources.";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            CommandExecutor.execute(Operation.LOGIN);

            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);

            } while (operation != Operation.EXIT);

        } catch (InterruptOperationException e) {
            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {

            }
            ConsoleHelper.writeMessage("Operation was terminated! Bye...");
        }
    }
}
