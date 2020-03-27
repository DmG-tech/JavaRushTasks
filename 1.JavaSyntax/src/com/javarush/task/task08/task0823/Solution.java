package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        s = s.trim();
        String[] word = s.split(" +");
        for (int i = 0; i < word.length; i++){
            word[i] = word[i].substring(0,1).toUpperCase() + word[i].substring(1);
        }
        for (String a : word){
            System.out.print(a + " ");
        }
    }
}
