package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        FileReader fileReader = new FileReader(filename);
        reader = new BufferedReader(fileReader);
        String line = null;
        int count = 0;
        while (reader.ready())
        {
            line = reader.readLine();
            String[] data = line.split("\\W");
            for (int i = 0; i < data.length; i++)
                if (data[i].equals("world") || data[i].equals("World")) count++;
        }
        fileReader.close();
        reader.close();
        System.out.println(count);
    }
}
