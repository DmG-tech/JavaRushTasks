package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] temp = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        System.out.println(maxSquare(temp));
    }

    public static int maxSquare(int[][] matrix) {
        int[][] array = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = matrix[i][j];
                    continue;
                }
                if (matrix[i][j] == 0) {
                    array[i][j] = 0;
                    continue;
                }
                array[i][j] = getMin(array, i, j) + 1;
            }
        }
        return (int) Math.pow(getMax(array), 2);
    }

    private static int getMin(int[][] array, int i, int j) {
        int min = 0;
        try {
            int temp = Math.min(array[i][j-1], array[i-1][j]);
            min = Math.min(temp, array[i-1][j-1]);
        }
        catch (ArrayIndexOutOfBoundsException e) { }
        return min;
    }

    private static int getMax(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int current = array[i][j];
                if (current > max) max = current;
            }
        }
        return max;
    }
}
