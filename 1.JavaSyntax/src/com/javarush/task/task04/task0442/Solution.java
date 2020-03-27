package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        while (true){
            int numb = Integer.parseInt(reader.readLine());
            sum = sum + numb;
            if (numb == -1) {
                System.out.println(sum);
                break;
            }
        }
    }
}
