package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        byte[] array = new byte[text.getBytes().length];
        raf.read(array, 0, text.getBytes().length);
        String textByFile = new String(array);
        raf.seek(raf.length());
        if (text.equals(textByFile)) {
            raf.write("true".getBytes());
        }
        else raf.write("false".getBytes());
        raf.close();
    }
}
