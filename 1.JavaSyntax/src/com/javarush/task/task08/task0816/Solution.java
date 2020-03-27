package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", df.parse("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Stallone2", df.parse("JUNE 1 1980"));
        map.put("Stallone3", df.parse("JUNE 1 1980"));
        map.put("Stallone4", df.parse("JUNE 1 1980"));
        map.put("Stallone5", df.parse("JUNE 1 1980"));
        map.put("Stallone6", df.parse("JUNE 1 1980"));
        map.put("Stallone7", df.parse("JUNE 1 1980"));
        map.put("Stallone8", df.parse("JUNE 1 1980"));
        map.put("Stallone9", df.parse("JUNE 1 1980"));
        map.put("Stallone10", df.parse("JUNE 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        DateFormat month = new SimpleDateFormat("M");
        map.entrySet().removeIf(x -> x.getValue().getMonth() == 5 || x.getValue().getMonth() == 6 || x.getValue().getMonth() == 7);
    }

    public static void main(String[] args) {

    }
}
