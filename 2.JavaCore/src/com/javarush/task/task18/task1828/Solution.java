package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 0 && (args[0].equals("-u") || args[0].equals("-d"))) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            List<String> list = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();}
            fileInputStream.close();
            reader.close();

            String id = fixedLengthString(args[1], -8);
            switch (args[0])
            {
                case "-u":
                    String productName = fixedLengthString(args[2], -30);
                    String price = fixedLengthString(args[3], -8);
                    String quantity = fixedLengthString(args[4], -4);

                    for (int i = 0; i < list.size(); i++)
                    {
                        if (list.get(i).contains(id))
                            list.set(i, id + productName + price + quantity);
                    }
                    break;
                case "-d":
                    for (int i = 0; i < list.size(); i++)
                        if (list.get(i).contains(id))
                            list.remove(i);
                        break;
            }
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++){
                bufferedWriter.write(list.get(i));
            bufferedWriter.newLine();}

            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }
}
