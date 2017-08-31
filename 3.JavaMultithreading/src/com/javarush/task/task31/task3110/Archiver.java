package com.javarush.task.task31.task3110;


import com.javarush.task.task31.task3110.command.ExitCommand;

import java.nio.file.Paths;

/**
 * Created by Sukora Stas.
 */
public class Archiver {
    public static void main(String[] args) throws Exception {

        ConsoleHelper.writeMessage("Введите полный путь к архиву: ");
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(ConsoleHelper.readString()));
        ConsoleHelper.writeMessage("Введите путь к архивируемому файлу: ");
        zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
