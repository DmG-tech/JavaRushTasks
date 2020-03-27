package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        if (N > 0) {
            Integer [] mas = new Integer[N];
            for (int i = 0; i < N; i++) {
                mas[i] = Integer.parseInt(reader.readLine());
            }
            Arrays.sort(mas, Collections.reverseOrder());
            System.out.println(mas[0]);
            }
        }
    }
