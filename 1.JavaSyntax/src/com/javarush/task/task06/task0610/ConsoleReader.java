package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word =  reader.readLine();
        return word;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numb = Integer.parseInt(reader.readLine());
        return numb;
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       double dub = Double.parseDouble(reader.readLine());
        return dub;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean bool = Boolean.parseBoolean(reader.readLine());
        return bool;
    }

    public static void main(String[] args) {

    }
}
