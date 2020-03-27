package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int i = 0, j = 0;

        if (a > 0) {
            i++;
        }
        else if (a < 0) {
            j++;
        }
        if (b > 0) {
            i++;
        }
        else if (b < 0) {
            j++;
        }
        if (c > 0) {
            i++;
        }
        else if (c < 0) {
            j++;
        }
        System.out.println("количество отрицательных чисел: " + j);
        System.out.println("количество положительных чисел: " + i);
    }
}
