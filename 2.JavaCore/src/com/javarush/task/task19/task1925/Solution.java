package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        FileReader fileReader = new FileReader(fileName1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);

        String line;
        String[] words;
        List<String> list = new ArrayList<>();
        while (bufferedReader.ready())
        {
            line = bufferedReader.readLine();
            words = line.split(" ");
            for (String word: words)
                if (word.length() > 6)
                    list.add(word);
        }

        bufferedReader.close();
        fileReader.close();

        for (int i = 0; i < list.size()-1; i++)
            list.set(i,list.get(i)+",");
        for (String s: list)
            fileWriter.write(s);

        fileWriter.close();
    }
}
