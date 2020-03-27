package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        List<String> listPartOfFileNames = new ArrayList<>();
        for (int i = 1; i < args.length; i++)
            listPartOfFileNames.add(args[i]);
        Collections.sort(listPartOfFileNames);
        List<InputStream> listInputStream = new ArrayList<>();
        for (String s: listPartOfFileNames) {
            InputStream inputStream = new FileInputStream(s);
            listInputStream.add(inputStream);
        }

        /*for (InputStream stream: listInputStream) {
            FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(stream));
        }*/


    }
}
