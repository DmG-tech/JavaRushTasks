package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){
            list.add(reader.readLine());
        }
        int min = list.get(0).length();
        int IndexMin = 0;
        int max = list.get(0).length();
        int IndexMax = 0;

        for ( int i = 0; i < list.size(); i++){
            if (list.get(i).length() < min) {
                min = list.get(i).length();
                IndexMin = i;
            }
            else if (list.get(i).length() > max) {
                max = list.get(i).length();
                IndexMax = i;
            }
        }
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).length() == min && IndexMin < IndexMax) {
                System.out.println(list.get(i));
                break;
            }
            else if (list.get(i).length() == max && IndexMax < IndexMin){
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
