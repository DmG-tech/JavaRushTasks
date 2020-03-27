package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = byteArrayOutputStream.toString();

        System.setOut(consoleStream);
        System.out.println(new Solution().getStringOfNumber(result));


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }

    public String getStringOfNumber (String s)
    {
        String numbers = "";
        char[] data = s.toCharArray();
        for (int i = 0; i < data.length; i++)
        {
            if (String.valueOf(data[i]).matches("\\d"))
                numbers = numbers + data[i];
        }
        return numbers;
    }
}
