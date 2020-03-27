package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        int maxbyte = file.read();
        while (file.available() > 0)
        {
            int tempbyte = file.read();
            if (maxbyte < tempbyte)
                maxbyte = tempbyte;
        }
        file.close();
        System.out.println(maxbyte);
    }
}
