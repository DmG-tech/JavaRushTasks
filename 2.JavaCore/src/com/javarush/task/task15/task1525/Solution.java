package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        File file = new File(Statics.FILE_NAME);
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String s = reader.readLine();
            while (s != null)
            {
                lines.add(s);
                s = reader.readLine();
            }
            fileReader.close();
            reader.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
