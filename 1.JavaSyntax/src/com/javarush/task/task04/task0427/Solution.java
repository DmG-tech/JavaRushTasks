package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = a % 2;
        int c = (int) Math.log10(a) + 1;
        String PoN = null;
        String Num = null;
        if (a >= 1 && a <= 999) {
            if (c == 1) {
                Num = "однозначное";
            } else if (c == 2) {
                Num = "двузначное";
            } else if (c == 3) {
                Num = "трехзначное";
            }
            if (b == 0) {
                PoN = "четное";
            } else {
                PoN = "нечетное";
            }
            System.out.println(PoN + " " + Num + " число");
        }
    }
}