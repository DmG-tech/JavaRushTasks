package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        byte[] array = new byte[file.available()];
        while (file.available() > 0) file.read(array);
        file.close();

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if (array[i] == array[j])
                    count++;
            }
            map.put((int) array[i], count);
            count = 0;
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() > max)
                max = pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue().equals(max))
                System.out.print(pair.getKey() + " ");
        }
    }
}
