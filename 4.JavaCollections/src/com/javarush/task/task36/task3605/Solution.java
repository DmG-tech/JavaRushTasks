package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName  = args[0];
        FileReader fileReader = new FileReader(fileName);
        Set<Character> characters = new TreeSet<>();
        while (fileReader.ready()) {
            char temp = Character.toLowerCase((char) fileReader.read());
            characters.add(temp);
        }
        fileReader.close();
        for (int i = 0; i < 5;) {
            if (!characters.isEmpty()) {
                if (Character.isLetter(((TreeSet<Character>) characters).first())) {
                    System.out.print(((TreeSet<Character>) characters).pollFirst());
                    i++;
                } else characters.remove(((TreeSet<Character>) characters).first());
            }
            else break;
        }
    }
}
