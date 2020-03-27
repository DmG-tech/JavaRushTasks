package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        url = url.substring(url.indexOf("?") + 1);
        String[] line = url.split("&");

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for (String s: line)
            if (s.contains("=")) {
                map.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1));
            }
        else map.put(s,null);

        for (Map.Entry<String, String> pair : map.entrySet())
            System.out.print(pair.getKey() + " ");

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getKey().equals("obj"))
                try {
                    alert(Double.parseDouble(pair.getValue()));
                }
            catch (Exception e)
            {
                alert(pair.getValue());
            }
        }
    }

    public static void alert(double value) {
        System.out.println("\n" + "double: " + value);
    }

    public static void alert(String value) {
        System.out.println("\n" + "String: " + value);
    }
}
