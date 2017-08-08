package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] key = new byte[] {1,2,3,4,5};

        switch (args[0]) {
            case "-e": {
                FileInputStream src = new FileInputStream(args[1]);
                FileOutputStream dst = new FileOutputStream(args[2]);

                while (src.available() > 0) {
                    byte[] buf = new byte[src.available()];
                    src.read(buf);

                    //XOR Code
                    int j = 0;
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = (byte) (buf[i] ^ key[j]);
                        if (j > key.length)
                            j = 0;
                    }
                    dst.write(buf);
                }
                src.close();
                dst.close();
                break;
            }
            case "-d": {
                FileInputStream src = new FileInputStream(args[1]);
                FileOutputStream dst = new FileOutputStream(args[2]);

                while (src.available() > 0) {
                    byte[] buf = new byte[src.available()];
                    src.read(buf);




                    //XOR deCode
                    int j = 0;
                    for (int i = 0; i < buf.length; i++) {
                        buf[i] = (byte) (buf[i] ^ key[j]);
                        if (j > key.length)
                            j = 0;
                    }
                    dst.write(buf);
                }
                src.close();
                dst.close();
                break;
            }
        }
    }

}
