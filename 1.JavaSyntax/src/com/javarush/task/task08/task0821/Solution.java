package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>(10);
        map.put("Dima", "Ivanov");
        map.put("Vasia", "Petrov");
        map.put("Petua", "Sidorov");
        map.put("Max", "Gusev");
        map.put("Den", "tutkin");
        map.put("Dima", "Pupkin");
        map.put("Kostya", "Ivanov");
        map.put("Georg", "Ivanov");
        map.put("Gus", "Ivanov");
        map.put("Dima", "Ivanov");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
