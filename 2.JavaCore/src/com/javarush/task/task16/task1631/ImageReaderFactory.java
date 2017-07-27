package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Sukora Stas.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types) {
//        try {
//            if (types.equals(ImageTypes.JPG)) {
//                return new JpgReader();
//            } else if (types.equals(ImageTypes.BMP)) {
//                return new BmpReader();
//            } else if ((types.equals(ImageTypes.PNG))) {
//                return new PngReader();
//            } else {
//                throw new IllegalArgumentException("Неизвестный тип картинки");
//            }
//        }catch (IllegalArgumentException e){
//            throw new IllegalArgumentException("Неизвестный тип картинки");
//
//        }

        ImageReader result=null;
        try {
            switch (types) {
                case BMP:
                    result = new BmpReader();
                    break;
                case JPG:
                    result = new JpgReader();
                    break;
                case PNG:
                    result = new PngReader();
                    break;
            }
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return result;
    }
}
