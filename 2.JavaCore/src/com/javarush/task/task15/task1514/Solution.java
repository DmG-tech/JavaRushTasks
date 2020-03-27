package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(1.0, "A");
        labels.put(2.2, "A");
        labels.put(3.6, "A");
        labels.put(4.9, "A");
        labels.put(5.4, "A");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
