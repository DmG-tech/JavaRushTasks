package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        // напишите тут ваш код
        HashSet<Integer> set = new HashSet<>(20);
        for (int i = 0; i < 20; i++){
            set.add(1 + (int) Math.random()*50 + i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        // напишите тут ваш код
        set.removeIf(x -> x > 10);
        return set;
    }

    public static void main(String[] args) {

    }
}
