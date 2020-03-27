package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        int[] array = new int[255];
        while (file.available() > 0)
            array[file.read()]++;
        file.close();

        for (int i = 0; i < array.length; i++)
            if (array[i] != 0)
                System.out.print(i + " ");
    }
}
