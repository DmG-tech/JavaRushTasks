package com.javarush.task.task14.task1419;

import org.w3c.dom.events.EventException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            ArrayList list = new ArrayList();
            list.get(10);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try {
            FileReader fileReader = new FileReader("1.txt");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try {
            Object i = Integer.valueOf(42);
            String s = (String)i;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try {
            String s = "ad";
            int a = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try {
            String[] mas = new String[5];
            mas[6] = "5";
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        Exception e = new EmptyStackException();
        exceptions.add(e);

        Exception a = new RuntimeException();
        exceptions.add(a);

        Exception w = new CloneNotSupportedException();
        exceptions.add(w);
        Exception v = new NoSuchFieldException();
        exceptions.add(v);
       }
}
