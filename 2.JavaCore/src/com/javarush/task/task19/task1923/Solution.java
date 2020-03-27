package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        FileReader fileReader = new FileReader(fileName1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);

        String line;
        String[] words;
        while (bufferedReader.ready())
        {
            line = bufferedReader.readLine();
            words = line.split(" ");
            for (String word: words){
                if (word.matches(".*\\d.*"))
                    fileWriter.write(word + " ");
            }
        }

        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
