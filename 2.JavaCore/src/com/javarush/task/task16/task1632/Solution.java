package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static
    {
        threads.add(new ThreadTest1());
        threads.add(new ThreadTest2());
        threads.add(new ThreadTest3());
        threads.add(new ThreadTest4());
        threads.add(new ThreadTest5());
            }

    public static void main(String[] args) {
    }

    public static class ThreadTest1 extends Thread
    {
        @Override
        public void run() {
            while (true)
            {}
        }
    }

    public static class ThreadTest2 extends Thread
    {
        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }

        }
    }

    public static class ThreadTest3 extends Thread
    {
        @Override
        public void run() {
            while (true)
            {
                try
                {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.getMessage();
                }
            }
        }
    }

    public static class ThreadTest4 extends Thread implements Message
    {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        @Override
        public void run() {
            while (!this.isInterrupted())
            {

            }
        }
    }

    public static class ThreadTest5 extends Thread
    {
        private ArrayList<Integer> list = new ArrayList<>();
        private  int sum;
        @Override
        public void run() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String number = null;
            try {
                while (true) {
                    number = reader.readLine();
                    if (number.equals("N"))
                        break;
                    else
                        list.add(Integer.parseInt(number));
                }
            }
            catch (Exception e) {e.getMessage();}
            for (Integer num: list)
            { sum = sum + num; }

            System.out.println(sum);
            return;
        }
    }
}