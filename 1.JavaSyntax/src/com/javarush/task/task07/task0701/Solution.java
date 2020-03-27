package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int[] mas = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mas.length; i++){
            mas[i] = Integer.parseInt(reader.readLine());
        }
        return mas;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max)
               max = array[i];
        }
        return max;
    }
}
