package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Sukora Stas.
 */
public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
//        String line = bis.readLine();
//        return line;
        String message = null;
        try {
            message = bis.readLine();
        } catch (Exception e) {
        }
        if (message != null)
        {
            if ("EXIT".equals(message.toUpperCase()))
            {
                throw new InterruptOperationException();
            }
        }
        return message;

    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String code = null;
        writeMessage("Please choice currency code:");
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage("Error, Please choice again:");

        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Input nominal and total:");

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            if (nominal <= 0 || total <= 0) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            break;
        }
        return input;

    }

    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            try
            {
                writeMessage("Choice operation:\n1) INFO\n2) DEPOSIT\n3) WITHDRAW\n4) EXIT");
                return Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Incorrect operation");
            }
        }
    }

}
