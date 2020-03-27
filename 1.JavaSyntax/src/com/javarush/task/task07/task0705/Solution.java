package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] mas20 = new int[20];
        int[] mas10_1 = new int[10];
        int[] mas10_2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            mas20[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < 10; i++) {
            mas10_1[i] = mas20[i];
        }
        for (int i = 10; i < 20; i++) {
            mas10_2[i - 10] = mas20[i];
            System.out.println(mas10_2[i-10]);
        }
    }
}
