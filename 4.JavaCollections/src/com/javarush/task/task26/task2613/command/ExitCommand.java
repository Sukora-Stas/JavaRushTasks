package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by Sukora Stas.
 */
class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
//        System.out.println("Do you really want to exit? <y,n>");
//        String answer = ConsoleHelper.readString();
//        if (answer.equalsIgnoreCase("Y")) {
//            ConsoleHelper.writeMessage("Bye");
//        } else {
//            throw new InterruptOperationException();
//        }
        ConsoleHelper.writeMessage("Are you sure want to quit? (y,n):");
        try {
            String s = ConsoleHelper.readString();
            if (s.equalsIgnoreCase("Y")) {
                ConsoleHelper.writeMessage("Bye");
            }
        } catch (InterruptOperationException e) {
            throw new InterruptOperationException ();

        }
    }
}
