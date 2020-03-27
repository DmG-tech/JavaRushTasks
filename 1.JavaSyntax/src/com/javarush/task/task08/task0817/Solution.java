package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Family" + 1, "name" + 1);
        map.put("Family" + 2, "name" + 2);
        map.put("Family" + 3, "name" + 3);
        map.put("Family" + 4, "name" + 4);
        map.put("Family" + 5, "name" + 5);
        map.put("Family" + 6, "name" + 6);
        map.put("Family" + 7, "name" + 7);
        map.put("Family" + 8, "name" + 3);
        map.put("Family" + 9, "name" + 3);
        map.put("Family" + 10, "name" + 3);
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>(map.values());
        int count = 0;
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)))
                {
                    count++;
                }
            }
            if (count > 1)
            {
                removeItemFromMapByValue(map,list.get(i));
                count = 0;
            }
            else
                count = 0;
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

}
}
