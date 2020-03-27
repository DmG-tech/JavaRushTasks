package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JAVA RUSH\\qwerty.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Solution savedObject = new Solution(20);
        System.out.println(savedObject);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\JAVA RUSH\\qwerty.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Solution loadedObject = new Solution(25);
        System.out.println(loadedObject);
        loadedObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println(loadedObject);

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}