package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream file = new FileInputStream(filename);

        reader = new BufferedReader(new InputStreamReader(file));

        String line;
        ArrayList<Integer> list = new ArrayList<>();
        while((line = reader.readLine()) != null){
            if (Integer.parseInt(line) % 2 == 0)
                list.add(Integer.parseInt(line));
        }
        file.close();
        reader.close();
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
