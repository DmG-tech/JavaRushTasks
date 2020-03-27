package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String namefile = reader.readLine();
            try {
                FileReader fileReader = new FileReader(namefile);
                fileReader.close();
            } catch (FileNotFoundException e) {
                reader.close();
                System.out.println(namefile);
                break;
            }
        }
    }
}
