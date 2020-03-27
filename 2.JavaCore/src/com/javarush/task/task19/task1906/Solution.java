package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        int count = 1;
        while (fileReader.ready())
        {
            int data = fileReader.read();
            if (count % 2 == 0)
                fileWriter.write(data);
            count++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
