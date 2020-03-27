package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for ( int i = 0; i < 5; i++){
            strings.add(reader.readLine());
        }

        int max = strings.get(0).length();

        for (int j = 0; j < strings.size(); j++){
            if (strings.get(j).length() > max){
                max = strings.get(j).length();
            }
        }
        for (int y = 0; y < strings.size(); y++){
            if (strings.get(y).length() == max)
                System.out.println(strings.get(y));
        }
    }
}
