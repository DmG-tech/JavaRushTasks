package com.javarush.task.task39.task3908;

import java.util.HashMap;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aasseerrttyyuuiI"));
    }

    public static boolean isPalindromePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.computeIfPresent(chars[i], (k,v) -> v+1);
            map.putIfAbsent(chars[i], 1);
        }
        int countOdd = 0;
        for (Integer i: map.values()) {
            if (i % 2 != 0) countOdd++;
            if (countOdd > 1) return false;
        }
        return true;
    }
}
