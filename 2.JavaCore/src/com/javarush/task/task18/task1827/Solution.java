package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0 && args[0].equals("-c")) {
        List<String> list = new ArrayList<>();
        String parameter = args[0];
        String productName = fixedLengthString(args[1], -30);
        String price = fixedLengthString(args[2], -8);
        String quantity = fixedLengthString(args[3], -4);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        reader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
        line = reader.readLine();}
        fileInputStream.close();
        reader.close();

            int maxID = 0;
            for (int i = 0; i < list.size(); i++) {
                if (maxID < Integer.parseInt(list.get(i).substring(0, 8).trim()))
                    maxID = Integer.parseInt(list.get(i).substring(0, 8).trim()); }
            maxID = maxID+1;
            String ID = fixedLengthString(String.valueOf(maxID), -8);
            list.add(ID + productName + price + quantity);
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write("\r" + list.get(list.size()-1));
            fileWriter.close();
            }
        }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }
        }

