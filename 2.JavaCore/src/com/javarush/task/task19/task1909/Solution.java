package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(filename2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            if (s.contains("."))
            {
                char[] data = s.toCharArray();
                for (int i = 0; i < data.length; i++) {
                    if (data[i] == 46) {
                        data[i] = 33;
                    }
                    bufferedWriter.write(data[i]);
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();
    }
}
