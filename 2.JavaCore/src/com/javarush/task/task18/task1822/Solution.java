package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "D:\\\\JAVA RUSH\\\\data.txt";
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);

        String s = reader.readLine();
        while (s != null)
        {
            String[] mas = s.split(" ");
            if (mas[0].equals(args[0]))
                System.out.println(s);
            s = reader.readLine();
        }
        reader.close();
        fileReader.close();
    }
}
