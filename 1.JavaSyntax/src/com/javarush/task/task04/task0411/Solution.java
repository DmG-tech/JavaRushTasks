package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //напишите тут ваш код
        if (month > 8 && month < 12)
            System.out.println("осень");
        else if (month > 11 || month < 3)
            System.out.println("зима");
        else if (month > 2 && month < 6)
            System.out.println("весна");
        else
            System.out.println("лето");
    }
}