package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        ArrayList<String> alphabetTemp = new ArrayList<>();
        for (int i = 0; i < alphabet.size(); i++)
        {
            alphabetTemp.add(alphabet.get(i).toString());
        }
        TreeMap<String, Integer> result = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < alphabetTemp.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.get(j).length(); k++)
                {
                    if (alphabetTemp.get(i).contains(list.get(j).substring(k,k+1)))
                    {
                        count++;
                    }
                }
            }
            result.put(alphabetTemp.get(i), count);
            count = 0;
        }
        for (int i = 0; i < alphabetTemp.size(); i++)
        {
            for (Map.Entry<String, Integer> x : result.entrySet())
            {
                if (alphabetTemp.get(i).equals(x.getKey()))
                    System.out.println(alphabet.get(i) + " " + x.getValue());
            }
        }

    }

}
