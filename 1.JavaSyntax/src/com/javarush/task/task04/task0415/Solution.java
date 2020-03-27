package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String num1 = bufferedReader.readLine();
        String num2 = bufferedReader.readLine();
        String num3 = bufferedReader.readLine();

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int c = Integer.parseInt(num3);

        if (a+b > c && a+c > b && b+c > a)
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");
    }
}