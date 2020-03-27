package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return FactoryOfExeptions.class;
    }

    public static void main(String[] args) {
        Throwable e = FactoryOfExeptions.getExeption(null);
        System.out.println(e.getClass());
    }
}