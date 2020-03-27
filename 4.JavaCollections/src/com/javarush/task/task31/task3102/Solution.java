package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> listFiles = new ArrayList<>();
        ArrayDeque<String> listDirecroty = new ArrayDeque<>();
         listDirecroty.add(root);
         while (!listDirecroty.isEmpty()){
                 File tempFile = new File(listDirecroty.pollFirst());
                 for (File file: tempFile.listFiles()){
                     if (file.isFile())
                         listFiles.add(file.getAbsolutePath());
                     if (file.isDirectory())
                         listDirecroty.add(file.getAbsolutePath());
                 }
         }
        return listFiles;
    }

    public static void main(String[] args) throws IOException {

    }
}
