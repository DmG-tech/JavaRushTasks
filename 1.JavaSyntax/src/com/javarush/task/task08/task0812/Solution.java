package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int countTemp = 1;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                countTemp++;
            } else if (!(list.get(i).equals(list.get(i + 1)))) {
                countList.add(countTemp);
                countTemp = 1;
            }
            countList.add(countTemp);
        }
        int max = countList.get(0);
        for (int i = 0; i < countList.size(); i++){
            if (countList.get(i) > max){
                max = countList.get(i);
            }
        }
        System.out.println(max);
    }
}