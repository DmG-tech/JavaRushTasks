package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            list.add(reader.readLine());
        }
        for (int j = 0; j < 13; j++){
            list.add(0, list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        for (int a = 0; a < list.size(); a++){
            System.out.println(list.get(a));
        }
    }
}
