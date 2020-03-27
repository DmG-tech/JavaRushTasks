package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        while (map.size() < 10){
            map.put("family " + Math.random(), 100 + (int) Math.random() * 5000);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        map.entrySet().removeIf(x -> x.getValue() < 500);
    }

    public static void main(String[] args) {

    }
}