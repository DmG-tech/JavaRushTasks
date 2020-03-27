package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        //FileInputStream file = new FileInputStream("D:\\JAVA RUSH\\data.txt");

        byte[] buffer = new byte[file.available()];
        file.read(buffer);
        file.close();

        int[] array = new int[256];
        int count = 0;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < buffer.length; j++)
            {
                if (i == (int) buffer[j])
                    count++;
            }
            array[i] = count;
            count = 0;
        }

        for (int i = 0; i < array.length; i++)
            if (array[i] != 0)
            System.out.println((char) i + " " + array[i]);
    }
}
