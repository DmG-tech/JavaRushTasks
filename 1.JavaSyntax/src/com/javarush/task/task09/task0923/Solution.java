package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> glas = new ArrayList<>();
        ArrayList<String> soglas = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            list.add(s.substring(i,i+1));
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).equals(" "))
            {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (isVowel(list.get(i).charAt(0)))
            {
                glas.add(list.get(i));
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (!isVowel(list.get(i).charAt(0)))
            {
                soglas.add(list.get(i));
            }
        }
        for (String a : glas)
        {
            System.out.print(a + " ");
        }
        System.out.println();
        for (String b : soglas)
        {
            System.out.print(b + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}