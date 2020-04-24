package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("qwertq", "qwertyy"));
    }

    public static boolean isOneEditAway(String first, String second) {
        int difference = 0;
        char[] firstString = first.toCharArray();
        char[] secondString = second.toCharArray();
        int difOfLength = Math.abs(firstString.length - secondString.length);
        if (difOfLength > 1) return false;
        if (difOfLength == 0) return compareStringSameLength(firstString, secondString);
        if (difOfLength == 1) return compareStringDifferentLength(firstString, secondString);
        /*int abs = Math.abs(firstString.length - secondString.length);
        int minSize = Math.min(firstString.length, secondString.length);
        if (abs > 1) return false;
        else if (abs == 1) {
            difference++;
            for ( int i = 0; i < minSize; i++) {
                try {
                if (firstString[i] != secondString[i] &
                        firstString[i] != secondString[i + 1] &
                        firstString[i + 1] != secondString[i])
                    difference++;
                }
                catch (ArrayIndexOutOfBoundsException e) {}
                if (difference > 1) return false;
            }
        }
        else if (abs == 0) {
            for ( int i = 0; i < minSize; i++) {
                if (firstString[i] != secondString[i]) difference++;
                if (difference > 1) return false;
            }
        }*/
            return false;
    }

    private static boolean compareStringSameLength(char[] firstString, char[] secondString) {
        int difference = 0;
        for (int i = 0; i < firstString.length; i++) {
            if (firstString[i] != secondString[i]) difference++;
            if (difference > 1) return false;
        }
        return true;
    }

    private static boolean compareStringDifferentLength(char[] firstString, char[] secondString) {
        int difference = 1;
        char[] minString;
        char[] maxString;
        if (firstString.length < secondString.length) {
            minString = firstString;
            maxString = secondString;
        }
        else {
            minString = secondString;
            maxString = firstString;
        }
        for (int i = 0; i < minString.length; i++) {
            if (minString[i] != maxString[i] & minString[i] != maxString[i+1])
                difference++;
            if (difference > 1) return false;
        }
        return true;
    }
}
