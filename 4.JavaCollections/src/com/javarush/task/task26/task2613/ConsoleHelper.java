package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Sukora Stas.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = "";

        try {
            line = reader.readLine();
            if (res.getString("operation.EXIT").equalsIgnoreCase(line)) throw new InterruptOperationException();
        } catch (IOException e) {}

        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currency = "";
        while (true) {
            currency = readString();
            if (currency.length() == 3)
                break;
            else
                writeMessage(res.getString("invalid.data"));
        }
        return currency.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String[] array;
        while (true) {
            array = readString().split(" ");
            if (array.length != 2) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            int i1, i2;
            try {
                i1 = Integer.parseInt(array[0]);
                i2 = Integer.parseInt(array[1]);
            } catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (i1 <= 0 || i2 <= 0) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        Integer numOperation;
        while (true) {
            String line = readString();
            try {
                numOperation = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }

            if (numOperation < 1 || numOperation > 4) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return Operation.getAllowableOperationByOrdinal(numOperation);
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
