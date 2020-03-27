package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = "D:\\\\\\\\JAVA RUSH\\\\\\\\data.txt";//reader.readLine();
        String filename2 = "D:\\\\\\\\JAVA RUSH\\\\\\\\result.txt";//reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(filename2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] data = line.split(" ");
            for (int i = 0; i < data.length; i++) {
                if (data[i].matches("\\d+")) {
                    System.out.println(data[i]);
                    bufferedWriter.write(data[i]);
                    bufferedWriter.write(32);
                }
            }
        }
            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
    }
}
