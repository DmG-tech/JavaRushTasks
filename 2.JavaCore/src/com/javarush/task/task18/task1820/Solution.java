package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        //FileReader fileReader1 = new FileReader("D:\\JAVA RUSH\\data.txt");
        FileReader fileReader1 = new FileReader(fileName1);
        //FileOutputStream fileWriter2 = new FileOutputStream("D:\\JAVA RUSH\\result.txt");
        FileOutputStream fileWriter2 = new FileOutputStream(fileName2);

        reader = new BufferedReader(fileReader1);
        String s = reader.readLine();
        //System.out.println(s);

        String[] mas = s.split(" ");
        s = Math.round(Double.parseDouble(mas[0])) + " ";
        for (int i = 1; i < mas.length; i++)
            s = s + Math.round(Double.parseDouble(mas[i])) + " ";
        byte[] buf = s.getBytes();
        fileWriter2.write(buf);
        reader.close();
        fileReader1.close();
        fileWriter2.close();
    }
}
