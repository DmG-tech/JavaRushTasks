package com.javarush.task.task39.task3904;

/* 
Лестница
*/
public class Solution {
    private static int n = 4;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        int countOfWay = 0;
        if (n == 0) countOfWay = 1;
        if (n < 0);
        else {

        }
        return countOfWay;
    }

    private static int goToTree(int n) {
            if (n - 1 >= 0) {
                return goToTree(n-1);
            }
            if (n - 2 >= 0) {
                return goToTree(n-2);
            }
            if (n - 3 >= 0) {
                return goToTree(n-3);
            }
        return n;
    }
}

