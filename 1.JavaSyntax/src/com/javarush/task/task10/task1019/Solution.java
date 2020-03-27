package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        while (true)
        {
            String key = reader.readLine();
            if (key.isEmpty()) break;
            String val = reader.readLine();
            map.put(val, Integer.parseInt(key));
        }
        for (Map.Entry<String, Integer> x : map.entrySet())
        {
            System.out.println( x.getValue() + " " + x.getKey());
        }
    }
}
