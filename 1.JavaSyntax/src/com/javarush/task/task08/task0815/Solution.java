package com.javarush.task.task08.task0815;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++){
            map.put("Family" + i, "Name" + i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> x : map.entrySet())
            if (x.getValue().contains(name)) {
                count++;
            }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
            if (map.keySet().contains(lastName)) count++;
        return count;
    }

    public static void main(String[] args) {

    }
}
