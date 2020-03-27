package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] array5 = new int[] {2, 4, 6, 5, 4};
        int[] array2 = new int [] {4, 6};
        int[] array4 = new int []{6, 4, 2, 4};
        int[] array7 = new int []{5, 6, 4, 1, 3, 4, 6};
        int[] array0 = new int [0];
        list.add(array5);
        list.add(array2);
        list.add(array4);
        list.add(array7);
        list.add(array0);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
