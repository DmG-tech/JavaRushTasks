package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Считываем с консиоли имена файлов и заносим их в список
        List<String> fileNames = new ArrayList<>();
        while (true)
        {
            String fileName = reader.readLine();
            if (fileName.equals("end"))
                break;
            fileNames.add(fileName);
        }
        reader.close();

        //Сортируем файлы из списка для упорядоченной записи
        Collections.sort(fileNames);

        //Получаем имя файла для создания
        String[] temp = fileNames.get(0).split("[.]");
        String fileNameForCreate = temp[0];
        for (int i = 1; i < temp.length-1; i++) fileNameForCreate = fileNameForCreate + "." + temp[i];

        //Создаем файл для записи файлов из списка
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameForCreate);

        //Читаем файлы из списка по порядку и записываем в созданный файл
        byte[] buffer;
        FileInputStream fileInputStream = null;
        for (int i = 0; i < fileNames.size(); i++)
        {
            fileInputStream = new FileInputStream(fileNames.get(i));
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
    //String[] temp = reader.readLine().split("\\D");
    //String filename = temp[temp.length-1];