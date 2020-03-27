package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] aray = new ArrayList[10];
        for (int i = 0; i < 10; i++)
        {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 20; j++)
            {
                list.add("string" + j);
            }
            aray[i] = list;
        }
        return aray;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}