package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buffer = new byte[file.available()];
        file.read(buffer);
        file.close();

        int count = 0;
        for (int i = 0; i < buffer.length; i++)
        {
            if ((int) buffer[i] == 32)
                count++;
        }

        double val= Math.round((float) count/buffer.length*100*100.0)/100.0;
        System.out.println(val);
    }
}
