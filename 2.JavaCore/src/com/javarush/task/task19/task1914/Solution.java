package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String result = wrapperOfSystemOut();
        int a = 0;
        int b = 0;
        int c = 0;
        String[] data = result.split(" ");
        for (int i = 0; i < data.length; i++) {
            if (data[i].matches("\\d+")) {
                if (a == 0) a = Integer.parseInt(data[i]);
                else b = Integer.parseInt(data[i]);
            }
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("+"))
                c = a + b;
            else if (data[i].equals("-"))
                c = a - b;
            else if (data[i].equals("*"))
                c = a * b;
        }
        System.out.println(result + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
    public static String wrapperOfSystemOut () {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(consoleStream);
        return result;
    }
}

