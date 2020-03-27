package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        ImageReader reader = null;
        try {
            if (imageTypes.equals(ImageTypes.BMP)) reader = new BmpReader();
            else if (imageTypes.equals(ImageTypes.JPG)) reader = new JpgReader();
            else if (imageTypes.equals(ImageTypes.PNG)) reader = new PngReader();
        }
        catch (Exception e)
        {
            throw  new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
