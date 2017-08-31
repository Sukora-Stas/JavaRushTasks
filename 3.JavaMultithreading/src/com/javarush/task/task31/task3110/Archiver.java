package com.javarush.task.task31.task3110;


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
    }
}
