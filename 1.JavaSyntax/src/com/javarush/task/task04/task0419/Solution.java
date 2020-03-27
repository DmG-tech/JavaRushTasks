package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
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
        String num4 = bufferedReader.readLine();

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int c = Integer.parseInt(num3);
        int d = Integer.parseInt(num4);

        if (a >= b && a >= c && a >= d)
            System.out.println(a);
        else if (b >= a && b >= c && b >= d)
            System.out.println(b);
        else if (c >= a && c >= b && c >= d)
            System.out.println(c);
        else if (d >= a && d >= b && d >= c)
            System.out.println(d);

    }
}
