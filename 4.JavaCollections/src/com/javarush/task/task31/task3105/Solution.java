package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        /*String fileName = "D:\\JAVA RUSH\\data.txt";
        String zipName = "D:\\JAVA RUSH\\arch.zip";*/
        String fileName = args[0];
        String zipName = args[1];
        HashMap<String, ByteArrayOutputStream> tempMap = new HashMap<>();

        FileInputStream fileInputStream = new FileInputStream(zipName);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        ZipEntry zipEntry = zipInputStream.getNextEntry();
        File file = new File(fileName);

        while (zipEntry != null) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int a;
            byte[] tempData = new byte[8192];

            while ((a = zipInputStream.read(tempData)) != -1) {
                    buffer.write(tempData, 0, a);
                }
            if (!(zipEntry.getName().contains(file.getName())))
                tempMap.put(zipEntry.getName(), buffer);
            buffer.close();
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        fileInputStream.close();

        for (HashMap.Entry<String, ByteArrayOutputStream> pair: tempMap.entrySet()){
            System.out.println(pair.getKey());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(zipName);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
        Files.copy(file.toPath(), zipOutputStream);

        for (HashMap.Entry<String, ByteArrayOutputStream> pair: tempMap.entrySet()){
            zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
            zipOutputStream.write(pair.getValue().toByteArray());
        }

        zipOutputStream.close();
        fileOutputStream.close();
    }
}
