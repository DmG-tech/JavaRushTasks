package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String FileName = reader.readLine();

        InputStream inputStream = new FileInputStream(FileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (bufferedInputStream.available() > 0)
        {
            System.out.print((char) bufferedInputStream.read());
        }
        inputStream.close();
        reader.close();
        bufferedInputStream.close();
    }
}