package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        List<String> fileNames = new ArrayList<>();

        File directory = new File(path);
        getListFiles(directory, fileNames);

        for (int i = 0; i < fileNames.size(); i++){
            File tempFile = new File(fileNames.get(i));
            if (tempFile.length() > 50) {
                fileNames.remove(fileNames.get(i));
                i--;
            }
        }
        Collections.sort(fileNames);

        File result = new File(resultFileAbsolutePath);
        File newResult = new File(result.getParent() + "\\allFilesContent.txt");
        FileUtils.renameFile(result, newResult);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(newResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String s: fileNames){
            System.out.println(s);
            try {
                fileInputStream = new FileInputStream(s);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (fileInputStream.available() > 0){
            fileOutputStream.write(fileInputStream.read());
            }
            fileOutputStream.write("\n".getBytes());
        }
        fileOutputStream.close();
        fileInputStream.close();
        }

    public static void getListFiles(File file, List<String> list){
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isFile())
                    list.add(f.getAbsolutePath());
                getListFiles(f, list);
            }
        }
    }
}
