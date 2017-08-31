package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;

/**
 * Created by Sukora Stas.
 */
public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
