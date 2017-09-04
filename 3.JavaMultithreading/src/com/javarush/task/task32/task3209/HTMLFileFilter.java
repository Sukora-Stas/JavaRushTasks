package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Sukora Stas.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }
        else if (!f.isDirectory()) {
            String fileName = f.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
