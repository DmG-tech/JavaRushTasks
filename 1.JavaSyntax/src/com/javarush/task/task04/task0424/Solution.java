package com.javarush.task.task04.task0424;

/* 
Три числа
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

        if (a < b && b == c)
            System.out.println("1");
        else if (b < c && c == a)
            System.out.println("2");
        else if (c < b && b == a)
            System.out.println("3");
    }
}
