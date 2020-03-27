package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] masS = new String[10];
        int[] mas = new  int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){
            masS[i] = reader.readLine();
        }
        for (int i = 0; i < 10; i++){
            mas[i] = masS[i].length();
            System.out.println(mas[i]);
        }
    }
}
