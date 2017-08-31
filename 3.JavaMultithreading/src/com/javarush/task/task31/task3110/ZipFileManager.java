package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Sukora Stas.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream inputStream = Files.newInputStream(source)) {

            ZipEntry sourceEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(sourceEntry);

            //Считываем содержимое файла в массив byte
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            //Добавляем содержимое к архиву
            zipOutputStream.write(buffer);
            //Закрываем текущую запись для новой записи
            zipOutputStream.closeEntry();

        }
    }
}
