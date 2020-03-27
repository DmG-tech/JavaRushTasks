package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int FirstNumber;
        int SecondNumber;

        FirstNumber = Integer.parseInt(reader.readLine());
        SecondNumber = Integer.parseInt(reader.readLine());
        if (FirstNumber <= 0) {
            throw new Exception();
        }
        if (SecondNumber <= 0) {
            throw new Exception();
        }

        while (FirstNumber != 0 && SecondNumber !=0) {
            if (FirstNumber > SecondNumber)
                FirstNumber = FirstNumber % SecondNumber;
            else SecondNumber = SecondNumber % FirstNumber;
        }
        System.out.println(FirstNumber + SecondNumber);
    }
}
