package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);

        byte[] buffer = new byte[file1.available()];
        while (file1.available() > 0)
            file1.read(buffer);
        if (buffer.length % 2 == 0) {
            file2.write(buffer, 0, buffer.length / 2);
            file3.write(buffer, buffer.length / 2, buffer.length/2);
        }
        else {
            file2.write(buffer, 0, buffer.length / 2 + 1);
            file3.write(buffer, buffer.length / 2 + 1, buffer.length/2);
        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
