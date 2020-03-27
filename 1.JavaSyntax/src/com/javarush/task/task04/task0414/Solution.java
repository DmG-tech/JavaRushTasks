package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String year = bufferedReader.readLine();

        int a = Integer.parseInt(year);

        if (a % 400 == 0)
            System.out.println("количество дней в году: 366");
        else if (a % 100 == 0)
            System.out.println("количество дней в году: 365");
        else if (a % 4 == 0)
            System.out.println("количество дней в году: 366");
        else
            System.out.println("количество дней в году: 365");
    }
}