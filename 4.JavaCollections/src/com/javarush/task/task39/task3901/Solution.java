package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int resultLength = 0;
        if ( s == null) return resultLength;
        StringBuilder currentString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            currentString.append(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                Character currentLetter = s.charAt(j);
                if (!currentString.toString().contains(currentLetter.toString())) {
                    currentString.append(currentLetter);
                }
                else break;
            }
            if (resultLength < currentString.length()) resultLength = currentString.length();
            currentString.delete(0, currentString.length());
        }
        /*int length = 0;
        if (s == null) return length;
        StringBuilder tempLine = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            tempLine.append(s.charAt(i));
            int currentlength = 1;
            for (int j = i+1; j < s.length(); j++) {
                String currentLetter = String.valueOf(s.charAt(j));
                if (!tempLine.toString().contains(currentLetter)) {
                    tempLine.append(currentLetter);
                    currentlength++;
                    if (j == s.length()-1) {
                        if (length < currentlength) length = currentlength;
                        tempLine.delete(0, tempLine.length());
                        break;
                    }
                }
                else {
                    if (length < currentlength) length = currentlength;
                    tempLine.delete(0, tempLine.length());
                    break;
                }
            }
        }
        return length;*/
        return resultLength;
    }
}
