package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();

            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String FILE_NAME;
        String FileContent = "";

//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(
//                        new FileInputStream(fullFileName), StandardCharsets.UTF_8))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            // log error
//        }


        @Override
        public void setFileName(String fullFileName) {
            this.FILE_NAME = fullFileName;
        }

        @Override
        public String getFileContent() {
            return this.FileContent;
        }


        @Override
        public void run() {
            String line;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
                //join();
                while (true) {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        FileContent += line+" ";
                    }
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //add your code here - добавьте код тут
}
