package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        String[] tempData;
        Map<String, Double> scarList = new TreeMap<>();

        while (reader.ready())
        {
            line = reader.readLine();
            tempData = line.split(" ");
            if (scarList.containsKey(tempData[0]))
                scarList.replace(tempData[0],scarList.get(tempData[0]) + Double.parseDouble(tempData[1]));
            else scarList.put(tempData[0], Double.parseDouble(tempData[1]));
        }
        reader.close();
        fileReader.close();

        double maxVaulue = 0;
        for (Map.Entry<String, Double> pair : scarList.entrySet()) {
            if (pair.getValue()> maxVaulue)
                maxVaulue = pair.getValue();
        }
        for (Map.Entry<String, Double> pair : scarList.entrySet()) {
            if (pair.getValue().equals(maxVaulue))
                System.out.println(pair.getKey());
        }
    }
}
