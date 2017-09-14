package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.io.IOException;

/**
 * Created by Sukora Stas.
 */
public class CashMachine {
    public static void main(String[] args) throws IOException {
        Operation operation;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }
}
