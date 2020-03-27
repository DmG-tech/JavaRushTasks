package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader  inputStreamReader= new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String number = bufferedReader.readLine();
        int num = Integer.parseInt(number);

        if (num < 0)
            System.out.println(num + 1);
        else if (num > 0)
            System.out.println(num*2);
        else
            System.out.println("0");

    }

}