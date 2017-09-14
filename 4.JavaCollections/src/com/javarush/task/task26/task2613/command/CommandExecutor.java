package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sukora Stas.
 */
public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap;

    static {
        allKnownCommandsMap = new HashMap<>();
        allKnownCommandsMap.put(Operation.INFO, (Command) new InfoCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT, (Command) new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, (Command) new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT, (Command) new ExitCommand());
    }

    private CommandExecutor() {
    }

    public static final void execute(Operation operation) {
        allKnownCommandsMap.get(operation).execute();
    }


}
