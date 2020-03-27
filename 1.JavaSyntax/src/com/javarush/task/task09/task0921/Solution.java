package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try {
            while ( true){
                String s = reader.readLine();
                if (s.isEmpty()) break;
                list.add(Integer.parseInt(s));
            }
        }
        catch (Exception e)
        {
            for (Integer s : list){
                System.out.println(s);
            }
        }
    }
}
