package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new java.util.Date();
        Integer int1 = (Integer) obj;
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        if (s.equals("bla bla")) System.out.println("yes");
    }

    public static void main(String[] args) {

    }
}
