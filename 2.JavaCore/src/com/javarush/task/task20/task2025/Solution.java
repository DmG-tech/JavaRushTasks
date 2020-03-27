package com.javarush.task.task20.task2025;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long temp = 0;
        List<Long> list = new ArrayList<>();
        for (long i = 1; i < N; i++){
            String number = String.valueOf(i);
            int sizeNumber = number.length();
            for (int j = 0; j < sizeNumber; j++){
                temp = temp + (long) Math.pow(Double.parseDouble(String.valueOf(number.charAt(j))), (double) sizeNumber);
            }
            if (i == temp)
                list.add(i);
            temp = 0;
        }
        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long[] array = getNumbers( 92233);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
