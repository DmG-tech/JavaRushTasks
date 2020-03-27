package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream file2 = new FileInputStream(fileName2);
        FileInputStream file3 = new FileInputStream(fileName3);
        FileOutputStream file1 = new FileOutputStream(fileName1);

        byte[] buffer2 = new byte[file2.available()];
        byte[] buffer3 = new byte[file3.available()];
        file2.read(buffer2);
        file3.read(buffer3);

        file1.write(buffer2);
        file1.write(buffer3);

        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
