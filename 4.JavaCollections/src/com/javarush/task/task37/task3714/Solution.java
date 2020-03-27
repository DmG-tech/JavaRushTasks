package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int result = 0;
        HashMap<String, Integer> alphabet = new HashMap<>();
        alphabet.put("I", 1);
        alphabet.put("V", 5);
        alphabet.put("X", 10);
        alphabet.put("L", 50);
        alphabet.put("C", 100);
        alphabet.put("D", 500);
        alphabet.put("M", 1000);

        char[] charArray = s.toCharArray();
        int size = charArray.length;
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = alphabet.get(String.valueOf(charArray[i]));
        }
        for (int i = size - 1; i >= 0; i--) {
            if (i == 0) {
                result = result + intArray[i];
                break;
            }
            if (intArray[i] > intArray[i-1]) {
                result = result + intArray[i] - intArray[i-1];
                i--;
            }
            else result = result + intArray[i];
        }
        return result;
    }
}
