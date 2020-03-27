package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String t = bufferedReader.readLine();
        double a = Double.parseDouble(t);
        double b = a/10;
        int c = (int)b;
        double d;

        d = a-c*10;

        if ((d > 0 && d <3) || (d >= 5 && d < 8))
            System.out.println("зелёный");
        else if ((d < 4 && d >= 3) || (d < 9 && d >= 8))
            System.out.println("жёлтый");
        else if ((d < 5 && d >= 4) || (d < 10 && d >= 9))
            System.out.println("красный");
    }
}