package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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

        if ( a == b && b == c)
            System.out.println(a + " " + b + " " + c);
        else if (a == b)
            System.out.println(a + " " + b);
            else if (a == c)
            System.out.println(a + " " + c);
        else if (b == c)
            System.out.println(b + " " + c);


    }
}