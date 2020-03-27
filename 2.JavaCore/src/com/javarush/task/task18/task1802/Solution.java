package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        int min = file.read();
        while (file.available() > 0)
        {
            int temp = file.read();
            if (temp < min)
                min = temp;
        }
        file.close();
        System.out.println(min);
    }
}
