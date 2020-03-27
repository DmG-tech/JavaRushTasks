package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        // Возвращаем все как было
        System.setOut(consoleStream);

        String[] line = byteArrayOutputStream.toString().split("\\n");

        for (int i = 1; i < line.length; i=i+2 )
            line[i] = line[i] + "\nJavaRush - курсы Java онлайн";
        for (String s: line)
            System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
