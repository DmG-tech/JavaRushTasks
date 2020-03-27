package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);

        byte[] buffer1 = new byte[fileInputStream1.available()];
        byte[] buffer2 = new byte[fileInputStream2.available()];

        fileInputStream1.read(buffer1);
        fileInputStream2.read(buffer2);

        fileOutputStream1.write(buffer2);
        fileOutputStream1.write(buffer1);

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream1.close();
    }
}
