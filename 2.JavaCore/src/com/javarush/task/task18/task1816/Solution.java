package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buffer = new byte[file.available()];
        file.read(buffer);
        file.close();

        int count = 0;
        for (int i = 0; i < buffer.length; i++)
            if ((((int) buffer[i] > 64) && ((int) buffer[i] < 91)) || (((int) buffer[i] > 96) && ((int) buffer[i] < 123)))
                count++;
        System.out.println(count);
    }
}
