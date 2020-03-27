package com.javarush.task.task13.task1319;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        while (true)
        {
            String s = reader.readLine();
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            if (s.equals("exit"))
                break;
        }
        reader.close();
        bufferedWriter.close();
    }
}